import java.util.*;
public class MyCLIParser {
    public static void main(String[] args) {
        // if no arguments, print help and return
        if (args.length == 0) {
            help(args);
            return;
        }
        
        //-help
        else if (args[0].equals("-help"))  help(args);
        //-add
        else if (args[0].equals("-add"))   add(args);
        //-sub
        else if (args[0].equals("-sub"))   sub(args);
        //-mul
        else if (args[0].equals("-mul"))   mul(args);
        //-div
        else if (args[0].equals("-div"))   div(args);
        //-stats
        else if (args[0].equals("-stats")) stats(args);
        //-table
        else if (args[0].equals("-table")) table(args);
        
    }

    public static boolean isInteger(String s) {
        Scanner in = new Scanner(s);
        if (in.hasNextInt())
            return true;
        return false;
    }

    private static void help(String[] args) {
        System.out.println("-add");
        System.out.println("Prints the sum of one or more integers listed as arguments.");
        System.out.println("ex:  \"java MyCLIParser -add 3 5 7\"   Output: \"15\"");
        System.out.println();
        
        System.out.println("-sub");
        System.out.println("Subtracts the second integer argument from the first integer argument.");
        System.out.println("ex:  \"java MyCLIParser -sub 4 2\"   Output: \"2\"");
        System.out.println();
        
        System.out.println("-mul");
        System.out.println("Multiplies together one or more integers listed as arguments.");
        System.out.println("ex:  \"java MyCLIParser -mul 4 2 3\"   Output: \"24\"");
        System.out.println();
        
        System.out.println("-div");
        System.out.println("Divides the second integer argument by the first integer argument.");
        System.out.println("ex:  \"java MyCLIParser -div 5 2\"   Output: \"2.50\"");
        System.out.println();
        
        System.out.println("-stats");
        System.out.println("Performs a series of statistical calculations on integers listed as arguments.");
        System.out.println("Calculations printed (in this order): Total, Maximum, Minimum, Average");
        System.out.println("ex:  \"java MyCLIParser -stats 1 2 3 4\"   Output: ");
        System.out.println("10 \n 4 \n 1 \n 2.50");
        System.out.println();
        
        System.out.println("-table");
        System.out.println("Prints out a multiplication table with each value added to an integer argument.");
        System.out.println("ex:  \"java MyCLIParser -table 5\"   Output: ");
        String[] test = {"-table", "5"};
        table(test);
        System.out.println();
    }

    private static void add(String[] args) {
        if (args.length < 2) {
            System.out.println("Argument count mismatch");
            return;
        }
        int sum = 0;
        for (int i = 1; i < args.length; i++) {
            if (!isInteger(args[i])) {
                System.out.println("Argument type mismatch");
                return;
            }
            Scanner in = new Scanner(args[i]);
            sum += in.nextInt();
        }
        System.out.println(sum);
    }
       
    private static void sub(String[] args) {
        if (args.length != 3) {
            System.out.println("Argument count mismatch");
            return;
        }
        if (!isInteger(args[1]) | !isInteger(args[2])) {
            System.out.println("Argument type mismatch");
            return;
        }

        Scanner a = new Scanner(args[1]);
        Scanner b = new Scanner(args[2]);
        int sub = a.nextInt() - b.nextInt();
        System.out.println(sub);
    }

    private static void mul(String[] args) {
        if (args.length < 2) {
            System.out.println("Argument count mismatch");
            return;
        }
        int product = 1;
        for (int i = 1; i < args.length; i++) {
            if (!isInteger(args[i])) {
                System.out.println("Argument type mismatch");
                return;
            }
            Scanner in = new Scanner(args[i]);
            product *= in.nextInt();
        }
        System.out.println(product);
    }

    private static void div(String[] args) {
        if (args.length != 3) {
            System.out.println("Argument count mismatch");
            return;
        }
        if (!isInteger(args[1]) | !isInteger(args[2])) {
            System.out.println("Argument type mismatch");
            return;
        }
        if (args[2].equals("0")) {
            System.out.println("undefined");
            return;
        }
        Scanner a = new Scanner(args[1]);
        Scanner b = new Scanner(args[2]);
        
        double divide = (double) a.nextInt() / (double) b.nextInt();
        System.out.printf("%.2f\n", divide);
    }

    private static void stats(String[] args) {
        if (args.length < 2) {
            System.out.println("Argument count mismatch");
            return;
        }
        int total;
        int max;
        int min;
        total = 0;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        
        for (int i = 1; i < args.length; i++) {
            if (!isInteger(args[i])) {
                System.out.println("Argument type mismatch");
                return;
            }
            Scanner in = new Scanner(args[i]);
            int temp = in.nextInt();
            total += temp;
            max = Math.max(max, temp);
            min = Math.min(min, temp);
        }
        double average = (double) total / (double) (args.length - 1);
        System.out.println(total);
        System.out.println(max);
        System.out.println(min);
        System.out.printf("%.2f\n", average);
    }
    private static void table(String[] args) {
        if (args.length != 2) {
            System.out.println("Argument count mismatch");
            return;
        }
        if (!isInteger(args[1])) {
            System.out.println("Argument type mismatch");
            return;
        }
        Scanner in = new Scanner(args[1]);
        int temp = in.nextInt();
        int[][] table = new int[10][10];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = i * j;
            }
        }
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] += temp;
            }
        }
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.format("%6d", table[i][j]);
            }
            System.out.println();
        }
        
    }
}
