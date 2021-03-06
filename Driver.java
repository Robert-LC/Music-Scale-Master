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

     /**
     * Main Menu with 5 choices. 
     * Allows user to pick the gamemode or exit
     * has user validation to make sure 1 - 5 is entered
     * @since November 5, 2020
     */
    public static void mainMenu()
    {
        String choice = JOptionPane.showInputDialog(null, "Music Scale Mastery\n--------------------------------" + "\n1. Guess Entire Scale" + "\n2. Guess Note Position" 
        + "\n3. Guess Triad" + "\n4. Guess Major-Minor-Dim Sequence" + "\n5. Exit", "Main Menu", JOptionPane.INFORMATION_MESSAGE);
        int menuChoice = Integer.parseInt(choice);

        while (menuChoice < 1 || menuChoice > 5)
        {
            JOptionPane.showMessageDialog(null, "Enter A number between 1 and 5.", "Error", JOptionPane.ERROR_MESSAGE);
            choice = JOptionPane.showInputDialog(null, "Music Scale Master\n--------------------------------" + "\n1.Guess an Entire Scale" + "\n2.Guess a notes position" 
            + "\n3.Guess triads" + "\n4.Guess Major-Minor-Dim Sequence" + "\n5.Exit", "Main Menu", JOptionPane.INFORMATION_MESSAGE);
            menuChoice = Integer.parseInt(choice);
        }
        
        switch(menuChoice)
        {
            case 1:
                guessMain.guessEntireScale();
                mainMenu();
                break;
            case 2:
                guessMain.guessNotePosition();
                mainMenu();
                break;
            case 3:
                guessMain.guessChordTriad();
                mainMenu();
                break;
            case 4:
                guessMain.guessChordSequence();
                mainMenu();
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "Thanks for playing Music Scale Mastery by Robert LoCicero", "Thank You", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Sorry, something went wrong.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
