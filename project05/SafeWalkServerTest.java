import org.junit.*;
import static org.junit.Assert.*;
import java.net.SocketTimeoutException;
import java.io.IOException;

public class SafeWalkServerTest {
 final String ERR_INVALID_REQUEST = "ERROR: invalid request";
 final String HOST = "localhost";
 
 /**
  * Send an invalid command. 
  **/
 @Test
 public void testInvalidCommand() throws InterruptedException, IOException {
  SafeWalkServer s = new SafeWalkServer();
  int port = s.getLocalPort();
  Thread st = new Thread(s);
  st.start();

  Client c1 = new Client(HOST, port, ":INVALID_COMMAND");
         Thread ct1 = new Thread(c1);
         ct1.start();
  ct1.join();

  assertEquals(ERR_INVALID_REQUEST, c1.getResult());

  Client c2 = new Client(HOST, port, ":SHUTDOWN");
         Thread ct2 = new Thread(c2);
         ct2.start();
  ct2.join();
  st.join();
 }

 /**
  * Test :RESET. 
  **/
 @Test
 public void testReset() throws InterruptedException, IOException {
  SafeWalkServer s = new SafeWalkServer();
  int port = s.getLocalPort();
  Thread st = new Thread(s);
  st.start();

  Client c1 = new Client(HOST, port, "Danushka,LWSN,PUSH,0");
         Thread ct1 = new Thread(c1);
         ct1.start();

  Thread.sleep(100);

  Client c2 = new Client(HOST, port, ":RESET");
         Thread ct2 = new Thread(c2);
         ct2.start();

  ct1.join();
  ct2.join();
 
  assertEquals("ERROR: connection reset", c1.getResult());
  assertEquals("RESPONSE: success", c2.getResult());
 
  Client c3 = new Client(HOST, port, ":SHUTDOWN");
         Thread ct3 = new Thread(c3);
         ct3.start();
  ct3.join();
  st.join();
 }
 
 /**
  * Test :LIST_PENDING_REQUESTS. 
  **/
 @Test
 public void testListPendingRequests() throws InterruptedException, IOException {
  SafeWalkServer s = new SafeWalkServer();
  int port = s.getLocalPort();
  Thread st = new Thread(s);
  st.start();

  Client c1 = new Client(HOST, port, "Danushka,LWSN,PUSH,0", true);
         Thread ct1 = new Thread(c1);
         ct1.start();

  Thread.sleep(100);

  Client c2 = new Client(HOST, port, ":LIST_PENDING_REQUESTS");
         Thread ct2 = new Thread(c2);
         ct2.start();

  ct1.join();
  ct2.join();
  
  assertEquals("[[Danushka, LWSN, PUSH, 0]]", c2.getResult());
 
  Client c3 = new Client(HOST, port, ":SHUTDOWN");
         Thread ct3 = new Thread(c3);
         ct3.start();
  ct3.join();
  st.join();
 }
 
 /**
  * Test request order for :LIST_PENDING_REQUESTS. 
  **/
 @Test
 public void testListPendingRequestsOrder() throws InterruptedException, IOException {
  SafeWalkServer s = new SafeWalkServer();
  int port = s.getLocalPort();
  Thread st = new Thread(s);
  st.start();

  Client c1 = new Client(HOST, port, "Danushka,LWSN,PUSH,0", true);
         Thread ct1 = new Thread(c1);
         ct1.start();

  Thread.sleep(100);

  Client c2 = new Client(HOST, port, "Dinushi,LWSN,EE,0", true);
         Thread ct2 = new Thread(c2);
         ct2.start();

  ct1.join();
  ct2.join();
 
  Client c3 = new Client(HOST, port, ":LIST_PENDING_REQUESTS");
         Thread ct3 = new Thread(c3);
         ct3.start();
  ct3.join();
  
  assertEquals("[[Danushka, LWSN, PUSH, 0], [Dinushi, LWSN, EE, 0]]", c3.getResult());
 
  Client c4 = new Client(HOST, port, ":SHUTDOWN");
         Thread ct4 = new Thread(c4);
         ct4.start();
  ct4.join();
  st.join();
 }

 /**
  * Test :SHUTDOWN. 
  **/
 @Test
 public void testShutdown() throws InterruptedException, IOException {
  SafeWalkServer s = new SafeWalkServer();
  int port = s.getLocalPort();
  Thread st = new Thread(s);
  st.start();

  Client c1 = new Client(HOST, port, "Danushka,LWSN,PUSH,0");
         Thread ct1 = new Thread(c1);
         ct1.start();

  Thread.sleep(100);

  Client c2 = new Client(HOST, port, ":SHUTDOWN");
         Thread ct2 = new Thread(c2);
         ct2.start();
  
  ct1.join();
  ct2.join();
  st.join();
 
  assertEquals("ERROR: connection reset", c1.getResult());
  assertEquals("RESPONSE: success", c2.getResult());
 }
 
