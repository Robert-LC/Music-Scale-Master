import java.util.Random;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Guess has multiple methods to help the user learn
 * scales through different games.
 * 
 * @since November 6, 2020
 * @author Robert LoCicero
 * 
*/
public class Guess 
{
    private Random rand;
    private ArrayList<Scale> scalesArrayList;
   
    /**
     * Constructor that sets up the scale objects that may be chosen
     * 
     * @since November 6, 2020
    */
    public Guess()
    {
        scalesArrayList = new ArrayList<>();
        rand = new Random();
        
        // Only two chord sequences, depending on if the key is major or minor
        String[] majorChordSequence = new String[] {"Maj", "min", "min", "Maj", "Maj", "min", "dim"};
        String[] minorChordSequence = new String[] {"min", "dim", "maj", "min", "min", "maj", "maj"};
  
        // In an ideal world, these would be loaded into the program from a database or a file.
        String[] aMajorNotes = new String[] {"A", "B", "C#", "D", "E", "F#", "G#"};
        String[] cMajorNotes = new String[] {"C", "D", "E", "F", "G", "A", "B"};
        String[] eMajorNotes = new String[] {"E", "F#", "G#", "A", "B", "C#", "D#"};
  
        String[] aMinorNotes = new String[] {"A", "B", "C", "D", "E", "F", "G"};
        String[] cMinorNotes = new String[] {"C", "D", "D#", "F", "G", "G#", "A#"};
        String[] eMinorNotes = new String[] {"E", "F#", "G", "A", "B", "C", "D"};

        // Creates Multiple Scales
        Scale aMajor = new Scale("A Major", aMajorNotes, majorChordSequence, 7);
        Scale cMajor = new Scale("C Major", cMajorNotes, majorChordSequence, 7);
        Scale eMajor = new Scale("E Major", eMajorNotes, majorChordSequence, 7);
        Scale aMinor = new Scale("A Minor", aMinorNotes, minorChordSequence, 7);
        Scale cMinor = new Scale("C Minor", cMinorNotes, minorChordSequence, 7);
        Scale eMinor = new Scale("E Minor", eMinorNotes, minorChordSequence, 7);

        // Add the scales to the ArrayList
        scalesArrayList.add(aMajor);
        scalesArrayList.add(cMajor);
        scalesArrayList.add(eMajor);
        scalesArrayList.add(aMinor);
        scalesArrayList.add(cMinor);
        scalesArrayList.add(eMinor);
    }

    /**
     * Has the user guess all the notes in a random scale.
     * The user's input is trimmed of all spaces and uppercased to allow
     * for comparison.
     * 
     * @since November 5, 2020
    */
    public void guessEntireScale()
    {
        int guesses = 1;
        Scale scale;

        do 
        {
            scale = getRandomScale();

            // Takes the user's input, strip all spaces with a regex and convert it to uppercase.
            String guess = JOptionPane.showInputDialog(null, "Guess all the notes in " + scale.getName());
            guess = guess.replaceAll("\\s+", "").toUpperCase();
        
        
            // Loops until the user guess the correct order
            while (!guess.equals(scale.toStringNotes()))
            {
                JOptionPane.showMessageDialog(null, "Incorrect, try again!\nWrong Guesses: " + guesses);
                guess = JOptionPane.showInputDialog(null, "Guess all the notes in " + scale.getName());
                guess = guess.replaceAll("\\s+", "").toUpperCase();
                guesses++;
            }

            countGuesses(guesses);
            guesses = 1;

        } while(playAgain());
    }

    /**
     * The user is given a random note in a random scale.
     * The user has to guess the numerical position of the note in the scale.
     * The game loops until the user no longer wants to continue and counts the number of tries until a correct answer.
     * @since November 5, 2020
     */
    public void guessNotePosition()
    {
        int guesses = 1;
        Scale scale;

        do
        {   
            scale = getRandomScale();

            /*
            * Takes the random scale's notes and picks a number between 0 and the number of notes in the scale. 
            * The random number is then used to index the array, returning a random note.
            **/
            String[] notes = scale.getNotes();
            int r = rand.nextInt(scale.getNoteCount());
            String note = notes[r];
            
            
            String guess = JOptionPane.showInputDialog(null, "What note position is " + note + " in the " + scale.getName() + " scale?");
            int answer = Integer.parseInt(guess);
            while (answer < 0 || answer > scale.getNoteCount())
            {
                JOptionPane.showMessageDialog(null, "Enter a number between 1 and " + scale.getNoteCount() + ".", "Error", JOptionPane.ERROR_MESSAGE);
                guess = JOptionPane.showInputDialog(null, "What note position is " + note + " in the " + scale.getName() + " scale?");
                answer = Integer.parseInt(guess);
            }
            
            // 1 is added to r because arrays start at 0! 
            while(answer != r + 1)
            {
                JOptionPane.showMessageDialog(null, "Incorrect, try again!\nWrong Guesses: " + guesses);
                guess = JOptionPane.showInputDialog(null, "What note position is " + note + " in the " + scale.getName() + " scale?");
                answer = Integer.parseInt(guess);
                guesses++;
            }

            countGuesses(guesses);
            guesses = 1;

        } while(playAgain());
    }

