import java.util.Scanner;
import java.util.Arrays;
public class Sudoku {
    //001406795800000140600010030000178050700020008080593000010060009097000003326809400
<<<<<<< HEAD
    private int[][] board = new int[9][9];
    //private String input;
=======
    public int[][] board = new int[9][9];
    //public String input;
>>>>>>> f8836e70a55ff366a426902f4bcf2f64bdc23d5d
    public static void main(String[] args) {
        Sudoku sud;
        if (args.length == 0) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter board as a string: ");
            String s = in.nextLine();
            sud = new Sudoku(parseString(s));
        }
        else {
            sud = new Sudoku(Sudoku.parseString(args[0]));
        }
<<<<<<< HEAD
        //sud.printState();
=======
        sud.printState();
>>>>>>> f8836e70a55ff366a426902f4bcf2f64bdc23d5d
        sud.solve();
    }
    //Default constructor for an empty puzzle board
    public Sudoku() {
        
    }
    //Constructor with a supplied board
    public Sudoku(int[][] board) {
<<<<<<< HEAD
        int[][] rboard = new int[9][9];
        for (int i = 0; i < 9; i++) {
            rboard[i] = Arrays.copyOf(board[i], 9);
        }
        this.board = rboard;
=======
        this.board = board;
>>>>>>> f8836e70a55ff366a426902f4bcf2f64bdc23d5d
    }
    public Sudoku(String board) {
        this.board = parseString(board);
    }
    //returns the board!
    public int[][] board() {
        int[][] rboard = new int[9][9];
        for (int i = 0; i < 9; i++) {
            rboard[i] = Arrays.copyOf(board[i], 9);
        }
        return rboard;
    }
<<<<<<< HEAD
    private static int[][] parseString(String str) {
=======
    public static int[][] parseString(String str) {
>>>>>>> f8836e70a55ff366a426902f4bcf2f64bdc23d5d
        if (str.length() < 81)
            System.exit(0);
        int[][] board = new int[9][9];
        int count = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String current = Character.toString(str.charAt(count));
                int index = isInteger(current);
                if (index == -1)
                    System.exit(0);
                board[i][j] = index;
                count++;
            }
        }
        return board;
    }
<<<<<<< HEAD
    private static int isInteger(String s) {
=======
    public static int isInteger(String s) {
>>>>>>> f8836e70a55ff366a426902f4bcf2f64bdc23d5d
        int fin;
        try {
            fin = Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            return -1;
        }
        return fin;
    }
    //Returns an array with possible candidates to their corresponding indexes
    public boolean[] candidates(int row, int column) {
        boolean[] candidates = new boolean[10];
        if (board[row][column] == 0) {
            for (int i = 1; i < 10; i++) {
                candidates[i] = compare(getRow(row), i) && compare(getColumn(column), i) &&
                    compare(getBox(row, column), i);
            }
        }
        return candidates;
    }
<<<<<<< HEAD
    private boolean compare(int[] arg, int var) {
=======
    public boolean compare(int[] arg, int var) {
>>>>>>> f8836e70a55ff366a426902f4bcf2f64bdc23d5d
        for (int i = 0; i < 9; i++) {
            if (arg[i] == var) {
                return false;
            }
        }
        return true;
    }
<<<<<<< HEAD
    private int[] getRow(int row) {
=======
    public int[] getRow(int row) {
>>>>>>> f8836e70a55ff366a426902f4bcf2f64bdc23d5d
        int[] fin = new int[9];
        if (row < 0) {
            return fin;
        }
        for (int i = 0; i < 9; i++) {
            fin[i] = board[row][i];
        }
        return fin;
    }
<<<<<<< HEAD
    private int[] getColumn(int column) {
=======
    public int[] getColumn(int column) {
>>>>>>> f8836e70a55ff366a426902f4bcf2f64bdc23d5d
        int[] fin = new int[9];
        if (column < 0) {
            return fin;
        }
        for (int i = 0; i < 9; i++) {
            fin[i] = board[i][column];
        }
        return fin;
    }
<<<<<<< HEAD
    private int[] getBox(int cellRow, int cellColumn) {
=======
    public int[] getBox(int cellRow, int cellColumn) {
>>>>>>> f8836e70a55ff366a426902f4bcf2f64bdc23d5d
        int[] fin = new int[9];
        int count = 0;
        int rowStart = getBoxVariable(cellRow);
        int columnStart = getBoxVariable(cellColumn);
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = columnStart; j < columnStart + 3; j++) {
                fin[count++] = board[i][j];
            }
        }
        return fin;
    }
    //returns true if the board is solved
    public boolean isSolved() {
<<<<<<< HEAD
        boolean brow = true;
        boolean bcolumn = true;
        boolean bbox = true;
        for (int row = 0; row < 9; row++) {
            if (!checkZeroToNine(getRow(row))) {
                brow = false;
=======
        for (int row = 0; row < 9; row++) {
            if (!checkZeroToNine(getRow(row))) {
                return false;
>>>>>>> f8836e70a55ff366a426902f4bcf2f64bdc23d5d
            }
        }
        for (int column = 0; column < 9; column++) {
            if (!checkZeroToNine(getColumn(column))) {
<<<<<<< HEAD
                bcolumn = false;
=======
                return false;
>>>>>>> f8836e70a55ff366a426902f4bcf2f64bdc23d5d
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkZeroToNine(getBox(i, j))) {
<<<<<<< HEAD
                    bbox = false;
                }
            }
        }
        return brow && bcolumn && bbox;
    }
    private boolean checkZeroToNine(int[] array) {
        boolean[] check = new boolean[10];
        for (int i = 0; i < 9; i++) {
            check[array[i]] = true;
        }
        if (check[0]) {
            return false;
        }
        for (int i = 1; i < 10; i++) {
            if (!check[i])
                return false;
        }
=======
                    return false;
                }
            }
        }
>>>>>>> f8836e70a55ff366a426902f4bcf2f64bdc23d5d
        return true;
    }
    //solve...
    public void solve() {
        while (!isSolved() && (hiddenSingles() || nakedSingles())) {
            
        }
        printState();
    }
    //Prints the fun stuff
    public void printState() {
        String print = "";
        print += "+-------+-------+-------+\n";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ((i == 3 || i == 6) && j == 0) {
                    print += "+-------+-------+-------+\n";
                }
                if (j == 0 || j == 3 || j == 6) {
                    print += "| ";
                }
                print += isSpace(i, j) + " ";
                if (j == 8) {
                    print += "|\n";
                }
            }
        }
        print += "+-------+-------+-------+\n";
        System.out.println(print);
    }
