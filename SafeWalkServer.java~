import java.io.*;
import java.net.*;

public class SafeWalkServer implements Runnable {
    private int port;
    Socket currentSocket;
    Socket firstSocket;
    public SafeWalkServer(int port) throws SocketException, IOException {
        this.port = port;
    }
    public SafeWalkServer() throws SocketException, IOException {
        port = 0;
    }
    
    public int getLocalPort() {
        return port;
    }
    
    public void run() {
        try {
            PrintWriter pw = new PrintWriter(currentSocket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(currentSocket.getInputStream()));
            String line;
            boolean done = false;
            while ((line = in.readLine()) != null) {
                if (line.equals("Next")) {
                    done = true;
                    break;
                }
                System.out.printf("&s says: %s%n", currentSocket);
                pw.printf("echo: %s%n", line);
                pw.flush();
            }
            if (!done) {
                pw.close();
                in.close();
                currentSocket.close();
                currentSocket = firstSocket;
                run();
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws SocketException, IOException {
        SafeWalkServer server = new SafeWalkServer(4242);
        ServerSocket serverSocket = new ServerSocket(4242);
        while (true) {
            if (server.currentSocket == null) 
                server.firstSocket = server.currentSocket = serverSocket.accept();
            else
                server.currentSocket = serverSocket.accept();
            server.run();
        }
    }
}