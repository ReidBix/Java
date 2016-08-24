import edu.virginia.cs2110.Mp3FilePlayer;

/**
 * @author Joseph Urbanek jcu5df, Reid Pixler rmb3yz
 * Homework 1
 * Lab Section 103
 */

public class Song implements Comparable<Song>, Playable
{
	private String artist;
	private String title;
	private int minutes;
	private int seconds;
	private String fileName;

	/**
	 * 
	 * @return fileName
	 */
	public String getFileName()
	{
		return fileName;
	}

	/**
	 * @return
	 * Returns artist.
	 */
	public String getArtist()
	{
		return artist;
	}

	/**
	 * 
	 * @param artist
	 * Sets the artist to the string in the parameter.
	 */
	public void setArtist(String artist)
	{
		this.artist = artist;
	}

	/**
	 * @return
	 * Returns title.
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * 
	 * @param title
	 * Sets the title to the string in the parameter.
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * 
	 * @return
	 *  Returns the minutes of the song.
	 */
	public int getMinutes()
	{
		return minutes;
	}

	/**
	 * 
	 * @param minutes
	 * Sets the minutes of the song.
	 */
	public void setMinutes(int minutes)
	{
		this.minutes = minutes;
	}

	/**
	 * 
	 * @return
	 * Returns the seconds in the song
	 */
	public int getSeconds()
	{
		return seconds;
	}

	/**
	 * 
	 * @return
	 * Returns the total length of the song in seconds
	 */
//	public int getLength()
//	{
//		return minutes * 60 + seconds;
//	}

	/**
	 * 
	 * @param seconds
	 * Sets the seconds in the song to the integer in the parameter.
	 */
	public void setSeconds(int seconds)
	{
		this.seconds = seconds % 60;
		this.minutes += seconds / 60;
	}
	/**
	 * 
	 * @param artist
	 * @param title
	 * Constructor for Song; Sets initial time to 0:00
	 */
	public Song(String artist, String title, String fileName)
	{
		this.artist = artist;
		this.title = title;
		this.minutes = 0;
		this.seconds = 0;
		this.fileName = fileName;
	}

	/**
	 * 
	 * @param artist
	 * @param title
	 * @param minutes
	 * @param seconds
	 * Constructor for Song with minutes and seconds.
	 */
	public Song(String artist, String title, int minutes, int seconds, String fileName)
	{
		this.artist = artist;
		this.title = title;
		this.minutes = minutes + seconds / 60;
		this.seconds = seconds % 60;
		this.fileName = fileName;
	}

	/**
	 * 
	 * @param s
	 * Constructor for Song where the Song is given.
	 */
	public Song(Song s)
	{
		this.artist = s.getArtist();
		this.title = s.getTitle();
		this.minutes = s.getMinutes();
		this.seconds = s.getSeconds();
		this.fileName = s.getFileName();
	}

	/**
	 * Returns true if o is a Song that is the exact same as the original song.
	 */
	public boolean equals(Object o)
	{
		if (o instanceof Song)
			return this.artist.equals(((Song) o).getArtist()) && this.title.equals(((Song) o).getTitle()) && this.minutes == ((Song) o).getMinutes() && this.seconds == ((Song) o).getSeconds() && this.fileName.equals(((Song) o).getFileName());
		return false;
	}

	/**
	 * Returns a string representation of a Song
	 */
	public String toString()
	{
		return "{Song: title= " + title + " artist=" + artist + "}\nPlayTime: " + minutes + ":" + seconds;
	}

	/**
	 * Plays the song.
	 */
	public void play()
	{
		System.out.printf("Playing Song: artist=%-20s title=%s\n", artist, title);
	}

	/**
	 * Returns an integer that represents how different two songs are based on their author, their title, then their length.
	 */
	public int compareTo(Song o)
	{
		int retVal = title.compareTo(o.title);
		if (retVal != 0)
			return retVal;
		retVal = this.artist.compareTo(o.artist);
		if (retVal != 0)
			return retVal;
		retVal = this.getPlayTimeSeconds() - o.getPlayTimeSeconds();
		return retVal;
	}
	@Override
	public void play(double secs)
	{
		Mp3FilePlayer m = new Mp3FilePlayer(this.fileName);
		m.playAndBlock(secs);
	}

	@Override
	public String getName()
	{
		return this.title;
	}

	@Override
	public int getPlayTimeSeconds()
	{
		return minutes * 60 + seconds;
	}

}
