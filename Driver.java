import javax.swing.JOptionPane;

public class Driver 
{
    static int menuChoice;
    static Guess guessMain = new Guess();
    
    public static void main(String[] args) 
    {
        
        mainMenu();
           
        System.exit(0);
        
    }

    public static void mainMenu()
    {
        String choice = JOptionPane.showInputDialog(null, "Musical Scale Guesser\n--------------------------------" + "\n1. Guess Entire Scale" + "\n2. Guess Note Position" 
        + "\n3. Guess Triad" + "\n4. Guess Major-Minor-Dim Sequence" + "\n5. Exit", "Main Menu", JOptionPane.INFORMATION_MESSAGE);
        int menuChoice = Integer.parseInt(choice);

        while (menuChoice < 1 || menuChoice > 5)
        {
            JOptionPane.showMessageDialog(null, "Enter A number between 1 and 5.", "Error", JOptionPane.ERROR_MESSAGE);
            choice = JOptionPane.showInputDialog(null, "Musical Scale Guesser by Robert LoCicero" + "\n1.Guess an Entire Scale" + "\n2.Guess a notes position" 
            + "\n3.Guess triads" + "\n4.Guess Major-Minor-Dim Sequence" + "\n5.Exit", "Main Menu", JOptionPane.INFORMATION_MESSAGE);
            menuChoice = Integer.parseInt(choice);
        }

        switch(menuChoice)
        {
            case 1:
                guessMain.guessEntireScale();
                break;
            case 2:
                guessMain.guessNotePosition();
                break;
            case 3:
                guessMain.guessChords();
                break;
            case 4:
                guessMain.guessChordSequence();
                break;
            case 5:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Sorry, something went wrong.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
