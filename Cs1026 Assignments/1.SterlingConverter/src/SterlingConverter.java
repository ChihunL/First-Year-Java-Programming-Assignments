import java.util.Scanner;
import javax.swing.JOptionPane;

public class SterlingConverter {
    public static final int OLDPENNY_PER_OLDSHILLING = 12;
    public static final int OLDSHILLING_PER_OLDPOUND = 20;
    public static final int NEWPENNY_PER_OLDPENNY = 67;
    public static final int NEWPENNY_PER_NEWPOUND = 100;

    public static void main(String[] args)
    {
        String input = JOptionPane.showInputDialog("Enter Pounds, Shillings, Pennies separated by spaces.");
        Scanner inputScanner = new Scanner (input);
        int oldPounds = inputScanner.nextInt();
        int oldShilliings = inputScanner.nextInt();
        int oldPennies = inputScanner.nextInt();
        inputScanner.close();

        int numberOfWholeShillings = (int)(oldPounds*OLDSHILLING_PER_OLDPOUND + oldShilliings);
        int numberOfWholeOLdPennies = (int)(numberOfWholeShillings*OLDPENNY_PER_OLDSHILLING + oldPennies);
        int numberOfNewPennies = (int)(numberOfWholeOLdPennies*NEWPENNY_PER_OLDPENNY);

        int numberOfNewPounds = (int)(numberOfNewPennies/NEWPENNY_PER_NEWPOUND);
        int numberOfRemainderPennies = (int)(numberOfNewPennies%NEWPENNY_PER_NEWPOUND);


        JOptionPane.showMessageDialog(null, String.format("The amount of money you have entered converts"
                + " to £%d.%02d", numberOfNewPounds, numberOfRemainderPennies));

    }
}

