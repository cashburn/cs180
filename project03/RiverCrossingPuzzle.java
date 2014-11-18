/**
 * CS 180 - Project 03 - RiverCrossingPuzzle
 * 
 * (Brief description of the class file)
 * 
 * @author Colin Ashburn <cashburn@purdue.edu>
 * 
 * @lab 807
 *
 * @date 2014-10-14
 */
import java.util.Scanner;
public class RiverCrossingPuzzle {
    //BMMMCCC    MCBMMCC  MCMCBMC
    private int numEach;
    private int boatSize;
    private static int moves;
    private int status;
    String[] river = new String[4];
    //People on left side, People in boat, People on right side, Boat right or left
    public RiverCrossingPuzzle(int numEach, int boatSize) {
        this.numEach = numEach;
        this.boatSize = boatSize;
        reset();
    }
    
    
    public int numMissionariesOnLeftBank() {
        int count = 0;
        for (int i = 0; i < river[0].length(); i++) {
            if (river[0].charAt(i) == 'M')
                count++;
        }
        return count;
    }
    
    public int numMissionariesOnRightBank() {
        int count = 0;
        for (int i = 0; i < river[2].length(); i++) {
            if (river[2].charAt(i) == 'M')
                count++;
        }
        return count;
    }    
    public int numCannibalsOnLeftBank() {
        int count = 0;
        for (int i = 0; i < river[0].length(); i++) {
            if (river[0].charAt(i) == 'C')
                count++;
        }
        return count;
    }
     
    public int numCannibalsOnRightBank() {
        int count = 0;
        for (int i = 0; i < river[2].length(); i++) {
            if (river[2].charAt(i) == 'C')
                count++;
        }
        return count;
    }
     
    public boolean boatOnLeftBank() {
        if (river[3] == "left")
            return true;
        else return false;
    }
    
    public boolean boatOnRightBank() {
        if (river[3] == "right")
            return true;
        else return false;
    }
    public int numMissionariesOnBoat() {
        int count = 0;
        for (int i = 0; i < river[1].length(); i++) {
            if (river[1].charAt(i) == 'M')
                count++;
        }
        return count;
    }    
    public int numCannibalsOnBoat() {
        int count = 0;
        for (int i = 0; i < river[1].length(); i++) {
            if (river[1].charAt(i) == 'C')
                count++;
        }
        return count;
    }
    public String availableActions() {
        String str = "";
        int count = 1;
        if (boatOnLeftBank()) {
            for (int i = 1; i <= numMissionariesOnLeftBank() & i <= boatSize; i++) {
                if (i == 1)
                    str += "(" + count + ") " + 0 + " Cannibals and " + i + " Missionary cross" + "\n";
                else
                    str += "(" + count + ") " + 0 + " Cannibals and " + i + " Missionaries cross" + "\n";
                count++;
            }
            for (int i = 1; i <= numCannibalsOnLeftBank() & i <= boatSize; i++) {
                if (i == 1)
                    str += "(" + count + ") " + i + " Cannibal and " + 0 + " Missionaries cross" + "\n";
                else
                    str += "(" + count + ") " + i + " Cannibals and " + 0 + " Missionaries cross" + "\n";
                count++;
            }
            
            for (int i = 1; i <= numMissionariesOnLeftBank() & i < boatSize; i++) {
                for (int j = 1; j <= numCannibalsOnLeftBank() & j <= (boatSize - i); j++) {
                    
                    if ((i == 1) & (j == 1))
                        str += "(" + count + ") " + j + " Cannibal and " + i + " Missionary cross" + "\n";
                    else if (i == 1)
                        str += "(" + count + ") " + j + " Cannibals and " + i + " Missionary cross" + "\n";
                    else if (j == 1)
                        str += "(" + count + ") " + j + " Cannibal and " + i + " Missionaries cross" + "\n";
                    else
                        str += "(" + count + ") " + j + " Cannibals and " + i + " Missionaries cross" + "\n";
                    count++;
                }
            }
        }
        else {
            for (int i = 1; i <= numMissionariesOnRightBank() & i <= boatSize; i++) {
                if (i == 1)
                    str += "(" + count + ") " + 0 + " Cannibals and " + i + " Missionary cross" + "\n";
                else
                    str += "(" + count + ") " + 0 + " Cannibals and " + i + " Missionaries cross" + "\n";
                count++;
            }
            for (int i = 1; i <= numCannibalsOnRightBank() & i <= boatSize; i++) {
                if (i == 1)
                    str += "(" + count + ") " + i + " Cannibal and " + 0 + " Missionaries cross" + "\n";
                else
                    str += "(" + count + ") " + i + " Cannibals and " + 0 + " Missionaries cross" + "\n";
                count++;
            }
            
            for (int i = 1; i <= numMissionariesOnRightBank() & i < boatSize; i++) {
                for (int j = 1; j <= numCannibalsOnRightBank() & j <= (boatSize - i); j++) {
                    
                    if ((i == 1) & (j == 1))
                        str += "(" + count + ") " + j + " Cannibal and " + i + " Missionary cross" + "\n";
                    else if (i == 1)
                        str += "(" + count + ") " + j + " Cannibals and " + i + " Missionary cross" + "\n";
                    else if (j == 1)
                        str += "(" + count + ") " + j + " Cannibal and " + i + " Missionaries cross" + "\n";
                    else
                        str += "(" + count + ") " + j + " Cannibals and " + i + " Missionaries cross" + "\n";
                    count++;
                }
            }
        }
        return str;
    }
    
