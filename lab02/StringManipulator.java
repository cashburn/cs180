/**
 * CS 180 - Lab 02 - StringManipulator
 * 
 * To create a Purdue email address based on a person's full name.
 * 
 * @author Colin Ashburn <cashburn@purdue.edu>
 * 
 * @lab (Your lab section)
 *
 * @date 2014-09-09
 */
import java.util.Scanner;
public class StringManipulator {
  public String makeUserName(String fullName) {
    
    String lowerName = fullName.toLowerCase();
    int space = lowerName.indexOf(' ');
    String userName = lowerName.charAt(0) + lowerName.substring(space + 1);
    return userName;
  }
  
  public String makeEmail(String userName, String domain) {
    String email = userName.concat(domain);
    return email;
  }

  public static void main(String[] args) {
    
    StringManipulator stringer = new StringManipulator();
    Scanner input = new Scanner(System.in);
    System.out.printf("Enter full name: ");
    String userName = input.nextLine();
    userName = stringer.makeUserName(userName);
    System.out.printf("Enter the domain: ");
    String domain = input.nextLine();
    String email = "@" + domain.toLowerCase();
    email = stringer.makeEmail(userName, email);
    System.out.println("User Name: " + userName);
    System.out.println("Email: " + email);
   
  
  }
  
  
}