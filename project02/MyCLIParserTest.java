import junit.framework.TestCase;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class MyCLIParserTest extends TestCase {

    ByteArrayOutputStream outContent;
    ByteArrayOutputStream errContent;

    /**
     * Prepare to capture command line output.
     */
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    /**
     * Test addition with 3 numbers.
     */
    public void testMain() {
    MyCLIParser.main(new String[0]);
    }

    public void testAdd_00() {
        
        // Perform test.
        MyCLIParser.main(new String[]{"-add", "2", "4", "8"});
        assertTrue(outContent.toString().matches("14\\r?\\n"));

    }

    /**
     * Test addition with 1 number.
     */
    public void testAdd_01() {
        MyCLIParser.main(new String[]{"-add", "2"});
        assertTrue(outContent.toString().matches("2\\r?\\n"));
    }

    /**
     * Test addition with no arguments.
     */
    public void testAdd_02() {
        MyCLIParser.main(new String[]{"-add"});
        assertTrue(outContent.toString().matches("Argument count mismatch\\r?\\n"));
    }

    /**
     * Test addition with non-int argument.
     */
    public void testAdd_03() {
        MyCLIParser.main(new String[]{"-add", "Argh!"});
        assertTrue(outContent.toString().matches("Argument type mismatch\\r?\\n"));
    }
  
    /**
     * Test subtraction with 2 numbers.
     */
    public void testSub_00() {
        MyCLIParser.main(new String[]{"-sub", "4", "2"});
        assertTrue(outContent.toString().matches("2\\r?\\n"));
    }

    /**
     * Test subtraction with 1 number.
     */
    public void testSub_01() {
        MyCLIParser.main(new String[]{"-sub", "5"});
        assertTrue(outContent.toString().matches("Argument count mismatch\\r?\\n"));
    }

    /**
     * Test subtraction with no arguments.
     */
    public void testSub_02() {
        MyCLIParser.main(new String[]{"-sub"});
        assertTrue(outContent.toString().matches("Argument count mismatch\\r?\\n"));
    }

    /**
     * Test subtraction with non-int argument.
     */
    public void testSub_03() {
        MyCLIParser.main(new String[]{"-sub", "10", "Argh!"});
        assertTrue(outContent.toString().matches("Argument type mismatch\\r?\\n"));
    }
    
    public void testSub_04() {
        MyCLIParser.main(new String[]{"-sub", "Argh!", "15"});
        assertTrue(outContent.toString().matches("Argument type mismatch\\r?\\n"));
    }
    /**
     * Test multiplication with 3 numbers.
     */
    public void testMul_00() {
        MyCLIParser.main(new String[]{"-mul", "3", "2"});
        assertTrue(outContent.toString().matches("6\\r?\\n"));
    }

    /**
     * Test multiplication with 1 number.
     */
    public void testMul_01() {
        MyCLIParser.main(new String[]{"-mul", "2"});
        assertTrue(outContent.toString().matches("2\\r?\\n"));
    }

    /**
     * Test multiplication with no arguments.
     */
    public void testMul_02() {
        MyCLIParser.main(new String[]{"-mul"});
        assertTrue(outContent.toString().matches("Argument count mismatch\\r?\\n"));
    }

    /**
     * Test multiplication with non-int argument.
     */
    public void testMul_03() {
        MyCLIParser.main(new String[]{"-mul", "Argh!"});
        assertTrue(outContent.toString().matches("Argument type mismatch\\r?\\n"));
    }
  
    /**
     * Test division with 2 numbers.
     */
    public void testDiv_00() {
        MyCLIParser.main(new String[]{"-div", "5", "2"});
        assertTrue(outContent.toString().matches("2.50\\r?\\n"));
    }

    /**
     * Test division with 1 number.
     */
    public void testDiv_01() {
        MyCLIParser.main(new String[]{"-div", "10"});
        assertTrue(outContent.toString().matches("Argument count mismatch\\r?\\n"));
    }

    /**
     * Test division with no arguments.
     */
    public void testDiv_02() {
        MyCLIParser.main(new String[]{"-div"});
        assertTrue(outContent.toString().matches("Argument count mismatch\\r?\\n"));
    }

    /**
     * Test division with non-int argument.
     */
    public void testDiv_03() {
        MyCLIParser.main(new String[]{"-div", "15", "Argh!"});
        assertTrue(outContent.toString().matches("Argument type mismatch\\r?\\n"));
    }
    public void testDiv_04() {
        MyCLIParser.main(new String[]{"-div", "Argh!", "15"});
        assertTrue(outContent.toString().matches("Argument type mismatch\\r?\\n"));
    }
    /**
     * Test division with a divisor of 0.
     */
    public void testDiv_05() {
        MyCLIParser.main(new String[]{"-div", "45", "0"});
        assertTrue(outContent.toString().matches("undefined\\r?\\n"));
    }
  
    /**
     * Test statistics with 3 numbers.
     */
    public void testStats_00() {
        MyCLIParser.main(new String[]{"-stats", "1", "2", "3"});
        assertTrue(outContent.toString().matches("6\n3\n1\n2.00\\r?\\n"));
    }

    /**
     * Test statistics with 1 number.
     */
    public void testStats_01() {
        MyCLIParser.main(new String[]{"-stats", "1"});
        assertTrue(outContent.toString().matches("1\n1\n1\n1.00\\r?\\n"));
    }

    /**
     * Test statistics with no arguments.
     */
    public void testStats_02() {
        MyCLIParser.main(new String[]{"-stats"});
        assertTrue(outContent.toString().matches("Argument count mismatch\\r?\\n"));
    }

    /**
     * Test statistics with non-int argument.
     */
    public void testStats_03() {
        MyCLIParser.main(new String[]{"-stats", "Argh!"});
        assertTrue(outContent.toString().matches("Argument type mismatch\\r?\\n"));
    }

    /**
     * Test table with 1 number.
     */
    public void testTable_00() {
        
        // Perform test.
        MyCLIParser.main(new String[]{"-table", "8"});
        assertTrue
            (outContent.toString().matches
                 ("     8     8     8     8     8     8     8     8     8     8\\r?\\n" +
                  "     8     9    10    11    12    13    14    15    16    17\\r?\\n" +
                  "     8    10    12    14    16    18    20    22    24    26\\r?\\n" +
                  "     8    11    14    17    20    23    26    29    32    35\\r?\\n" +
                  "     8    12    16    20    24    28    32    36    40    44\\r?\\n" +
                  "     8    13    18    23    28    33    38    43    48    53\\r?\\n" +
                  "     8    14    20    26    32    38    44    50    56    62\\r?\\n" +
                  "     8    15    22    29    36    43    50    57    64    71\\r?\\n" +
                  "     8    16    24    32    40    48    56    64    72    80\\r?\\n" +
                  "     8    17    26    35    44    53    62    71    80    89\\r?\\n"));
    }

    /**
     * Test table with no arguments.
     */
    public void testTable_01() {
        MyCLIParser.main(new String[]{"-table"});
        assertTrue(outContent.toString().matches("Argument count mismatch\\r?\\n"));
    }

    /**
     * Test table with non-int argument.
     */
    public void testTable_02() {
        MyCLIParser.main(new String[]{"-table", "Argh!"});
        assertTrue(outContent.toString().matches("Argument type mismatch\\r?\\n"));
    }

    public void tearDown() {
        // Clean up console I/O.
        System.setOut(null);
        System.setErr(null);
    }
  
}
