import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class StringManipulatorTest extends TestCase {
  
  /**
   * Test the basic functionality of makeUserName
   * 
   * 
   * 
   */
  public void testMakeUserNameBasic() {
    StringManipulator m = new StringManipulator();
    String ret = m.makeUserName("john doe");
    assertEquals("jdoe", ret);
  }
  
  public void testMakeUserNameLower() {
    StringManipulator m = new StringManipulator();
    String ret = m.makeUserName("John Doe");
    assertEquals("jdoe", ret);
  }
  
  public void testMakeEmail() {
    StringManipulator m = new StringManipulator();
    String ret = m.makeEmail("jdoe", "@purdue.edu");
    assertEquals("jdoe@purdue.edu", ret);
  }
  
  
}
