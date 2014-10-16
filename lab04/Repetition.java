/**
 * CS 180 - Lab 04 - Repetition
 * 
 * @author Colin Ashburn <cashburn@purdue.edu>
 * 
 * @lab 807
 * 
 * @date 2014-09-23
 */
import java.util.Scanner;
public class Repetition {
    public static void main(String[] args) {
        even();
        System.out.println("These are all the even numbers from 0 to 100.");
        System.out.println();
        powers();
        System.out.println("These are all powers of two less than 1000.");
        System.out.println();
        alphabet();
        System.out.println("These are all of the letters of the alphabet.");
        System.out.println();
        testResults();
    }
    
    /**
     * even() method
     * Generate and print out all even numbers from 0 to 100 on the same line.
     */
    public static void even() {
        String even = "";
        for (int n = 0; n < 51; n++) {
            even = even + " " + 2 * n;
        }
        System.out.println(even);
    }
    /**
     * powers() method
     * 1. Declare an integer exp (exponent) and initialize it with value 0.
     * 2. Iterate over all values of 2^exp that are less than 1000.
     * 
     */
    public static void powers() {
        int exp = 0;
        String power = "";
        double n = Math.pow(2, exp);
        do {
            power = power + " " + n;
            exp++;
            n = Math.pow(2, exp);
        } while (n < 1000);
        System.out.println(power);
    }
    /**
     * alphabet() method
     * Print out the alphabet using Chars and a for() loop.
     * 
     */
    public static void alphabet() {
        char letter;
        String alphabet = "";
        for (letter = 97; letter <= 'z'; letter++) {
            alphabet = alphabet + letter;
        }
        System.out.println(alphabet);
    }
    /**
     * vertical() method
     * Print out every letter of string s on a separate line.
     * 
     */
    public static void vertical (String s) {
        int end = s.length();
        for (int n = 0; n < end; n++) {
            System.out.println(s.charAt(n));
        }
    }
    /**
     * testResults() method
     * Print test result summary.
     */ 
    public static void testResults() {
        System.out.println("Enter scores now: ");
        Scanner in = new Scanner(System.in);
        int sum = 0, n = 0, lowest = 100, highest = 0, temp = 0;
            while (in.hasNextInt() == true) {
                n++;
                temp = in.nextInt();
                sum = sum + temp;
                if (lowest > temp) {
                    lowest = temp;
                }
                if (highest < temp) {
                    highest = temp;
                }
            }
            int mean = sum / n;
            System.out.println("=====-----=====-----=====-----=====");
            System.out.println("            Test Results         ");
            System.out.println(" Average:                     " + mean);
            System.out.println(" Lowest:                      " + lowest);
            System.out.println(" Highest:                     " + highest);
            System.out.println("=====-----=====-----=====-----=====");
    }
}
