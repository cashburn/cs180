/**
 * CS 180 - Lab 08 - CollegeFeeCalculator
 * 
 * A GUI for inputting student information to calculate college fees.
 * 
 * @author Colin Ashburn <(cashburn@purdue.edu)>
 * 
 * @lab 807
 *
 * @date 2014-11-04
 */
import javax.swing.JOptionPane;
public class CollegeFeeCalculator {
    public static void main(String[] args) {
        boolean cont = true;
        boolean exit = false;
        while (cont) {
            JOptionPane.showMessageDialog (null, 
                                       "Welcome to CollegeFeeCalculator!",
                                       "CollegeFeeCalculator", 
                                       JOptionPane.INFORMATION_MESSAGE);
            
            String name = JOptionPane.showInputDialog (null, 
                                       "Please enter your name, then press OK",
                                       "Name", 
                                       JOptionPane.QUESTION_MESSAGE);
            if (name == null)
                break;
            boolean cont1 = true;
            int enrollment = 0;
            int hours = 0;
            String[] enrollmentSelections = { "Part-time", "Full-time" };
            while (cont1) {
                enrollment = JOptionPane.showOptionDialog (null, 
                                       "Please select your enrollment", 
                                       "Enrollment",
                                       JOptionPane.PLAIN_MESSAGE,
                                       JOptionPane.QUESTION_MESSAGE,
                                       null,
                                       enrollmentSelections,
                                       enrollmentSelections[1]);
                if (enrollment == JOptionPane.CLOSED_OPTION || hours == JOptionPane.CLOSED_OPTION) {
                    exit = true;
                    break;
                }
                hours = Integer.parseInt(JOptionPane.showInputDialog (null,
                                       "Please enter the no. of credit hours, then press OK",
                                       "Credit Hours",
                                       JOptionPane.QUESTION_MESSAGE));
                if (enrollment == JOptionPane.CLOSED_OPTION || hours == JOptionPane.CLOSED_OPTION) {
                    exit = true;
                    break;
                }
                
                if (((enrollment == 0 && hours >= 8) || (enrollment == 1 && hours < 8))) {
                    JOptionPane.showMessageDialog (null, 
                                       "Please enter valid credit hours for the current enrollment",
                                       "Invalid no. of credits", 
                                       JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                
                if (exit)
                    break;
                else
                    cont1 = false;
            }
            String[] residencySelections = { "In-state", "Out-of-state", "International" };
            String residency = (String) JOptionPane.showInputDialog (null,
                                       "Please select the appropriate residency",
                                       "Residency",
                                       JOptionPane.QUESTION_MESSAGE,
                                       null,
                                       residencySelections,
                                       residencySelections[0]);
            if (residency == null)
                break;
            String[] housingSelections = { "ON-Campus", "OFF-Campus" };
            String housing = (String) JOptionPane.showInputDialog (null,
                                       "Please select your housing",
                                       "Housing",
                                       JOptionPane.QUESTION_MESSAGE,
                                       null,
                                       housingSelections,
                                       housingSelections[0]);
            if (housing == null)
                break;
            String resHall = "";
            String[] residenceSelections = { "Earhart", "Hillenbrand", "Owen", "Windsor" };
            if (housing.equals("ON-Campus")) {
                
                String value = (String) JOptionPane.showInputDialog (null,
                                       "Please select the residence hall",
                                       "Residence-Hall",
                                       JOptionPane.QUESTION_MESSAGE,
                                       null,
                                       residenceSelections,
                                       residenceSelections[0]);
                if (value == null) {
                    exit = true;
                    break;
                }
                resHall += value;
            }
            if (exit)
                break;
            int tuitionFee = 4996;
            if (!resHall.equals(residenceSelections[0]))
                tuitionFee += 9401;
            if (resHall.equals(residenceSelections[2]))
                tuitionFee += 1000;
         
            int creditRate = 350;
            if (!resHall.equals(residenceSelections[0]))
                tuitionFee += 600;
            if (resHall.equals(residenceSelections[2]))
                tuitionFee += 70;
         
            tuitionFee += hours * creditRate;
            
            int housingExpense = 0;
            int[] housingOptions = { 4745, 5307, 4130, 4150 };
            if (housing.equals("ON-Campus")) 
                for (int i = 0; i < 4; i++) 
                if (resHall.equals(residenceSelections[i]))
                housingExpense = housingOptions[i];
            
            int totalFee = tuitionFee + housingExpense;
            String display = "Name: " + name + "\n" + "Credit Hours: " + hours + "\n" + "Enrollment: " +
                enrollmentSelections[enrollment] + "\n" + "Residency: " + residency + "\n" + "Tuition fee: $" + 
                tuitionFee + "\n" + "Housing Expense: $" + housingExpense + "\n" + "Total Sem. Fee: $" + 
                Integer.toString(totalFee);
            JOptionPane.showMessageDialog (null,
                                        display,
                                        "CollegeFeeCalculator", 
                                        JOptionPane.INFORMATION_MESSAGE);
            int done = JOptionPane.showConfirmDialog (null, 
                                        "Would you like to perform another fee calculation?", 
                                        "Are you done?",
                                        JOptionPane.YES_NO_OPTION);
            
            if (done == 1)
                cont = false;
            else
                continue;
        }
    }
}
    
    