 /**
  * Test a request with an invalid FROM. 
  **/
 @Test
 public void testInvalidFrom() throws InterruptedException, IOException {
  SafeWalkServer s = new SafeWalkServer();
  int port = s.getLocalPort();
  Thread st = new Thread(s);
  st.start();

  Client c1 = new Client(HOST, port, "Danushka,FROM,PUSH,0");
         Thread ct1 = new Thread(c1);
         ct1.start();
  ct1.join();

  assertEquals(ERR_INVALID_REQUEST, c1.getResult());
  
  Client c2 = new Client(HOST, port, ":SHUTDOWN");
         Thread ct2 = new Thread(c2);
         ct2.start();
  
  ct2.join();
  st.join();
 }
 
 /**
  * Test a request with an invalid TO. 
  **/
 @Test
 public void testInvalidTo() throws InterruptedException, IOException {
  SafeWalkServer s = new SafeWalkServer();
  int port = s.getLocalPort();
  Thread st = new Thread(s);
  st.start();

  Client c1 = new Client(HOST, port, "Danushka,LWSN,TO,0");
         Thread ct1 = new Thread(c1);
         ct1.start();
  ct1.join();

  assertEquals(ERR_INVALID_REQUEST, c1.getResult());
  
  Client c2 = new Client(HOST, port, ":SHUTDOWN");
         Thread ct2 = new Thread(c2);
         ct2.start();
  
  ct2.join();
  st.join();
 }
 
 /**
  * Test sending a request with an invalid delimiter. 
  **/
 @Test
 public void testInvalidRequest1() throws InterruptedException, IOException {
  SafeWalkServer s = new SafeWalkServer();
  int port = s.getLocalPort();
  Thread st = new Thread(s);
  st.start();

  Client c1 = new Client(HOST, port, "Danushka:LWSN:TO:0");
         Thread ct1 = new Thread(c1);
         ct1.start();
  ct1.join();

  assertEquals(ERR_INVALID_REQUEST, c1.getResult());
  
  Client c2 = new Client(HOST, port, ":SHUTDOWN");
         Thread ct2 = new Thread(c2);
         ct2.start();
  
  ct2.join();
  st.join();
 }
 
 /**
  * Test sending a request with an invalid number of fields. 
  **/
 @Test
 public void testInvalidRequest2() throws InterruptedException, IOException {
  SafeWalkServer s = new SafeWalkServer();
  int port = s.getLocalPort();
  Thread st = new Thread(s);
  st.start();

  Client c1 = new Client(HOST, port, "Danushka,LWSN,0");
         Thread ct1 = new Thread(c1);
         ct1.start();
  ct1.join();

  assertEquals(ERR_INVALID_REQUEST, c1.getResult());
  
  Client c2 = new Client(HOST, port, ":SHUTDOWN");
         Thread ct2 = new Thread(c2);
         ct2.start();
  
  ct2.join();
  st.join();
 }

 /**
  * Test sending a request with FROM = *. 
  **/
 @Test
 public void testFromStar() throws InterruptedException, IOException {
  SafeWalkServer s = new SafeWalkServer();
  int port = s.getLocalPort();
  Thread st = new Thread(s);
  st.start();

  Client c1 = new Client(HOST, port, "Danushka,*,PUSH,0");
         Thread ct1 = new Thread(c1);
         ct1.start();
  ct1.join();

  assertEquals(ERR_INVALID_REQUEST, c1.getResult());
  
  Client c2 = new Client(HOST, port, ":SHUTDOWN");
         Thread ct2 = new Thread(c2);
         ct2.start();
  
  ct2.join();
  st.join();
 }

 /**
  * Test sending a request with FROM = TO. 
  **/
 @Test
 public void testToEqualsFrom() throws InterruptedException, IOException {
  SafeWalkServer s = new SafeWalkServer();
  int port = s.getLocalPort();
  Thread st = new Thread(s);
  st.start();

  Client c1 = new Client(HOST, port, "Danushka,PUSH,PUSH,0");
         Thread ct1 = new Thread(c1);
         ct1.start();
  ct1.join();

  assertEquals(ERR_INVALID_REQUEST, c1.getResult());
  
  Client c2 = new Client(HOST, port, ":SHUTDOWN");
         Thread ct2 = new Thread(c2);
         ct2.start();
  
  ct2.join();
  st.join();
 }

 /**
  * Test a scenario where there is an exact match. 
  **/
 @Test
 public void testExactMatch() throws InterruptedException, IOException {
  SafeWalkServer s = new SafeWalkServer();
  int port = s.getLocalPort();
  Thread st = new Thread(s);
  st.start();

  Client c1 = new Client(HOST, port, "Danushka,LWSN,PUSH,0");
         Thread ct1 = new Thread(c1);
         ct1.start();

  Client c2 = new Client(HOST, port, "Dinushi,LWSN,PUSH,0");
         Thread ct2 = new Thread(c2);
         ct2.start();
 
  ct1.join();
  ct2.join();
 
  assertEquals("RESPONSE: Dinushi,LWSN,PUSH,0", c1.getResult());
  assertEquals("RESPONSE: Danushka,LWSN,PUSH,0", c2.getResult());
  
  Client c3 = new Client(HOST, port, ":SHUTDOWN");
         Thread ct3 = new Thread(c3);
         ct3.start();
  
  ct3.join();
  st.join();
 }
 
