import java.util.Comparator;

/**
 * 
 * @author Joe Urbanek jcu5df, Reid Bixler rmb3yz
 * 
 */
public class CompareSeconds implements Comparator<Playable> {
	/**
	 * Compares two playables
	 */
	public int compare(Playable o1, Playable o2) {
		return o1.getPlayTimeSeconds() - o2.getPlayTimeSeconds();

	}
}
