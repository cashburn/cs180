/*CS 180 - Groucho
 * (description)
 * 
 * @author Colin Ashburn <cashburn@purdue.edu>
 * @date 
 */

import java.util.Scanner;
public class Groucho {
    String secret;
    Groucho(String secret) {
        this.secret = secret;
    }
    boolean saysSecret(String line) {
        if (line.indexOf(secret) >= 0) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Groucho object = new Groucho(in.nextLine());
        
        while (in.hasNextLine() == true) {
            String line = in.nextLine();
            if (object.saysSecret(line) == true) {
                System.out.println("You have won $100!  The secret word was " + 
                                line + "!");
            
            }
            break;
        }  
        
    }
}
