import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProcessFile {
    public static void main(String[] args) throws FileNotFoundException {
        LinkedList list = new LinkedList();

        Scanner in = new Scanner(new File("LinkedList.java"));
        while (in.hasNextLine()) {
            list.add(in.nextLine());
        }

        System.out.printf("read %d lines\n", list.getSize());
        String[] array = list.toArray();
        for (int i = 0; i < 10; i++)
            System.out.println(array[i]);
    }
}