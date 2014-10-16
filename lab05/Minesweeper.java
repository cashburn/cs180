/**
 * Minesweeper
 * @author Colin Ashburn <cashburn@purdue.edu>
 * @lab 807
 */ 

import java.util.Random;
import java.util.Scanner;
public class Minesweeper {
    public boolean[][] minefield;
    public int[][] clueGrid;
    public boolean[][] checked;
    public int rows;
    public int columns;
    public Minesweeper(int rows, int columns, int mines) {
        minefield = new boolean[rows][columns];
        clueGrid = new int[rows][columns];
        checked = new boolean[rows][columns];
        this.rows = rows;
        this.columns = columns;
        generateMinefield(mines);
        generateClueGrid();
        for (int i = 0; i < checked.length; i++) {
            for (int j = 0; j < checked[i].length; j++) {
                checked[i][j] = false;
            }
        }
    }
    public void generateMinefield(int mines) {
        for (int i = 0; i < minefield.length; i++) {
            for (int j = 0; j < minefield[i].length; j++) {
                minefield[i][j] = false;
            }
        }
        
        Random random = new Random(System.currentTimeMillis());
        int i = 1;
        while (i <= mines) {
            int r = random.nextInt(minefield.length);
            int c = random.nextInt(minefield[r].length);
            if (minefield[r][c]) {
                continue;
            }
            minefield[r][c] = true;
            i++;
        }
    }
    
    public int countMines(int row, int column) {
        int n = 0;
        for (int i = Math.max(row-1,0); i <= Math.min(row+1,rows-1); i++) {
            for (int j = Math.max(column-1,0); j <= Math.min(column+1,columns-1); j++) {
                if (!(i == row && j == column)) {
                    if (minefield[i][j]) {
                        n++;
                    }
                }
            }
        }
        return n;
    }
    
    public void generateClueGrid() {
        for (int i = 0; i < clueGrid.length; i++) {
            for (int j = 0; j < clueGrid[i].length; j++) {
                if (minefield[i][j]) {
                    clueGrid[i][j] = -1;
                    continue;
                }
                else {
                    clueGrid[i][j] = countMines(i,j);
                }
            }
        }
    }
    public void printBoard() {
        System.out.print("   ");
        for (int j = 0; j < columns; j++)
            System.out.print(" " + (j+1));
        System.out.println();
        System.out.print("  +-");
        
        for (int j = 0; j < columns; j++)
            System.out.print("--");
        System.out.println();
        
        char row_letter = 'A';
        for (int i = 0; i < rows; i++) {
            System.out.print(row_letter + " |");
            
            char cell_symbol;
            for (int j = 0; j < columns; j++){
                if (!checked[i][j])
                    cell_symbol = '?';
                else if (minefield[i][j])
                    cell_symbol = '*';
                else if (clueGrid[i][j] > 0)
                    cell_symbol = (char)('0' + clueGrid[i][j]);
                else
                    cell_symbol = ' ';
                System.out.print(" " + cell_symbol);
            }
            System.out.println();
            row_letter++;
        }
        
    }
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean win = false;
        while (!win) {
            printBoard();
            System.out.print("Choose a cell to check: ");
            String line = scanner.nextLine().toUpperCase();
            int rowIn = line.charAt(0)-'A';
            int columnIn = line.charAt(1)-'1';
            
            if (minefield[rowIn][columnIn])
                break; //Boom!
            else
                checked[rowIn][columnIn] = true;
            win = true;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++)
                    if (!checked[i][j] && !minefield[i][j])
                    win = false;
            }
        }
        //shows all cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                checked[i][j] = true;
            }
        printBoard();
        if (win)
            System.out.println("You won!");
        else
            System.out.println("Aw, it must be sad to be you.");
        }
        

}
    