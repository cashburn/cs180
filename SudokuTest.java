import junit.framework.TestCase;
import java.util.Arrays;
/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class SudokuTest extends TestCase {
    public static int[][] puzzleOneBoard = { { 0, 9, 7, 5, 0, 1, 8, 0, 0 }, 
    { 8, 0, 0, 0, 2, 0, 0, 0, 0 },
    { 1, 2, 0, 4, 0, 3, 0, 9, 0 },
    { 7, 5, 0, 0, 0, 0, 0, 2, 0 },
    { 0, 0, 4, 2, 0, 9, 3, 0, 0 },
    { 0, 8, 0, 0, 0, 0, 0, 1, 9 },
    { 0, 4, 0, 7, 0, 6, 0, 8, 5 },
    { 0, 0, 0, 0, 5, 0, 0, 0, 1 },
    { 0, 0, 8, 1, 0, 4, 2, 6, 0 } };
    public int[][] puzzleTwoBoard = { { 9, 1, 0, 7, 0, 0, 0, 0, 0 },
    { 0, 3, 2, 6, 0, 9, 0, 8, 0 },
    { 0, 0, 7, 0, 8, 0, 9, 0, 0 },
    { 0, 8, 6, 0, 3, 0, 1, 7, 0 },
    { 3, 0, 0, 0, 0, 0, 0, 0, 6 },
    { 0, 5, 1, 0, 2, 0, 8, 4, 0 },
    { 0, 0, 9, 0, 5, 0, 3, 0, 0 },
    { 0, 2, 0, 3, 0, 1, 4, 9, 0 },
    { 0, 0, 0, 0, 0, 2, 0, 6, 1 } };
    public int[][] puzzleThreeBoard = { { 0, 0, 1, 4, 0, 6, 7, 9, 5 },
    { 8, 0, 0, 0, 0, 0, 1, 4, 0 },
    { 6, 0, 0, 0, 1, 0, 0, 3, 0 },
    { 0, 0, 0, 1, 7, 8, 0, 5, 0 },
    { 7, 0, 0, 0, 2, 0, 0, 0, 8 },
    { 0, 8, 0, 5, 9, 3, 0, 0, 0 },
    { 0, 1, 0, 0, 6, 0, 0, 0, 9 },
    { 0, 9, 7, 0, 0, 0, 0, 0, 3 },
    { 3, 2, 6, 8, 0, 9, 4, 0, 0 } };
    public static String puzzleOneString = "097501800800"
    + "0200001204030907500000200042093000"
    + "80000019040706085000050001008104260";
    public String puzzleTwoString = "09750180080002000012040"
    + "30907500000200042093000800000190"
    + "40706085000050001008104260";
    public String puzzleThreeString = "001406795800000"
    + "1406000100300001780507000"
    + "20008080593000010060009097000003326809400";
    public int[][] puzzleOneSolved = { { 4, 9, 7, 5, 6, 1, 8, 3, 2 }, 
        { 8, 3, 5, 9, 2, 7, 1, 4, 6 },
        { 1, 2, 6, 4, 8, 3, 5, 9, 7 },
        { 7, 5, 9, 3, 1, 8, 6, 2, 4 },
        { 6, 1, 4, 2, 7, 9, 3, 5, 8 },
        { 3, 8, 2, 6, 4, 5, 7, 1, 9 },
        { 2, 4, 1, 7, 3, 6, 9, 8, 5 },
        { 9, 6, 3, 8, 5, 2, 4, 7, 1 },
        { 5, 7, 8, 1, 9, 4, 2, 6, 3 } };
    public int[][] puzzleOneAlmostSolved = { { 4, 9, 7, 5, 6, 1, 8, 3, 2 }, 
        { 8, 3, 5, 9, 2, 7, 1, 4, 6 },
        { 1, 2, 6, 4, 8, 3, 5, 9, 7 },
        { 7, 5, 9, 3, 1, 8, 6, 2, 4 },
        { 6, 1, 4, 2, 7, 9, 3, 5, 8 },
        { 3, 8, 2, 6, 4, 5, 7, 1, 9 },
        { 2, 4, 1, 7, 3, 6, 9, 8, 5 },
        { 9, 6, 3, 8, 5, 2, 4, 7, 1 },
        { 9, 6, 3, 8, 5, 2, 4, 7, 1 } };
    public int[][] almostFilledRow = { { 1, 2, 3, 4, 5, 6, 7, 8, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0} };
    public int[][] almostFilledColumn = { { 1, 0, 0, 0, 0, 0, 0, 0, 0},
        { 2, 0, 0, 0, 0, 0, 0, 0, 0},
        { 3, 0, 0, 0, 0, 0, 0, 0, 0},
        { 4, 0, 0, 0, 0, 0, 0, 0, 0},
        { 5, 0, 0, 0, 0, 0, 0, 0, 0},
        { 6, 0, 0, 0, 0, 0, 0, 0, 0},
        { 7, 0, 0, 0, 0, 0, 0, 0, 0},
        { 8, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0} };
    public int[][] almostFilledBox = { { 1, 2, 3, 0, 0, 0, 0, 0, 0},
        { 4, 5, 6, 0, 0, 0, 0, 0, 0},
        { 8, 7, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0} };
    public void testMain() {
        //Sudoku.main(
    }
    
    //the created board should be identical to the array representation above
    public void testBoard() {
        Sudoku sud = new Sudoku(puzzleOneString);
        for (int i = 0; i < 9; i++) {
            if (!Arrays.equals(puzzleOneBoard[i], sud.board()[i]))
                assertTrue(false);
        }
    }
    //in an empty board, a single cell should have all candidates true
    public void testCandidatesAll() {
        Sudoku s = new Sudoku();
        boolean[] test = {false, true, true, true, true, true, true, true, true, true};
        assertTrue(Arrays.equals(test, s.candidates(1,1)));
    }
    //in a board with three possible values for a cell, array contains these elements
    public void testCandidatesOne() {
        Sudoku s = new Sudoku(almostFilledRow);
        boolean[] test = {false, false, false, false, false, false, false, false, false, true};
        assertTrue(Arrays.equals(test, s.candidates(0,8)));
    }
    //the array should not contain a zeroth element set to true
    public void testCandidatesOccupied() {
        Sudoku s = new Sudoku(almostFilledBox);
        boolean[] test = new boolean[10];
        assertTrue(Arrays.equals(test, s.candidates(1,1)));
    }
    public void testIsSolvedFalse01() {
        Sudoku s = new Sudoku(puzzleOneBoard);
        assertTrue(!s.isSolved());
    }
    /*public void testIsSolvedFalse02() {
        Sudoku s = new Sudoku(puzzleOneAlmostSolved);
        assertFalse(s.isSolved());
    }*/
    public void testIsSolvedTrue() {
        Sudoku s = new Sudoku(puzzleOneBoard);
        s.solve();
        assertTrue(s.isSolved());
    }
    public void testNakedSingles() {
        Sudoku s = new Sudoku(almostFilledRow);
        assertTrue(s.nakedSingles());
    }
    public void testFalseNakedSingles() {
        Sudoku s = new Sudoku();
        assertFalse(s.nakedSingles());
    }
}
