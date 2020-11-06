import java.util.Random;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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

        // Randomly pull a Scale
        int r = rand.nextInt(scalesArrayList.size());
        Scale scale = scalesArrayList.get(r);

        // Takes the user's input, strip all spaces with a regex and convert it to uppercase.
        String guess = JOptionPane.showInputDialog(null, "Guess all the notes in " + scale.getName());
        guess = guess.replaceAll("\\s+", "").toUpperCase();
        
        // Loops until the user guess the correct order
        while (!guess.equals(scale.toStringNotes()))
        {
            JOptionPane.showMessageDialog(null, "Incorrect, try again!");
            guess = JOptionPane.showInputDialog(null, "Guess all the notes in " + scale.getName());
        }
        
        JOptionPane.showMessageDialog(null, "Correct!", "Good Job", JOptionPane.INFORMATION_MESSAGE);
        
    }

    public void guessNotePosition(Scale scale)
    {

    }

    public void guessChords(Scale scale)
    {

    }

    public void guessChordSequence(Scale scale)
    {

    }


}
