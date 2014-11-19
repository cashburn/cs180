/**
 * Project 05
 * @author Colin Ashburn, cashburn, 807
 */
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class SafeWalkServer implements Runnable {
    ServerSocket serverSocket;
    private boolean exit;
    private int port;
    Socket currentSocket;
    Socket firstSocket;
    ArrayList<Socket> sockets = new ArrayList<Socket>();
    ArrayList<String[]> requests = new ArrayList<String[]>();
    
    public SafeWalkServer(int port) throws SocketException, IOException {
        serverSocket = new ServerSocket(port);
        this.port = port;
    }
    public SafeWalkServer() throws SocketException, IOException {
        serverSocket = new ServerSocket(0);
        port = serverSocket.getLocalPort();
    }
    
    public int getLocalPort() {
        return port;
    }
    
    public void run() {
        try {
            while (!exit) {
                currentSocket = serverSocket.accept();
                sockets.add(currentSocket);
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
            line = in.readLine();
                if (line.equals(":LIST_PENDING_REQUESTS")) {
                    String output = "[";
                    for (int i = 0; i < requests.size(); i++) {
                        output += "[" + toString1(requests.get(i));
                         if (i < (requests.size() - 1))
                             output += "], ";
                    }
                    output += "]]";
                    pw.println(output);
                    pw.flush();
                }
                else if (line.equals(":RESET")) {
                    while (requests.size() > 0 || sockets.size() > 0) {
                        
                        
                            pw.println("RESPONSE: success");
                            pw.flush();
                        
                        if (!(sockets.get(0) == currentSocket)) {
                            
                            try {
                                PrintWriter pw2 = new PrintWriter(sockets.get(0).getOutputStream());
                                pw2.println("ERROR: connection reset");
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
                }
                else if (line.equals(":SHUTDOWN")) {
                    while (requests.size() > 0 || sockets.size() > 0) {
                        
                            pw.println("RESPONSE: success");
                            pw.flush();

                            if (!(currentSocket == sockets.get(0))) {
                            try {
                                PrintWriter pw2 = new PrintWriter(sockets.get(0).getOutputStream());
                                pw2.println("ERROR: connection reset");
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
                }
                else {
                    int n = -1;
                    String[] temp = fromString(line);
                    if (isCorrect(temp)) {
                        for (int i = 0; i < requests.size(); i++) {
                            if (requests.get(i)[1].equals(temp[1]) && (!(requests.get(i)[2].equals("*") && temp[2].equals("*"))) && (n == -1))
                                if (requests.get(i)[2].equals(temp[2]) || requests.get(i)[2].equals("*") || temp[2].equals("*"))
                                    n = i;
                        }
                        if (n == -1)
                            requests.add(temp);
                        
                        else {
                            pw.println("RESPONSE: " + toString(requests.get(n)));
                            pw.flush();
                            pw.close();
                            in.close();
                            sockets.get(sockets.size() - 1).close();
                            sockets.remove(sockets.size() - 1);
                            PrintWriter pw2 = new PrintWriter(sockets.get(n).getOutputStream());
                            pw2.println("RESPONSE: " + line);
                            if (requests.size() > 0)
                                requests.remove(n);
                            pw2.flush();
                            pw2.close();
                            sockets.get(n).close();
                            sockets.remove(n);
                        }
                    }
                    else {
                        pw.println("ERROR: invalid request");
                        pw.flush();
                    }   
                }
            
            if (exit) {
                pw.close();
                in.close();
                currentSocket.close();
            }
        } catch (IOException e) {
        }
        
    }
    public boolean isCorrect(String[] input) {
        String[] list = { "CL50","EE","LWSN","PMU","PUSH","*" };
        boolean isCorrect;
        boolean isCorrect1 = false;
        boolean isCorrect2 = false;
        if (input[0] != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].equals(input[1]))
                    isCorrect1 = true;
                if (list[i].equals(input[2]))
                    isCorrect2 = true;
            }
            isCorrect = isCorrect1 && isCorrect2 && (!input[1].equals(input[2]));
            if (isCorrect && (!input[1].equals("*"))) {
                int test;
                try {
                    test = Integer.parseInt(input[3]);
                }
                catch (NumberFormatException e) {
                    return false;
                }
                if (test == 0 || test == 1 || test == 2)
                    return true;
               
            }
        }
        return false;
    }
    public String toString1(String[] input) {
        String toString = "";
        for (int i = 0; i < input.length; i++) {
            toString += input[i];
            if (i < (input.length - 1))
                toString += ", ";
        }
        return toString;
    }
    public String toString(String[] input) {
        String toString = "";
        for (int i = 0; i < input.length; i++) {
            toString += input[i];
            if (i < (input.length - 1))
                toString += ",";
        }
        return toString;
    }
    public static String[] fromString(String input) {
        int beg = 0;
        int i = 0;
        int end;
        String[] output = new String[4];
        while (input.contains(",")) {
            end = input.indexOf(',');
            output[i] = input.substring(0,end);
            input = input.substring(end + 1);
            beg = end;
            i++;
        }
        output[3] = input;
        return output;
    }
    public static void main(String[] args) throws SocketException, IOException {
        SafeWalkServer server;
        int i;
        if (args.length == 1) {
            try {
                i = Integer.parseInt(args[0]);
                server = new SafeWalkServer(i);
            }
            catch(NumberFormatException|BindException b) {
                System.out.println("Incorrect port specification.");
                return;
            }
        }
        else {
            server = new SafeWalkServer();
            System.out.printf("Port not specified. Using free port %s%n",server.port);
        }
        server.run();
    }
}