/**
 * Name: Reid Bixler
 * Computing ID: rmb3yz
 * Assignment: Homework 1
 * Lab Section: 2110-103
 * Date: February 10, 2014
 */

/**
 * 
 * @author Reid rmb3yz
 * 
 */
public class Song implements Comparable<Song> {
	private String artist; // the artist performing the song
	private String title; // the title of the song
	private int minutes; // number of min in length
	private int seconds; // number of seconds of length of the song (always
							// less than 60)

	/**
	 * Constructor for the Song class that takes a given artist and title
	 * 
	 * @param artist
	 * @param title
	 */
	public Song(String artist, String title) {
		this.artist = artist;
		this.title = title;
	}

	/**
	 * Constructor for the Song class that takes a given artist, title, and time
	 * consisting of two integers for minutes and seconds
	 * 
	 * @param artist
	 * @param title
	 * @param minutes
	 * @param seconds
	 */
	public Song(String artist, String title, int minutes, int seconds) {
		this.artist = artist;
		this.title = title;
		int extraM = seconds / 60;
		this.minutes = minutes + extraM;
		this.seconds = seconds % 60;
	}

	/**
	 * Constructor for the Song class that takes a given song
	 * 
	 * @param s
	 */
	public Song(Song s) {
		this.artist = s.artist;
		this.title = s.title;
		int extraM = s.seconds / 60;
		this.minutes = s.minutes + extraM;
		this.seconds = s.seconds % 60;
	}

	/**
	 * Equals method for Song class that is only true if all 4 fields are equal,
	 * else will return false
	 */
	public boolean equals(Object o) {
		if (o instanceof Song) {
			Song s = (Song) o;
			boolean artistB = this.artist.equals(s.artist);
			boolean titleB = this.title.equals(s.title);
			boolean minutesB = this.minutes == s.minutes;
			boolean secondsB = this.seconds == s.seconds;
			return artistB && titleB && minutesB && secondsB;
		} else
			return false;
	}

	@Override
	public String toString() {
		return "{Song: title=" + title + " artist=" + artist + "}";
	}

	/**
	 * Play method for the Song class, plays the song
	 */
	public void play() {
		System.out.printf("Playing Song: artist=%-20s title=%s\n", artist,
				title);
	}

	/**
	 * compareTo method for the Song class that orders by artist first, then by
	 * title if the artists are equal, then shortest first if both artist and
	 * title are equal
	 */
	@Override
	public int compareTo(Song s) {
		int retVal = this.artist.compareTo(s.artist);
		if (retVal != 0)
			return retVal;
		retVal = this.title.compareTo(s.title);
		if (retVal != 0)
			return retVal;
		int minutes1 = this.minutes;
		int minutes2 = s.minutes;
		int seconds1 = this.seconds;
		int seconds2 = s.seconds;
		seconds1 = seconds1 + minutes1 * 60;
		seconds2 = seconds2 + minutes2 * 60;
		if (seconds1 < seconds2)
			return -1;
		if (seconds1 > seconds2)
			return 1;
		else
			return 0;
	}

	// Getters / Setters for all fields

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	/**
	 * Changing setSeconds method so that any input of more than 60 seconds
	 * converts to minutes
	 * 
	 * @param seconds
	 */
	public void setSeconds(int seconds) {
		int extraM = seconds / 60;
		this.minutes = this.getMinutes() + extraM;
		this.seconds = seconds % 60;
	}
}
