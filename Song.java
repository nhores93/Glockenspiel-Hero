/**
 * This class plays the song at a specified speed. 
 * @author Nathania Hores
 */
public class Song extends AbstractSong {

    private int speed;

    /**
     * Takes in an array of notes, song name, and song speed. 
     * @param Array of notes
     * @param Song name
     * @param Song speed
     */
    public Song(Note[] notes, String nameOfSong, int speed) {
        super(notes, nameOfSong);
        this.speed = speed;
    }

    /**
     * Plays the song and displays the song title. 
     * Determines if there is a bad note in the song.
     * Plays the song at the specified speed.
     * @param None
     */
    public void playSong() {
        System.out.println("Playing: "+nameOfSong);
        for (int i = 0; i < notes.length; i++) {
            if (!notes[i].isBadnote()) {
                double duration = notes[i].getDuration();
                if (speed != 1) {

                    notes[i].setDuration(duration / speed);

                }
                notes[i].playSound();
                //set back the duration
                notes[i].setDuration(duration);
            }

        }
    }

}
