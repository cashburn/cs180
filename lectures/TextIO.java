import java.io.*;
public class TextIO {
    public static void main(String[] args) throws IOException {
        //File f = File.open("~/Documents/cs180/Server.java");
        BufferedReader bfr = new BufferedReader(new FileReader(args[0]));
        while (true) {
            String s = bfr.readLine();
            if (s == null)
                break;
            System.out.println(s);
        }
        bfr.close();
    }
}