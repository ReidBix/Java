import java.net.URI;
import java.awt.Desktop;
import java.lang.Thread;

/**
 * 
 * @author Joe Urbanek jcu5df, Reid Bixler rmb3yz
 * 
 */

public class Video implements Comparable<Video>, Playable {

	private String videoName;
	private String user;
	private String title;
	private int minutes;
	private int seconds;

	// BLOCK_ADJUSTMENT used to increase time we block when playing a song to
	// allow for
	// time it takes to get video to start up in browser. Adjust for your system
	// if needed.
	private static final int BLOCK_ADJUSTMENT = 3; // units are seconds

	/**
	 * 
	 * Constructor for the Video class that takes a user, title, time, and video URL
	 */
	public Video(String user, String title, int min, int sec, String videoName) {
		this.user = user;
		this.title = title;
		this.minutes = min;
		this.seconds = sec;
		this.videoName = videoName; // must in this form:
									// http://www.youtube.com/embed/FzRH3iTQPrk

		if (!videoName.toLowerCase()
				.startsWith("http://www.youtube.com/embed/")) {
			System.out.println("* Constructor given videoName " + videoName
					+ " which is not the proper form.");
			System.out.println("* This video will almost certainly not play.");
		}
	}

	/**
	 * 
	 * The play method will play the entire length of a video for however long
	 * the video's length is
	 */
	public void play() {
		this.play(this.minutes * 60 + this.seconds);
	}

	/**
	 * 
	 * The play method that will play the desired number of seconds of a video
	 */
	public void play(double sec) {
		try {
			Desktop.getDesktop().browse(new URI(videoName + "?autoplay=1"));
			Thread.sleep((int) (1000 * (sec + BLOCK_ADJUSTMENT))); // block
																	// for
																	// length
																	// of
																	// song
		} catch (Exception e) {
			System.out.println("* Error: " + e + " when playing YouTube video "
					+ videoName);
		}
	}

	/**
	 * 
	 * Plays two different videos to check that the video embed works
	 */
	public static void main(String[] args) {
		Video v1 = new Video("jimvwmoss", "The Sneezing Baby Panda", 0, 17,
				"http://www.youtube.com/embed/4hpEnLtqUDg");
		System.out.println("* Playing video for 10 seconds.");
		v1.play(10);

		Video v2 = new Video("jimvwmoss", "The Sneezing Baby Panda", 0, 17,
				"http://www.youtube.com/embed/FzRH3iTQPrk");
		System.out.println("* Playing video for full length.");
		v2.play();

		System.out.println("* Should be done when this prints.");

	}

	@Override
	public String getName() {
		return this.title;
	}

	@Override
	public int getPlayTimeSeconds() {
		return (int) (minutes * 60 + seconds);
	}

	@Override
	public String toString() {
		return "{Video: user=" + user + " title=" + title + "}\nPlayTime: "
				+ minutes + ":" + seconds;
	}

	/**
	 * Returns true if o is a Song that is the exact same as the original song.
	 */
	public boolean equals(Object o) {
		if (o instanceof Video) {
			Video v = (Video) o;
			boolean isEqual = this.user.equals(v.getUser())
					&& this.title.equals(v.getTitle())
					&& this.minutes == v.getMinutes()
					&& this.seconds == v.getSeconds()
					&& this.videoName.equals(v.getVideoName());
			return isEqual;
		}
		return false;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * CompareTo method to tell which videos should be listed greater than others
	 */
	public int compareTo(Video o) {
		int retVal = user.compareTo(o.user);
		if (retVal != 0)
			return retVal;
		retVal = this.title.compareTo(o.title);
		if (retVal != 0)
			return retVal;
		retVal = this.getPlayTimeSeconds() - o.getPlayTimeSeconds();
		return retVal;
	}

}
