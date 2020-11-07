import java.util.Random;
import java.util.ArrayList;

import javax.print.attribute.standard.JobHoldUntil;
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
  
        String[] aMinorNotes = new String[] {"A", "B", "C", "D", "E", "F", "G"};
        String[] cMinorNotes = new String[] {"C", "D", "D#", "F", "G", "G#", "A#"};

        // Creates Multiple Scales, adds them to the arrayList to be chosen from
        Scale aMajor = new Scale("A Major", aMajorNotes, majorChordSequence, 7);
        Scale cMajor = new Scale("C Major", cMajorNotes, majorChordSequence, 7);
        Scale aMinor = new Scale("A Minor", aMinorNotes, minorChordSequence, 7);
        Scale cMinor = new Scale("C Minor", cMinorNotes, minorChordSequence, 7);

        // Add the scales to the ArrayList
        scalesArrayList.add(aMajor);
        scalesArrayList.add(cMajor);
        scalesArrayList.add(aMinor);
        scalesArrayList.add(cMinor);



    }

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
                guesses++;
            }

            if (guesses == 1)
            {
                JOptionPane.showMessageDialog(null, "Correct! It took you " + guesses + " try!", "Good Job", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Correct! It took you " + guesses + " tries.", "Good Job", JOptionPane.INFORMATION_MESSAGE);
            }

            guesses = 1;
        } while(playAgain());
    }

    public void guessNotePosition()
    {
        int guesses = 1;
        Scale scale;
        do
        {   
            scale = getRandomScale();
            String[] notes = scale.getNotes();
            int r = rand.nextInt(scale.getNoteCount());
            String note = notes[r];
            
            
            String guess = JOptionPane.showInputDialog(null, "What note position is " + note + " in the " + scale.getName() + " scale?");
            int answer = Integer.parseInt(guess);
            while (answer < 0 || answer > 7)
            {
                JOptionPane.showMessageDialog(null, "Enter a number between 1 and 7", "Error", JOptionPane.ERROR_MESSAGE);
                guess = JOptionPane.showInputDialog(null, "What note position is " + note + " in the " + scale.getName() + " scale?");
                answer = Integer.parseInt(guess);
            }
            
            while(answer != r + 1)
            {
                JOptionPane.showMessageDialog(null, "Incorrect, try again!\nWrong Guesses: " + guesses);
                guess = JOptionPane.showInputDialog(null, "What note position is " + note + " in the " + scale.getName() + " scale?");
                answer = Integer.parseInt(guess);
                guesses++;
            }

            if (guesses == 1)
            {
                JOptionPane.showMessageDialog(null, "Correct! It took you " + guesses + " try!", "Good Job", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Correct! It took you " + guesses + " tries.", "Good Job", JOptionPane.INFORMATION_MESSAGE);
            }

            guesses = 1;

        } while(playAgain());
    }

    public void guessChords()
    {
        do
        {

        } while(playAgain());
    }

    public void guessChordSequence()
    {
        do
        {

        } while(playAgain());
    }

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

    public Scale getRandomScale()
    {
        int r = rand.nextInt(scalesArrayList.size());
        Scale scale = scalesArrayList.get(r);
        return scale;
    }

    
}
