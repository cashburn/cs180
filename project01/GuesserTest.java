import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests each possible return value from the Guesser class.
 * 
 * @author Colin Ashburn <cashburn@purdue.edu>
 * @version 2014-09-25
 */

public class GuesserTest {
    /**
     * Tests each possible return value from the Guesser class.
     */
    @Test
    public void testGuesser() {
        // TODO test Guesser.play method
        // TODO hint: you can use the GuessWhoGame(int) constructor
        for (int i = 0; i < 27; i++) {
            GuessWhoGame g = new GuessWhoGame(i);
            assert (g.guess(Guesser.play(g)));
        }
    }

    /**
     * call the main method to satisfy WebCAT.
     */
    @Test
    public void testMain() {
        Guesser.main(new String[0]);
    }
    /**
     * call the constructor to satisfy WebCAT.
     */
    @Test
    public void testConstructor() {
        new Guesser();
    }
}
