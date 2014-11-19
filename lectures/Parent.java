import java.io.*;
public class TextIO {
    public static void main(String[] args) {
        File f = File.open("~/Documents/cs180/Server.java");
        FileReader fr = new FileReader(f);
        BufferedReader bfr = new BufferedReader(fr);
        while (true) {
            String s = bfr.readLine();
            if (s == null)
                break;
            System.out.println(s);
        }
        bfr.close();
    }
}