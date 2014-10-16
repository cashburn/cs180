/**   
 * CS180 - Lab 03 - Person
 * 
 * This creates a person object that can be used to identify different people 
 * and to call whether or not their cholesterol levels are in the healthy range.
 * @author Colin Ashburn <cashburn@purdue.edu>
 * @lab 807
 * @date 2014-09-16
 */

public class Person {
    private String id;
    private int age;
    private int ldl;
    private int hdl;
    private int other;
    
    /**
     * Person Class Constructor: Creates a new instance of the person
     * and initializes instance variables with these arguments:
     */
    
    public Person(String id, int age, int ldl, int hdl, int other) {
        this.id = id;
        this.age = age;
        this.ldl = ldl;
        this.hdl = hdl;
        this.other = other;
    }
    /**
     * getTotalCholesterol: Calculates the sum of the given person's
     * LDL, HDL, and other.
     * @return given person's total cholesterol
     */
        
    public int getTotalCholesterol() {
        int tc = this.ldl + this.hdl + this.other;
        return tc;
    }
    
    /**
     * hasGoodTotalCholesterol: Determines whether the given person's
     * total cholesterol is within healthy levels.
     * @return healthy or not
     */
    
    public boolean hasGoodTotalCholesterol() {
        if (this.age >= 18) {
            if (getTotalCholesterol() < 200) {
                    return true;
            }   else {
                    return false;
            }
        }
        else if (getTotalCholesterol() < 170) {
            return true;
        }   else {
                return false;
            }
    }
    /**
     * hasGoodLDL: Determines whether the given person's
     * LDL is within healthy levels.
     * @return healthy or not
     */
            
    public boolean hasGoodLDL() {
        if (this.age >= 18) {
            if (this.ldl <= 130) {
                    return true;
            }   else {
                    return false;
            }
        }
        else if (this.ldl <= 110) {
            return true;
        }   else {
                return false;
            }
    }    
    /**
     * hasGoodHDL: Determines whether the given person's
     * HDL is within healthy levels.
     * @return healthy or not
     */
            
    public boolean hasGoodHDL() {
        return this.hdl >= 40; //I could rewrite the other methods in this way, so I will in the future.
    }
   
    /**
     * isAdult: Decides if the given person is an adult.
     * @return adult or not
     */
    
    public boolean isAdult() {
        return this.age >= 18;
    }
    
    /**
     * printReport: Prints all of the information about a given person.
     */
    
    public void printReport() {
        System.out.println(this.id + "'s Report");
        System.out.println("Age: " + this.age + " (" + (isAdult() ? "Adult" : "Child") + ")"); 
        System.out.println("Total Cholesterol: " + getTotalCholesterol() + " (" 
                               + (hasGoodTotalCholesterol() ? "Good" : "Bad") + ")");
                
        System.out.println("LDL: " + this.ldl + " (" + (hasGoodLDL() ? "Good" : "Bad") + ")");
        System.out.println("HDL: " + this.hdl + " (" + (hasGoodHDL() ? "Good" : "Bad") + ")");
    }
}
        
    