    public void move(int numCannibalsToMove, int numMissionariesToMove) {
        
        if ((numCannibalsToMove | numMissionariesToMove) < 0) {
            System.out.println("Invalid Move");
            return;
        }
        if (numCannibalsToMove + numMissionariesToMove < 1) {
            System.out.println("Invalid Move");
            return;
        }
        if (numCannibalsToMove + numMissionariesToMove > boatSize) {
            System.out.println("Invalid Move");
            return;
        }
        if (boatOnLeftBank()) {
            if (numMissionariesToMove > numMissionariesOnLeftBank()) {
                System.out.println("Invalid Move");
                return;
            }
            if (numCannibalsToMove > numCannibalsOnLeftBank()) {
                System.out.println("Invalid Move");
                return;
            }
            for (int i = 0; i < numMissionariesToMove; i++) {
                river[2] = "M" + river[2];
                river[0] = river[0].substring(1, river[0].length());
            }
            for (int i = 0; i < numCannibalsToMove; i++) {
                river[2] = river[2] + "C";
                river[0] = river[0].substring(0, river[0].length() - 1);
            }
            
            /*
            for (int i = 0; i < river[1].length(); i++) {
                river[2] = "M" + river[2];
                river[1] = river[1].substring(1, river[1].length());
            }
            for (int i = 0; i < river[1].length(); i++) {
                river[2] = river[2] + "C";
                river[1] = river[1].substring(0, river[1].length() - 1);
            }*/
            moves++;
            river[3] = "right";
            if ((numCannibalsOnLeftBank() > numMissionariesOnLeftBank()) & (numMissionariesOnLeftBank() > 0)) {
                status = -1;
                return;
            }
            if ((numCannibalsOnRightBank() > numMissionariesOnRightBank()) & (numMissionariesOnRightBank() > 0)) {
                status = -1;
                return;
            }
        }
        else {
            if (numMissionariesToMove > numMissionariesOnRightBank()) {
                System.out.println("Invalid Move");
                return;
            }
            if (numCannibalsToMove > numCannibalsOnRightBank()) {
                System.out.println("Invalid Move");
                return;
            }
            for (int i = 0; i < numMissionariesToMove; i++) {
                river[0] = "M" + river[0];
                river[2] = river[2].substring(1, river[2].length());
            }
            for (int i = 0; i < numCannibalsToMove; i++) {
                river[0] = river[0] + "C";
                river[2] = river[2].substring(0, river[2].length() - 1);
            }
            
            //if (numCannibalsOnBoat() > numMissionariesOnBoat()) {
                //status = -1;
                //return;
            //}
            
            /*for (int i = 0; i < river[1].length(); i++) {
                river[0] = "M" + river[0];
                river[1] = river[1].substring(1, river[1].length());
            }
            for (int i = 0; i < river[1].length(); i++) {
                river[0] = river[0] + "C";
                river[1] = river[1].substring(0, river[1].length() - 1);
            }*/
            moves++;
            river[3] = "left";
            
            if ((numCannibalsOnLeftBank() > numMissionariesOnLeftBank()) & (numMissionariesOnLeftBank() > 0)) {
                status = -1;
                return;
            }
            if ((numCannibalsOnRightBank() > numMissionariesOnRightBank()) & (numMissionariesOnRightBank() > 0)) {
                status = -1;
                return;
            }
        }
    }
    public int totalMoves() {
        return moves;
    }
    
