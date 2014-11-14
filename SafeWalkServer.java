import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class SafeWalkServer {
    private boolean exit;
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
            System.out.println("4242");
            while (!exit) {
                currentSocket = serverSocket.accept();
                sockets.add(currentSocket);
                System.out.println(currentSocket);
                input();
            }
            serverSocket.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void input() {
        try {
            PrintWriter pw = new PrintWriter(currentSocket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(currentSocket.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.equals(":LIST_PENDING_REQUESTS")) {
                    for (int i = 0; i < requests.size(); i++)
                        pw.println(toString(requests.get(i)));
                }
                else if (line.equals(":RESET")) {
                    while (requests.size() > 0 || sockets.size() > 0) {
                        
                        if (sockets.get(0) == currentSocket) {
                            pw.println("RESPONSE: success");
                            pw.flush();
                        }
                        else {
                            
                            try {
                                PrintWriter pw2 = new PrintWriter(sockets.get(0).getOutputStream());
                                pw2.println("Error: connection reset");
                                pw2.flush();
                                pw2.close();
                                
                            }
                            catch (SocketException e) {
                            }
                        }
                            pw.close();
                            sockets.get(0).close();
                            if (requests.size() > 0)
                                requests.remove(0);
                            sockets.remove(0);
                    }
                    exit = true;
                    break;
                }
                else if (line.equals(":SHUTDOWN")) {
                    System.out.println("Shutdown");
                    while (requests.size() > 0 || sockets.size() > 0) {
                        sockets.get(0).close();
                        if (requests.size() > 0)
                            requests.remove(0);
                        sockets.remove(0);
                    }
                    exit = true;
                    break;
                }
                else {       
                    System.out.printf("&s says: %s%n", currentSocket);
                    pw.printf("echo: %s%n", line);
                    pw.flush();
                }
            }
            if (exit) {
                System.out.println("exit=true");
                pw.close();
                in.close();
                currentSocket.close();
            }
            System.out.println("Now?");
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
    }
    public String toString(String[] input) {
        String toString = "";
        for (int i = 0; i < input.length; i++)
            toString += input[i];
        return toString;
    }
    
    public static void main(String[] args) throws SocketException, IOException {
        SafeWalkServer server = new SafeWalkServer(4242);
        System.out.println("Anyone?");
        server.run();
        System.out.println("Hello?");
    }
}