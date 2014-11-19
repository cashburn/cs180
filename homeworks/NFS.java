import java.util.Scanner;
public class NFS {
    
    public static void main(String[] args) {
        System.out.println("Input Circumference: ");
        Scanner input = new Scanner(System.in);
        double circumference = input.nextDouble();
        double diameter = circumference / Math.PI;
        System.out.printf("%.2f\n", diameter);
    }
}