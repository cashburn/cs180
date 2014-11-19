import java.io.*;
import java.net.*;
public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(4242);
        Socket socket = serverSocket.accept();
    }
}