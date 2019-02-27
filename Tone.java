package songs;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
/**
 * This class plays the individual notes. 
 */
public class Tone {
    public static void playNote (double hz, double duration)
	{
		int n = (int) (StdAudio.SAMPLE_RATE * duration);

		// build sine wave with desired frequency
		double[] a = new double[n+1];
		for (int j = 0; j <= n; j++)
		{
			a[j] = Math.sin(2 * Math.PI * j * hz / StdAudio.SAMPLE_RATE);
		}
		// play using standard audio
		StdAudio.play(a);
    }
}
