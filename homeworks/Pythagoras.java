/**
 * CS180 - Lab 01
 * We will calculate the hypotenuse of a right triangle using the Pythagorean Theorem.
 * @author Colin Ashburn, <cashburn@purdue.edu>
 */
import java.util.Scanner;
public class Pythagoras {	
public static void main(String[] args) {
		Pythagoras p = new Pythagoras();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter side 'a': ");
		int a = scanner.nextInt();

		System.out.print("Enter side 'b': ");
		int b = scanner.nextInt();
		double h = p.getHypotenuse(a, b);
		System.out.println("Hypotenuse: " + h);
	}
	public double getHypotenuse(int a, int b) {
		double result;
		result = Math.sqrt(a*a+b*b);
		return result;
				
	}
		
}


