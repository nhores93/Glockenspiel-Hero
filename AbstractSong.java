/**
 * Array of notes, and name of song.
 * @author  
 */
public class AbstractSong
{
  
   /**
   * Instance variables
   * Array of Notes â€“ holds the note object needed to play the song
   * nameOfSong â€“ String
   * 
   */
   protected Note[] notes;
   protected String nameOfSong;
 
  
   /**
   * Constructor
   * Takes in the name of the song and a String array of Notes,
   * (A4, G3 etc)
   * Sets the nameOfSong instance variable
   * Uses the String array of Notes to fill the Array of Notes
   * with Note objects.
   */
   public AbstractSong(Note[] notes, String nameOfSong)
   {
       this.notes = notes;
       this.nameOfSong = nameOfSong;
   }
  
  
   /**
   * Methods
   * getNameOfSong â€“ accessor method for name of song
   * getNextNote â€“ returns the next Note object in the array.
   * isEndOfSong â€“ returns true if end of song, false if not
   * toString â€“ returns all the Notes in the array in a neatly formatted String
   * @return
   */
  
   public String getNameOfSong()
   {
       return nameOfSong;
   }
  
   public String getNextNote(String nextNote)
   {
       return nextNote;
   }

   public boolean isEndOfSong(Object song, Object endOfSong)
   {
       if (song == endOfSong)
       {
           return true;
       }
       return false;
      
   }
  
   @Override
   public String toString()
   {
      String s= "";
      for(int i=0;i<notes.length;i++) {
          s+= notes[i]+" ";
      }
      return s;
   }


}
