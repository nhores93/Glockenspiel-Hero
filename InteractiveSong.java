import java.util.Scanner;

/**
 * This class operates in game mode. It prints the song name and plays the first note.
 * Then, the users job is to "play" the next note by typing the note (without the octave number)
 * into the console, such as A# of C. Incorrect notes causes the program to prompt the user to try again.
 * Entering a correct note will play the sound of the note and the user is expected
 * to guess the next note. The class tracks the number of wrong guesses and outputs 
 * them at the end of the song.
 * @author Nathania Hores
 */
public class InteractiveSong extends AbstractSong {

	 /**
     * Takes in an array of notes and the name of the song.
     * Makes a call to the super class constructor.
     * @param Array of notes
     * @param Name of song
     */
    public InteractiveSong(Note[] notes, String nameOfSong) {
        super(notes, nameOfSong);
    }

    /**
     * Prints the name of the song and plays the first note.
     * Keeps track of incorrect guesses. If the note is
     * correct then play the sound and ask for the next note. Prints
     * the number of correct and incorrect guesses.
     * @param None
     */
	public void playSong() {
        System.out.println("Playing: " + nameOfSong);
        int i = 0;
        int incorrect = 0;
        int count = 0;
        while (i < notes.length) {
        	 if(incorrect == 2) {
             	break;
             }
            while (notes[i].isBadnote() && i < notes.length) {
                i++;
            }
            if (count == 0 && i < notes.length) {
                notes[i].playSound();
                count++;
            } else {
                String nextNote = getString("Enter next note to play: ");
                while (!notes[i].getNoteWithoutOctave().equalsIgnoreCase(nextNote)) {
                    System.out.println("Incorrect note! Please try again.");
                    ++incorrect;
                    nextNote = getString("Enter next note to play: ");
                    if(incorrect == 2) {
                    	System.out.print("You got 3 notes incorrect. Game over.");
                    	break;
                    }
                }
                notes[i].playSound();
            }
            i++;
        }
    }

    /**
     * Gets user input.
     * @param User input
     * @return User input
     */
    public String getString(String msg) {
        System.out.print(msg);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
