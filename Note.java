import songs.Tone;

/**
 * This class should is used to store each note and also to convert
 * from a textual note, such as Db0 (D flat 0) to a frequency.
 * Additionally, all notes will need to be played for the duration specified in
 * the input.
 * @author Nathania Hores
 */
public class Note {

   
    private String noteWithoutOctave;
    private String note;
    private double frequency;
    private boolean badnote;
    private double duration;

    /**
     * Takes in note and duration as Strings. Sets the note
     * instance variable.
     * @param The note
     * @param The duration 
     */
    public Note(String note, String duration) {
        this.note = note;
        this.setFrequency(getFrequencyFromNote(note));
        try {
            this.duration = Double.parseDouble(duration);
        } catch (Exception e) {
            badnote = true;
        }

    }

    /**
     * Returns the note.
     * @param None
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets the note.
     * @param The note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Returns the duration.
     * @param None
     */
    public double getDuration() {
        return duration;
    }


    /**
     * Sets the duration.
     * @param The duration
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    /**
     * Returns the frequency.
     * @param None
     */
    public double getFrequency() {
        return frequency;
    }


    /**
     * Sets the frequency.
     * @param The frequency
     */
    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    /**
     * Plays a sound. Calls the Tone class' static method
     * playNote(). Passes the Note's frequency and duration to this
     * static method.
     * @param None
     */
    public void playSound() {
        Tone.playNote(frequency, duration);
    }

    /**
     * Create an array of notes. Creates an array of frequencies. 
     * Multiplies the note by the frequency and returns the value. 
     * static method.
     * @param The note
     */
    public double getFrequencyFromNote(String note) {
        String notes[] = {"C", "C#", "Db", "D", "D#", "Eb", "E", "F", "F#", "Gb", "G", "G#", "Ab", "A", "A#", "Bb", "B"};
        double freq[] = {16.35, 17.32, 17.32, 18.35, 19.45, 19.45, 20.60, 21.83, 23.12, 23.12, 24.50, 25.96, 25.96, 27.50, 29.14, 29.14, 30.87};
        int octave = 0;
        int keyNumber = -1;
        String key = "";
        if (note.length() == 3) {
            octave = Integer.parseInt(note.charAt(2) + "");

        } else if (note.length() == 2) {
            octave = Integer.parseInt(note.charAt(1) + "");
        } else {
            badnote = true;
            return 0;
        }
        key = note.substring(0, note.length() - 1);
        for (int i = 0; i < notes.length; i++) {
            if (notes[i].equalsIgnoreCase(key)) {
                keyNumber = i;
            }
        }
        
        if (keyNumber == -1) {
            badnote = true;
            return 0;
        }
        
        noteWithoutOctave =notes[keyNumber];

        return freq[keyNumber] * Math.pow(2, octave);
    }

    /**
     * Returns the note as a nicely formatted string.
     * @param None
     */
    @Override
    public String toString() {
        return note;
    }

    /**
     * Determines whether the note entered is an acceptable note.
     * @param None
     */
    public boolean isBadnote() {
        return badnote;
    }

    /**
     * Returns the note without the octave.
     * @param None
     */
    public String getNoteWithoutOctave() {
        return noteWithoutOctave;
    }

}
