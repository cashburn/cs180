import java.util.Scanner;
public class Calculator {
    int sum(String s) {
        Scanner in = new Scanner(s);
        int temp = 0;
        while (in.hasNextInt() == true) {
            temp = temp + in.nextInt();
        }
        return temp;
    }
}