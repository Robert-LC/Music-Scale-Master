import javax.swing.JOptionPane;

/** 
 * The Scale class creates a musical scale that has various
 * methods to return attributes of the scale in either an array format
 * or a filtered string for comparison purposes.
 * @since November 7, 2020
 * @author Robert Locicero
*/
public class Scale 
{
    private String name;
    private String[] notes;
    private String[] chordSequence;
    private int noteCount;

    public Scale(String name, String[] notes, String[] chordSequence, int noteCount)
    {
        setName(name);
        setNotes(notes);
        setChordSequence(chordSequence);
        setNoteCount(noteCount);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setNotes(String[] notes)
    {
        while(notes.length > 7 && notes.length < 5)
        {
            JOptionPane.showMessageDialog(null, "Please enter a scale with 7 or 5 notes.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        this.notes = notes;
    }

    public void setChordSequence(String[] chordSequence)
    {
        while(chordSequence.length > 7 && chordSequence.length < 5)
        {
            JOptionPane.showMessageDialog(null, "Please enter a Chord Sequence with 7 or 5 notes.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        this.chordSequence = chordSequence;
    }

    public void setNoteCount(int noteCount)
    {
        this.noteCount = noteCount;
    }

    public String getName()
    {
        return name;
    }

    public String[] getNotes()
    {
        return notes;
    }

    public String[] getChordSequence()
    {
        return chordSequence;
    }

    
    public int getNoteCount()
    {
        return noteCount;
    }

    /**
     * Take the Scale's array of notes, combines them into a single string,
     * trims the spaces and converts it to uppercase.
     * 
     * @since November 7, 2020
     * @return An uppercase string with spaces removed.
     */
    public String toStringNotes()
    {
        String notesString = String.join("", getNotes()).toUpperCase();
        return notesString;
    }

    /**
     * Take the Scale's Major-min-dim chord sequence, combines them into a single string,
     * trims the spaces and converts it to uppercase.
     * 
     * @since November 7, 2020
     * @return An uppercase string with spaces removed.
     */
    public String toStringChordSequence()
    {
        String chordSequenceString = String.join("", getChordSequence()).toUpperCase();
        return chordSequenceString;
    }
}
