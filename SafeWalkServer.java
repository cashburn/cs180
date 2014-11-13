import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class SafeWalkServer implements Runnable {
    private int port;
    Socket currentSocket;
    Socket firstSocket;
    ArrayList<Socket> sockets = new ArrayList<Socket>();
    ArrayList<String[]> requests = new ArrayList<String[]>();
    
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
            ServerSocket serverSocket = new ServerSocket(4242);
            while (true) {
                currentSocket = serverSocket.accept();
                sockets.add(currentSocket);
                input();
            }
        }
        catch (IOException e) {
        }
    }
    public void input() {
        try {
            PrintWriter pw = new PrintWriter(currentSocket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(currentSocket.getInputStream()));
            String line;
            boolean done = false;
            while ((line = in.readLine()) != null) {
                if (line.charAt(0) == ':') {
                    pw.println(commands(line));
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
    public String commands(String command) {
        String list;
        if (command.equals(":LIST_PENDING_REQUESTS")) {
            for (int i = 0; i < requests.size(); i++) {
                list += requests.get(i)[1];
            }
            
            return list;
        }
    }
    
    public static void main(String[] args) throws SocketException, IOException {
        SafeWalkServer server = new SafeWalkServer(4242);
        ServerSocket serverSocket = new ServerSocket(4242);
        server.run();
    }
}