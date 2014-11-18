import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Client implements Runnable {
    final String host;
    final int port;
    final String message;
    boolean timeout = false;
    Client(String h, int p, String o) {
        host = h;
        port = p;
        message = o;
    }
    Client(String h, int p, String o, boolean t) {
        host = h;
        port = p;
        message = o;
	timeout = t;
    }
    String result = null;
    String getResult() {
        return result;
    }
    public void run() {
        try (
            Socket s = new Socket(host, port);
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        ) {
	    if (timeout) s.setSoTimeout(1000);
            out.println(message);
            result = in.readLine();
        } catch (SocketTimeoutException e) {
	} catch (IOException e) {
            System.err.println(e);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Client c = new Client(args[0], Integer.parseInt(args[1]), args[2]);
        Thread t = new Thread(c);
        t.start();
        t.join();
        System.out.println(c.getResult());
    }
}
