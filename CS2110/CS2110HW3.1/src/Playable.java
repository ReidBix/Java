/**
 * 
 * @author Joe Urbanek jcu5df, Reid Bixler rmb3yz
 * 
 */
public interface Playable {
	/**
	 * play Plays the playable
	 */
	public void play();

	/**
	 * play Plays the playable for seconds
	 */
	public void play(double seconds);

	/**
	 * returns the name of the playable
	 */
	public String getName();

	/**
	 * returns playtime in seconds
	 */
	public int getPlayTimeSeconds();
}