 /**
  * Test a scenario where the second request has * as TO.. 
  **/
 @Test
 public void testAnyMatch() throws InterruptedException, IOException {
  SafeWalkServer s = new SafeWalkServer();
  int port = s.getLocalPort();
  Thread st = new Thread(s);
  st.start();

  Client c1 = new Client(HOST, port, "Danushka,LWSN,PUSH,0");
         Thread ct1 = new Thread(c1);
         ct1.start();

  Thread.sleep(100);

  Client c2 = new Client(HOST, port, "Dinushi,LWSN,*,0");
         Thread ct2 = new Thread(c2);
         ct2.start();
 
  ct1.join();
  ct2.join();
 
  assertEquals("RESPONSE: Dinushi,LWSN,*,0", c1.getResult());
  assertEquals("RESPONSE: Danushka,LWSN,PUSH,0", c2.getResult());
  
  Client c3 = new Client(HOST, port, ":SHUTDOWN");
         Thread ct3 = new Thread(c3);
         ct3.start();
  
  ct3.join();
  st.join();
 }
 
 /**
  * Same as "testAnyMatch" but with a different order of requests. 
  **/
 @Test
 public void testAnyMatch2() throws InterruptedException, IOException {
  SafeWalkServer s = new SafeWalkServer();
  int port = s.getLocalPort();
  Thread st = new Thread(s);
  st.start();

  Client c1 = new Client(HOST, port, "Danushka,LWSN,*,0");
         Thread ct1 = new Thread(c1);
         ct1.start();

  Thread.sleep(100);

  Client c2 = new Client(HOST, port, "Dinushi,LWSN,PUSH,0");
         Thread ct2 = new Thread(c2);
         ct2.start();
 
  ct1.join();
  ct2.join();
 
  assertEquals("RESPONSE: Dinushi,LWSN,PUSH,0", c1.getResult());
  assertEquals("RESPONSE: Danushka,LWSN,*,0", c2.getResult());
  
  Client c3 = new Client(HOST, port, ":SHUTDOWN");
         Thread ct3 = new Thread(c3);
         ct3.start();
  
  ct3.join();
  st.join();
 }
 
 /**
  * Test first-come-first-serve. 
  **/
 @Test
 public void testFCFS() throws InterruptedException, IOException {
  SafeWalkServer s = new SafeWalkServer();
  int port = s.getLocalPort();
  Thread st = new Thread(s);
  st.start();

  Client c1 = new Client(HOST, port, "Dihein,LWSN,PUSH,0");
         Thread ct1 = new Thread(c1);
         ct1.start();

  Thread.sleep(100);

  Client c2 = new Client(HOST, port, "Danushka,LWSN,EE,0", true);
         Thread ct2 = new Thread(c2);
         ct2.start();

  Thread.sleep(100);
  
  Client c3 = new Client(HOST, port, "Dinushi,LWSN,*,0");
         Thread ct3 = new Thread(c3);
         ct3.start();
 
  ct1.join();
  ct2.join();
  ct3.join();
 
  assertEquals("RESPONSE: Dinushi,LWSN,*,0", c1.getResult());
  assertEquals("RESPONSE: Dihein,LWSN,PUSH,0", c3.getResult());
  
  Client c4 = new Client(HOST, port, ":LIST_PENDING_REQUESTS");
         Thread ct4 = new Thread(c4);
         ct4.start();
  ct4.join();
  
  assertEquals("[[Danushka, LWSN, EE, 0]]", c4.getResult());
  
  Client c5 = new Client(HOST, port, ":SHUTDOWN");
         Thread ct5 = new Thread(c5);
         ct5.start();
  
  ct5.join();
  st.join();
 }
 
 /**
  * Test a scenario where there are two requests with TO = * but FROM is the same. 
  **/
 @Test
 public void testToBothStar() throws InterruptedException, IOException {
  SafeWalkServer s = new SafeWalkServer();
  int port = s.getLocalPort();
  Thread st = new Thread(s);
  st.start();

  Client c1 = new Client(HOST, port, "Danushka,LWSN,*,0", true);
         Thread ct1 = new Thread(c1);
         ct1.start();

  Thread.sleep(100);

  Client c2 = new Client(HOST, port, "Dinushi,LWSN,*,0", true);
         Thread ct2 = new Thread(c2);
         ct2.start();
 
  ct1.join();
  ct2.join();
 
  Client c3 = new Client(HOST, port, ":LIST_PENDING_REQUESTS");
         Thread ct3 = new Thread(c3);
         ct3.start();
  ct3.join();
  
  assertEquals("[[Danushka, LWSN, *, 0], [Dinushi, LWSN, *, 0]]", c3.getResult());
  
  Client c4 = new Client(HOST, port, ":SHUTDOWN");
         Thread ct4 = new Thread(c4);
         ct4.start();
  
  ct4.join();
  st.join();
 }
}
