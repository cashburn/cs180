/**
 * Makes an educated guess for the GuessWhoGame class and returns the score.
 * 
 * @author Colin Ashburn <cashburn@purdue.edu>
 * @version 2014-09-25
 */

public class Guesser {

    /**
     * Returns one of the characters depending on a series of if statements.
     * Each decision is made depending on how evenly it would split each group.
     */
    public static String play(GuessWhoGame g) {
        if (g.hairIsColor(Color.BROWN)) {
            if (g.isWearingGlasses()) {
                if (g.shirtIsColor(Color.GREEN)) {
                    if (g.isWearingHat()) {
                        return "Bob";
                    } 
                    else {
                        if (g.eyeIsColor(Color.BLUE)) {
                            return "Alice";
                        }
                        else {
                            if (g.eyeIsColor(Color.GREEN)) {
                                return "Frank";
                            }
                            else {
                                return "Isabelle";
                            }
                        }
                    }
                }
                else {
                    if (g.isSmiling()) {
                        if (g.isWearingHat()) {
                            return "Emily";
                        }
                        else {
                            return "Mallie";
                        }
                    }
                    else {
                        return "Wendy";
                    }
                }
            }
            
            else {
                if (g.eyeIsColor(Color.BROWN)) {
                    if (g.shirtIsColor(Color.RED)) {
                        if (g.isWearingHat()) {
                            return "Robert";
                        }
                        else {
                            return "Quinn";
                        }
                    }
                    else {
                        if (g.isWearingHat()) {
                            return "Dave";
                        }
                        else {
                            return "Zander";
                        }
                    }
                }
                else {
                    if (g.eyeIsColor(Color.BLUE)) {
                        if (g.shirtIsColor(Color.BLUE)) {
                            return "Tucker";
                        }
                        else {
                            return "Nick";
                        }
                    }
                    else {
                        return "Philip";
                    }
                }
            }
        }
        else {
            if (g.hairIsColor(Color.BLACK)) {
                if (g.eyeIsColor(Color.BROWN)) {
                    if (g.shirtIsColor(Color.GREEN)) {
                        if (g.isWearingGlasses()) {
                            return "Xavier";
                        }
                        else {
                            return "Ursula";
                        }
                    }
                    else {
                        return "Olivia";
                    }
                }
                else {
                    if (g.eyeIsColor(Color.BLUE)) {
                        if (g.isWearingHat()) {
                            return "Gertrude";
                        }
                        else {
                            return "Carol";
                        }
                    }
                    else {
                        return "Karen";
                    }
                }
            }
            else {
                if (g.eyeIsColor(Color.BROWN)) {
                    if (g.hairIsColor(Color.BLOND)) {
                        if (g.shirtIsColor(Color.RED)) {
                            return "Henry";
                        }
                        else {
                            return "Jack";
                        }
                    }
                    else {
                        if (g.isWearingHat()) {
                            return "Sarah";
                        }
                        else {
                            return "Victor";
                        }
                    }
                }
                else {
                    if (g.isSmiling()) {
                        return "Yasmine";
                    }
                    else {
                        return "Larry";
                    }
                }
            }
        }               
    }

    /**
     * Creates new instance of GuessWhoGame, sets variable 'guess' as the play() method,
     * and prints out the Guess from the play() method along with the score.
     */
    public static void main(String[] args) {
        GuessWhoGame g = new GuessWhoGame();
        String guess = play(g);
        System.out.println("Guess: " + guess);
        System.out.println("Guess was " + g.guess(guess) + ".");
        System.out.println("Score: " + g.score());
    }
}