<<<<<<< HEAD
    private String isSpace(int row, int column) {
=======
    public String isSpace(int row, int column) {
>>>>>>> f8836e70a55ff366a426902f4bcf2f64bdc23d5d
        if (board[row][column] == 0) {
            return " ";
        }
        return Integer.toString(board[row][column]);
    }
    //Takes the string supplied by the constructor and applies it to the board
<<<<<<< HEAD
    private int getBoxVariable(int variable) {
=======
    public int getBoxVariable(int variable) {
>>>>>>> f8836e70a55ff366a426902f4bcf2f64bdc23d5d
        if (variable > 2) {
            if (variable > 5) {
                return 6;
            }
            else {
                return 3;
            }
        }
        return 0;
    }
    public boolean nakedSingles() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    boolean[] candidates = candidates(i, j);
                    int v = isNakedSingle(candidates);
                    if (v != 0) {
                        board[i][j] = v;
                        //System.out.println("Naked Single");
                        return true;
                    }
                }
            }
        }
        return false;
    }
<<<<<<< HEAD
    private int isNakedSingle(boolean[] candidates) {
=======
    public int isNakedSingle(boolean[] candidates) {
>>>>>>> f8836e70a55ff366a426902f4bcf2f64bdc23d5d
        int index = 0;
        int numCandidates = 0;
        for (int i = 1; i < 10; i++) {
            if (candidates[i] == true) {
                index = i;
                numCandidates++;
            }
        }
        if (numCandidates != 1) {
            return 0;
        }
        return index;
    }
    public boolean hiddenSingles() {
        for (int i = 0; i < 9; i++) {
            boolean[][] rowCandidates = getRowCandidates(i);
            for (int j = 0; j < 9; j++) { //get the specific cell in question at index (i, j)
                if (board[i][j] == 0) {
                    boolean[][] columnCandidates = getColumnCandidates(j);
                    boolean[][] boxCandidates = getBoxCandidates(i, j);
                    boolean[] cellCandidates = candidates(i, j);
                    for (int c = 1; c < 10; c++) {
                        if (cellCandidates[c]) {
<<<<<<< HEAD
                            if (checkIfFalse(rowCandidates, c) ||
                                checkIfFalse(columnCandidates, c) ||
                                checkIfFalse(boxCandidates, c)) {
                                board[i][j] = c;
                                //printState();
=======
                            if (checkIfFalse(rowCandidates, c) &&
                                checkIfFalse(columnCandidates, c) &&
                                checkIfFalse(boxCandidates, c)) {
                                board[i][j] = c;
>>>>>>> f8836e70a55ff366a426902f4bcf2f64bdc23d5d
                                //System.out.println("Hidden Single");
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
<<<<<<< HEAD
    private boolean checkIfFalse(boolean[][] array, int column) {
=======
    public boolean checkIfFalse(boolean[][] array, int column) {
>>>>>>> f8836e70a55ff366a426902f4bcf2f64bdc23d5d
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (array[i][column])
                count++;
        }
        return (count == 1);
    }
<<<<<<< HEAD
    private boolean[][] getRowCandidates(int row) {
=======
    public boolean[][] getRowCandidates(int row) {
>>>>>>> f8836e70a55ff366a426902f4bcf2f64bdc23d5d
        boolean[][] candidates = new boolean[9][10];
        for (int i = 0; i < 9; i++) { //i is the column
            candidates[i] = candidates(row, i);
        }
        return candidates;
    }
<<<<<<< HEAD
    private boolean[][] getColumnCandidates(int column) {
=======
    public boolean[][] getColumnCandidates(int column) {
>>>>>>> f8836e70a55ff366a426902f4bcf2f64bdc23d5d
        boolean[][] candidates = new boolean[9][10];
        for (int i = 0; i < 9; i++) { //i is the row
            candidates[i] = candidates(i, column);
        }
        return candidates;
    }
<<<<<<< HEAD
    private boolean[][] getBoxCandidates(int row, int column) {
=======
    public boolean[][] getBoxCandidates(int row, int column) {
>>>>>>> f8836e70a55ff366a426902f4bcf2f64bdc23d5d
        row = getBoxVariable(row);
        column = getBoxVariable(column);
        boolean[][] candidates = new boolean[9][10];
        int candidateColumn = 0;
        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                candidates[candidateColumn] = candidates(i, j);
                candidateColumn++;
            }
        }
        return candidates;
    }
<<<<<<< HEAD
=======
    public boolean checkZeroToNine(int[] array) {
        boolean[] check = new boolean[10];
        for (int i = 0; i < 9; i++) {
            check[array[i]] = true;
        }
        if (check[0]) {
            return false;
        }
        for (int i = 1; i < 10; i++) {
            if (!check[i])
                return false;
        }
        return true;
    }
>>>>>>> f8836e70a55ff366a426902f4bcf2f64bdc23d5d
}