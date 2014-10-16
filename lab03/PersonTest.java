import junit.framework.TestCase;

/**
 * CS180 - Lab 03 - PersonTest.java
 * 
 * A JUnit test case to test functionality of the Person class.
 * 
 * @author Colin Ashburn <cashburn@purdue.edu>
 * @lab 807
 * @date 2014-09-16
 */
public class PersonTest extends TestCase {
    
    private Person adult_badTC;
    private Person adult_goodTC;
    private Person child_badTC;
    private Person child_goodTC;
    private Person adult_badHDL;
    private Person adult_goodHDL;
    private Person child_badHDL;
    private Person child_goodHDL;
    private Person adult_badLDL;
    private Person adult_goodLDL;
    private Person child_badLDL;
    private Person child_goodLDL;
    
    /**
     * set up the test case, called before each test
     */
    
    protected void setUp() throws Exception {
        super.setUp();
        adult_badTC = new Person("bad01",21,200,39,100);
        adult_badHDL = new Person("bad02",21,200,39,100);
        adult_badLDL = new Person("bad03",21,200,39,100);
        child_badTC = new Person("bad04",16,200,39,100);
        child_badHDL = new Person("bad05",16,200,39,100);
        child_badLDL = new Person("bad06",16,200,39,100);
        adult_goodTC = new Person("good01",21,100,42,20);
        adult_goodHDL = new Person("good02",21,100,42,10);
        adult_goodLDL = new Person("good03",21,100,42,10);
        child_goodTC = new Person("good04",16,100,42,10);
        child_goodHDL = new Person("good05",16,100,42,10);
        child_goodLDL = new Person("good06",16,100,42,10);
    }
    /**
     * A method to test getTotalCholesterol() in the Person class.
     */
    public void testGetTotalCholesterol() {
        assertEquals(339,adult_badTC.getTotalCholesterol());
        assertEquals(152,child_goodTC.getTotalCholesterol());
    }
    
    /**
    * A method to test hasGoodTotalCholesterol() in the Person class.
    */
    public void testHasGoodTotalCholesterol() {
        assertTrue(adult_goodTC.hasGoodTotalCholesterol());
        assertFalse(adult_badTC.hasGoodTotalCholesterol());
        assertTrue(child_goodTC.hasGoodTotalCholesterol());
        assertFalse(child_badTC.hasGoodTotalCholesterol());
    }
    /**
    * A method to test hasGoodHDL() in the Person class.
    */
    public void testHasGoodHDL() {
        assertTrue(adult_goodHDL.hasGoodHDL());
        assertFalse(adult_badHDL.hasGoodHDL());
        assertTrue(child_goodHDL.hasGoodHDL());
        assertFalse(child_badHDL.hasGoodHDL());
    }
    /**
    * A method to test hasGoodLDL() in the Person class.
    */
    public void testHasGoodLDL() {
        assertTrue(adult_goodLDL.hasGoodLDL());
        assertFalse(adult_badLDL.hasGoodLDL());
        assertTrue(child_goodLDL.hasGoodLDL());
        assertFalse(child_badLDL.hasGoodLDL());
    }
    
}