    public void reset() {
        moves = 0;
        status = 0;
        river[0] = "";
        river[1] = "";
        river[2] = "";
        river[3] = "left";
        for (int i = 0; i < numEach; i++) {
            river[0] = "M" + river[0];
        }
        for (int i = 0; i < numEach; i++) {
            river[0] = river[0] + "C";
        }
    }

    public int status() {
        return status;
    }
    
    public void play() {
        reset();
        Scanner in = new Scanner(System.in);
        while (((numMissionariesOnRightBank() < numEach) | (numCannibalsOnRightBank() < numEach)) & (status == 0)) {
            System.out.print(prompt());
            int a = 0;
            int b = -1;
            if (in.hasNextInt()) {
                a = in.nextInt();
            }
            if (in.hasNextInt()) {
                b = in.nextInt();
            }
            
            if ((b == -1) & (a > 0)) {
                int param1 = 0;
                int param2 = 0;
                int count = 1;
                if (boatOnLeftBank()) {
                    for (int i = 1; i <= numMissionariesOnLeftBank() & i <= boatSize; i++) {
                        if (count == a)    
                            param2 = i;
                        count++;
                    }
                    for (int i = 1; i <= numCannibalsOnLeftBank() & i <= boatSize; i++) {
                        if (count == a)
                            param1 = i;
                        count++;
                    }
                    
                    for (int i = 1; i <= numMissionariesOnLeftBank() & i < boatSize; i++) {
                        for (int j = 1; j <= numCannibalsOnLeftBank() & j <= (boatSize - i); j++) {
                            if (count == a) {
                                param1 = j;
                                param2 = i;
                            }
                            count++;
                        }
                    }
                }
                else {
                    for (int i = 1; i <= numMissionariesOnRightBank() & i <= boatSize; i++) {
                        if (count == a)    
                            param2 = i;
                        count++;
                    }
                    for (int i = 1; i <= numCannibalsOnRightBank() & i <= boatSize; i++) {
                        if (count == a)
                            param1 = i;
                        count++;
                    }
                    
                    for (int i = 1; i <= numMissionariesOnRightBank() & i < boatSize; i++) {
                        for (int j = 1; j <= numCannibalsOnRightBank() & j <= (boatSize - i); j++) {
                            if (count == a) {
                                param1 = j;
                                param2 = i;
                            }
                            count++;
                        }
                    }
                }
                move(param1, param2);
                
                
                /*Scanner actions = new Scanner(availableActions());
                 int correctIn = 0;
                 String trash = "";
                 while (correctIn == 0) {
                 //if (!actions.hasNextLine())
                 //correctIn = -1;
                 if (actions.next().equals("(" + a + ")")) {
                 correctIn = 1;
                 break;
                 }
                 trash = actions.next();
                 }
                 if (correctIn == 1) {
                 while(!actions.hasNextInt())
                 trash = actions.next();
                 int param1 = actions.nextInt();
                 while(!actions.hasNextInt())
                 trash = actions.next();
                 int param2 = actions.nextInt();
                 move(param1, param2);
                 }*/
                
            }
            else {
                if ((a > 0) | (b > 0))
                    move(a, b);
            }
            if (status == -1)
                return;
        }
        status = 1;
    }
    
    
   /**
     *  ***DO NOT CHANGE THIS FUNCTION.***
     * @return String containing the prompt for user input
     */
    public String prompt() {
        String str = "";
        str += "Available Actions\n";
        str += availableActions();
        str += "Action: ";
        return str;
    }
 
