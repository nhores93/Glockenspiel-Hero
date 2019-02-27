package songs;
import java.util.Scanner;

/**
 * This is the driver class that tests all methods. 
 * It is the entry point that allows the user to choose between
 * playing the game or playing the song.
 * @author Nathania Hores
 */
public class Main {

    public static void main(String[] args) {
        
        String name = args[0];
        String data[] = new String [args.length-1];
        for(int i=1;i<args.length;i++) {
            data[i-1] = args[i];
        }

        Note[] notes = new Note[data.length / 2];
        String note = null;
        String duration = null;
        int countNotes = 0;
        int i = 0;
        boolean noteTurn = true;
        while (i < data.length) {
            note = null;
            duration = null;

            while (noteTurn && i < data.length) {
                note = data[i];
                if (note.charAt(0) >= 'A') {
                    noteTurn = false;
                }
                i++;
            }
            
            while (!noteTurn && i < data.length) {
                duration = data[i];
                try {
                    Double.parseDouble(duration);
                    noteTurn = true;
                } catch (Exception e) {
                }
                i++;
            }
            if (i <= data.length && note != null && duration != null) {
                notes[countNotes++] = new Note(note, duration);
            }

        }
        //correct length of notes array in case of any data error
        Note[] notes2 = new Note[countNotes];
        for (i = 0; i < countNotes; i++) {
            notes2[i] = notes[i];
        }
        notes = notes2;

        //get choice to play song or interactively play song
        String choices[] = {"Play Song", "Play Game"};
        int choice = menuChoice(choices);
        if (choice == 1) {
            System.out.print("Enter the speed to play the song. \n 1 will play at a normal frequency. \n 2 will play at a slower frequency etc. ");
            int speed = getInt();
            Song s = new Song(notes, name, speed);
            s.playSong();
        } else if (choice == 2) {
            InteractiveSong s = new InteractiveSong(notes, name);
            s.playSong();
        } else {
            System.out.println("Goodbye");
        }

    }

    /**
     * Method to display user choices and return choice as integer
     * @param Array of choices
     * @return Choice
     */
    public static int menuChoice(String choices[]) {
        int choice = 0;
        System.out.println("");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ". " + choices[i]);
        }
        System.out.print("Enter choice (1-" + choices.length + "): ");
        choice = getInt();
        while (choice < 1 || choice > choices.length) {
            System.out.println("Invalid choice.");
            System.out.print("Enter choice (1-" + choices.length + "): ");
            choice = getInt();
        }
        return choice;
    }

    /**
     * Helper method to get int value from user
     * @return User input
     */
    public static int getInt() {
        Scanner input = new Scanner(System.in);
        int num = -1;
        boolean good;
        do {
            good = true;
            try {
                num = input.nextInt();
            } catch (Exception e) {
                good = false;
                input = new Scanner(System.in);
                System.out.println("Enter numeric value: ");
            }
        } while (!good);
        return num;
    }
}
