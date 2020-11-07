import javax.swing.JOptionPane;


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
     * Take the Scale's array of notes, combine them into a single string
     * Trim the spaces and convert it to uppercase.
     * 
     * 
     * @return The Notes Array combined with spaces removed and all uppercase.
     */
    public String toStringNotes()
    {
        String notesString = String.join("", getNotes());
        notesString = notesString.toUpperCase();
        return notesString;
    }


}