    /**
     * ***DO NOT CHANGE THIS FUNCTION.***
     * @return state of left (starting) bank as a String
     */
    private String leftBank() {
        String str = "";
        for (int i = 0; i < numCannibalsOnLeftBank(); i++)
            str += "C";
        str += " ";
        for (int i = 0; i < numMissionariesOnLeftBank(); i++)
            str += "M";
        str += " ";
        if (boatOnLeftBank())
            str += "B";
        return str;
    }
 
    /**
     *  ***DO NOT CHANGE THIS FUNCTION.***
     * @return state of right (ending) bank as a String
     */
    private String rightBank() {
        String str = "";
        if (boatOnRightBank())
            str += "B ";
        for (int i = 0; i < numCannibalsOnRightBank(); i++)
            str += "C";
        str += " ";
        for (int i = 0; i < numMissionariesOnRightBank(); i++)
            str += "M";
        return str;
    }
 
    public String toString() {
        return leftBank() + " | " + rightBank();
    }
 
    /**
     *  ***DO NOT CHANGE THIS FUNCTION.***
     * @return String representation of current state of puzzle
     */
    private String puzzleState() {
        String lb = leftBank();
        String rb = rightBank();
        String str = "\n";
        str += "Left Bank";
        for (int i = 9; i < lb.length(); i++)
            str += " ";
        str += " | ";
        for (int i = lb.length() + 3; i < lb.length() + rb.length() + 3 - 10; i++)
            str += " ";
        str += "Right Bank";
        str += "\n";
        str += lb;
        for (int i = lb.length(); i < 9; i++)
            str += " ";
        str += " | ";
        for (int i = rb.length() - 10; i < 0; i++)
            str += " ";
        str += rb;
        str += "\n";
        str += "\n";
        str += "   Cannibals on left,right banks: ";
        str += String.format("%3d,%3d", numCannibalsOnLeftBank(), numCannibalsOnRightBank());
        str += "\n";
        str += "Missionaries on left,right banks: ";
        str += String.format("%3d,%3d", numMissionariesOnLeftBank(), numMissionariesOnRightBank());
        str += "\n";
        str += "\n";
        str += "Number of moves: " + totalMoves();
        str += "\n";
        return str;
    }
    public static void main(String[] args) {
        
        
        int numEach = 3;
        int boatSize = 2;
        if (args.length > 0) {
            if (args[0] == "-n") {
                Scanner in1 = new Scanner(args[1]);
                if (in1.hasNextInt())
                    numEach = in1.nextInt();
                if (numEach < 1)
                    return;
                if (args.length == 4) {
                    Scanner in2 = new Scanner(args[3]);
                    if (args[2] == "-b") {
                        if (in2.hasNextInt())
                            boatSize = in2.nextInt();
                        if (boatSize < 1)
                            return;
                    }
                }
            }
            else if (args[0] == "-b") {
                Scanner in1 = new Scanner(args[1]);
                if (in1.hasNextInt())
                    boatSize = in1.nextInt();
                if (boatSize < 1)
                    return;
                if (args.length == 4) {
                    Scanner in2 = new Scanner(args[3]);
                    if (args[2] == "-b") {
                        if (in2.hasNextInt())
                            numEach = in2.nextInt();
                        if (numEach < 1)
                            return;
                    }
                }
            }
        }
        RiverCrossingPuzzle p1 = new RiverCrossingPuzzle(numEach, boatSize);
        p1.play();
    }
        
    
}