import java.util.Stack;
import java.util.Scanner;
public class Evaluator {
    
    public static int evaluate(String expression) {
        String temp;
        int count = 0;
        Stack<Integer> stack = new Stack<Integer>();
        Scanner in = new Scanner(expression);
        while (in.hasNext()) {
            temp = in.next();
            try {
                stack.push(Integer.parseInt(temp));
                count++;
            }
            catch (NumberFormatException e) {
            }
            if (temp.equals("+")) {
                stack.push(add(stack.pop(), stack.pop()));
                count--;
            }
            if (temp.equals("-")) {
                stack.push(sub(stack.pop(), stack.pop()));
                count--;
            }
            if (temp.equals("/")) {
                stack.push(div(stack.pop(), stack.pop()));
                count--;
            }
            if (temp.equals("*")) {
                stack.push(mul(stack.pop(), stack.pop()));
                count--;
            }
            
        }
        in.close();
        if (count == 1)
            return stack.pop();
        return 0;
        
    }
    private static int add(int arg2, int arg1) {
        return arg1 + arg2;
    }
    private static int sub(int arg2, int arg1) {
        return arg1 - arg2;
    }
    private static int div(int arg2, int arg1) {
        return arg1 / arg2;
    }
    private static int mul(int arg2, int arg1) {
        return arg1 * arg2;
    }
}