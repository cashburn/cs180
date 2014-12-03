import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Iterator;
public class ProcessFile {
    public static void main(String[] args) throws FileNotFoundException {
        LinkedList list = new LinkedList();

        Scanner in = new Scanner(new File("LinkedList.java"));
        while (in.hasNextLine()) {
            list.add(in.nextLine());
        }

        System.out.printf("read %d lines\n", list.getSize());
        //String[] array = list.toArray();
        //Iterator<String> i = list.iterator();
        for (Object string : list)
            System.out.println((String) string);
    }
}