    /**
     * The user is given a random scale, and has to name the notes to make a triad
     * (1st, 3rd, and 5th notes). 
     * 
     * @since November 7, 2020
     */
    public void guessChordTriad()
    {
        int guesses = 1;
        Scale scale;
        ArrayList<String> chordTriad;

        // The game is looped until the user returns no from playAgain. The guesses are reset to one if they play again
        do
        {
            scale = getRandomScale();
            String[] notes = scale.getNotes();
            chordTriad = new ArrayList<>();
            
            //Returns the 1st, 3rd, and 5th notes (Chord Triad) and inserts them into their own arrayList.
            for(int i = 0; i <= 4; i += 2)
            {
                String addedNote = notes[i];
                chordTriad.add(addedNote);
            }

            // Merge the chordTriad arrayList into a single string that can be used for comparison
            String answerChord = String.join("", chordTriad).toUpperCase();

            // Takes the user's input, strip all spaces with a regex and convert it to uppercase.
            String guess = JOptionPane.showInputDialog(null, "What notes make a chord triad in the " + scale.getName() + " scale?");
            guess = guess.replaceAll("\\s+", "").toUpperCase();

            while(!guess.equals(answerChord))
            {
                JOptionPane.showMessageDialog(null, "Incorrect, try again!\nWrong Guesses: " + guesses);
                guess = JOptionPane.showInputDialog(null, "What notes make a chord triad in the " + scale.getName() + " scale?");
                guess = guess.replaceAll("\\s+", "").toUpperCase();
                guesses++;
            }

            countGuesses(guesses);
            guesses = 1;

        } while(playAgain());
    }

    /**
     * Allows the user to guess the Maj-min-dim chord sequence for a random scale.
     * The function uses a regex and string manipulation to compare the users entered string
     * to the scales chord sequence.
     * 
     * 
     * @since November 7, 2020
     */
    public void guessChordSequence()
    {
        int guesses = 1;
        Scale scale;

        // The game is looped until the user returns no from playAgain. The guesses are reset to one if they play again
        do
        {
            scale = getRandomScale();
            
            String guess = JOptionPane.showInputDialog(null, "Guess the Maj-min-dim chord sequence for " + scale.getName());

            // Takes the user's input, strip all spaces with a regex and convert it to uppercase.
            guess = guess.replaceAll("\\s+", "").toUpperCase();
            while (!guess.equals(scale.toStringChordSequence()))
            {
                JOptionPane.showMessageDialog(null, "Incorrect, try again!\nWrong Guesses: " + guesses);
                guess = JOptionPane.showInputDialog(null, "Guess the Maj-min-dim chord sequence for " + scale.getName());
                guess = guess.replaceAll("\\s+", "").toUpperCase();
                guesses++;
            }

            countGuesses(guesses);
            guesses = 1;
        } while(playAgain());
    }

    /**
     * Loops to allow the user to play again, makes sure 1 or 2 is entered
     * 
     * 
     * @since November 7, 2020
     * @return - Boolean indicating yes or no.
     */
    public boolean playAgain()
    {
        int userContinue;
        boolean playAgain;

        userContinue = Integer.parseInt(JOptionPane.showInputDialog(null, "Do you want to play again?\n1.Yes\n2.No"));
        while(userContinue < 1 || userContinue > 2)
        {
            JOptionPane.showMessageDialog(null, "Enter 1 or 2", "Error", JOptionPane.ERROR_MESSAGE);
            userContinue = Integer.parseInt(JOptionPane.showInputDialog(null, "Do you want to play again?\n1.Yes\n2.No"));
        }

        if(userContinue == 1)
        {
            playAgain = true;
        }
        else
        {
            playAgain = false;
        }
        
        return playAgain;
    }

    /**
     * Picks a random number which is the size of the arrayList containing all scales.
     * Using that random number it indexes from the arrayList.
     * 
     * @since November 7, 2020
     * @return - Scale Object picked randomly from an ArrayList of all scales
     */
    public Scale getRandomScale()
    {
        int r = rand.nextInt(scalesArrayList.size());
        Scale scale = scalesArrayList.get(r);
        return scale;
    }

    /**
     * Simple function to change the grammar depending on how many guessues
     * it took the user to complete a game.
     * 
     * @param guesses - takes the amount of guesses the user used
     * @since November 7, 2020
     */
    public void countGuesses(int guesses)
    {
        if (guesses == 1)
            {
                JOptionPane.showMessageDialog(null, "Correct! It took you " + guesses + " try!", "Good Job", JOptionPane.INFORMATION_MESSAGE);
            }
        else
            {
                JOptionPane.showMessageDialog(null, "Correct! It took you " + guesses + " tries.", "Good Job", JOptionPane.INFORMATION_MESSAGE);
            }
    }
}
