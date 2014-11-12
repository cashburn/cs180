<<<<<<< HEAD
import java.io.*;
import java.net.*;

public class EchoServer implements Runnable {
    
    final Socket socket;
    
    public EchoServer(Socket socket) {
        this.socket = socket;
    }
    /*public EchoServer() {
        socket = 0;
    }*/
    public void run() {
        System.out.printf("connection received from %s%n", socket);
        try {
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.printf("&s says: %s%n", socket, line);
                pw.printf("echo: %s%n", line);
                pw.flush();
            }
            pw.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4242);
        System.out.printf("socket open, waiting for connections on %s%n", serverSocket);
        while (true) {
            Socket socket = serverSocket.accept();
            EchoServer server = new EchoServer(socket);
            new Thread(server).start();
        }
    }
=======
import
java.io
.*;
import
java.net.ServerSocket
;
import
java.net.Socket
;
public class
EchoServer
implements Runnable {
final Socket socket;
public
EchoServer
(Socket socket) {
this.socket
= socket;
} 
 public
void
run
() {
System.out.
printf
(
"connection received from %
s%n
"
, socket);
try
{
// socket open: make
PrinterWriter
and Scanner from it...
PrintWriter
pw =
new
PrintWriter
(
socket.
getOutputStream
());
BufferedReader
in
=
new
BufferedReader
(
new
InputStreamReader
(
socket.
getInputStream
()));
// read from input, and echo output...
String line;
while
((line =
in
.
readLine
()) != null) {
System.out.
printf
(
"%s says: %
s%n
"
, socket, line);
pw.
printf
(
"echo: %
s%n
"
, line);
pw.
flush
();
}
//
input
done
,
close
connections
...
pw.
close
();
in
.
close
();
socket.
close
();
}
catch
(
IOException
e) {
e.
printStackTrace
();
}
>>>>>>> 8cbc174f9883d503f685b6811fcd56bd53a3779e
}