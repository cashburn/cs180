import junit.framework.TestCase;
import java.util.Arrays;
import java.io.*;
public class SudokuTest extends TestCase {
    private int[][] puzzleOneBoard = { { 0, 9, 7, 5, 0, 1, 8, 0, 0 }, 
        { 8, 0, 0, 0, 2, 0, 0, 0, 0 },
        { 1, 2, 0, 4, 0, 3, 0, 9, 0 },
        { 7, 5, 0, 0, 0, 0, 0, 2, 0 },
        { 0, 0, 4, 2, 0, 9, 3, 0, 0 },
        { 0, 8, 0, 0, 0, 0, 0, 1, 9 },
        { 0, 4, 0, 7, 0, 6, 0, 8, 5 },
        { 0, 0, 0, 0, 5, 0, 0, 0, 1 },
        { 0, 0, 8, 1, 0, 4, 2, 6, 0 } };
    private int[][] puzzleTwoBoard = { { 9, 1, 0, 7, 0, 0, 0, 0, 0 },
        { 0, 3, 2, 6, 0, 9, 0, 8, 0 },
        { 0, 0, 7, 0, 8, 0, 9, 0, 0 },
        { 0, 8, 6, 0, 3, 0, 1, 7, 0 },
        { 3, 0, 0, 0, 0, 0, 0, 0, 6 },
        { 0, 5, 1, 0, 2, 0, 8, 4, 0 },
        { 0, 0, 9, 0, 5, 0, 3, 0, 0 },
        { 0, 2, 0, 3, 0, 1, 4, 9, 0 },
        { 0, 0, 0, 0, 0, 2, 0, 6, 1 } };
    private int[][] puzzleThreeBoard = { { 0, 0, 1, 4, 0, 6, 7, 9, 5 },
        { 8, 0, 0, 0, 0, 0, 1, 4, 0 },
        { 6, 0, 0, 0, 1, 0, 0, 3, 0 },
        { 0, 0, 0, 1, 7, 8, 0, 5, 0 },
        { 7, 0, 0, 0, 2, 0, 0, 0, 8 },
        { 0, 8, 0, 5, 9, 3, 0, 0, 0 },
        { 0, 1, 0, 0, 6, 0, 0, 0, 9 },
        { 0, 9, 7, 0, 0, 0, 0, 0, 3 },
        { 3, 2, 6, 8, 0, 9, 4, 0, 0 } };
    private int[][]hiddenSinglesTest = { { 0, 0, 0, 7, 5, 6, 1, 2, 3},
        { 0, 7, 8, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 4, 0, 0, 0, 0, 0, 0, 0, 0},
        { 5, 0, 0, 0, 0, 0, 0, 0, 0},
        { 6, 0, 0, 0, 0, 0, 0, 0, 0},
        { 1, 0, 0, 0, 0, 0, 0, 0, 0},
        { 2, 0, 0, 0, 0, 0, 0, 0, 0},
        { 3, 0, 0, 0, 0, 0, 0, 0, 0} };
        
    private String puzzleOneString = "097501800800"
        + "0200001204030907500000200042093000"
        + "80000019040706085000050001008104260";
    private String puzzleTwoString = "09750180080002000012040"
        + "30907500000200042093000800000190"
        + "40706085000050001008104260";
    private String puzzleThreeString = "001406795800000"
        + "1406000100300001780507000"
        + "20008080593000010060009097000003326809400";
    private int[][] almostFilledRow = { { 1, 2, 3, 4, 5, 6, 7, 8, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0} };
    private int[][] almostFilledColumn = { { 1, 0, 0, 0, 0, 0, 0, 0, 0},
        { 2, 0, 0, 0, 0, 0, 0, 0, 0},
        { 3, 0, 0, 0, 0, 0, 0, 0, 0},
        { 4, 0, 0, 0, 0, 0, 0, 0, 0},
        { 5, 0, 0, 0, 0, 0, 0, 0, 0},
        { 6, 0, 0, 0, 0, 0, 0, 0, 0},
        { 7, 0, 0, 0, 0, 0, 0, 0, 0},
        { 8, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0} };
    private int[][] almostFilledBox = { { 1, 2, 3, 0, 0, 0, 0, 0, 0},
        { 4, 5, 6, 0, 0, 0, 0, 0, 0},
        { 8, 7, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0, 0} };
    public void testMain01() {
        ByteArrayOutputStream outcontent = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(puzzleThreeString.getBytes());
        System.setOut(new PrintStream(outcontent));
        System.setIn(in);
        Sudoku.main(new String[]{puzzleThreeString});
        assertTrue(outcontent.toString().indexOf("| 2 3 1 | 4 8 6 | 7 9 5 |") != -1);
        
        
    }
    public void testMain02() {
        ByteArrayOutputStream outcontent = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(puzzleThreeString.getBytes());
        System.setOut(new PrintStream(outcontent));
        System.setIn(in);
        Sudoku.main(new String[]{});
        assertTrue(outcontent.toString().indexOf("| 2 3 1 | 4 8 6 | 7 9 5 |") != -1);
    }
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
        assertTrue(true);
    }
    //in an empty board, a single cell should have all candidates true
    public void testCandidatesAll() {
        Sudoku s = new Sudoku();
        boolean[] test = {false, true, true, true, true, true, true, true, true, true};
        assertTrue(Arrays.equals(test, s.candidates(1, 1)));
    }
    //in a board with three possible values for a cell, array contains these elements
    public void testCandidatesOne() {
        Sudoku s = new Sudoku(almostFilledRow);
        boolean[] test = {false, false, false, false, false, false, false, false, false, true};
        assertTrue(Arrays.equals(test, s.candidates(0, 8)));
    }
    //the array should not contain a zeroth element set to true
    public void testCandidatesOccupied() {
        Sudoku s = new Sudoku(almostFilledBox);
        boolean[] test = new boolean[10];
        assertTrue(Arrays.equals(test, s.candidates(1, 1)));
    }
    public void testIsSolved() {
        Sudoku s = new Sudoku(puzzleOneBoard);
        assertFalse(s.isSolved());
    }
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
    public void testHiddenSingles() {
        Sudoku s = new Sudoku(puzzleOneBoard);
        assertTrue(s.hiddenSingles());
    }
    public void testhiddenSinglesFalse() {
        Sudoku s = new Sudoku();
        assertFalse(s.hiddenSingles());
    }
}
