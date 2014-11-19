import java.util.Scanner;
public class Adder {
public static void main(String[] args) {
	Adder add = new Adder();
	Scanner input = new Scanner(System.in);
	System.out.print("Enter first integer: ");
	int a = input.nextInt();

	System.out.print("Enter second integer: ");
	int b = input.nextInt();
	int sum = add.sum(a,b);
	System.out.println("Sum: " + sum);
	}
public int sum(int a, int b) {
	int result;
	result = a + b;
	return result;
	}
}
