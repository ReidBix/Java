import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Joseph Urbanek jcu5df, Reid Bixler rmb3yz Homework 1 Lab Section 103
 */
public class PlayList implements Playable {

	private String name;
	private ArrayList<Playable> playableList = new ArrayList<Playable>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Playable> getPlayableList() {
		return playableList;
	}

	public void setPlayableList(ArrayList<Playable> playableList) {
		this.playableList = playableList;
	}

	/**
	 * Returns the list of Songs, based on the Song toString()
	 */
	public String toString() {
		return this.name + ": " + this.playableList;
	}

	/**
	 * Empty Constructor for Playlist. Assigns "Untitled" to Playlist title.
	 */
	public PlayList() {
		this.name = "Untitled";
	}

	/**
	 * Constructor for PlayList. Assigns s to the playlist title
	 * 
	 * @param s
	 */
	public PlayList(String s) {
		this.name = s;
	}

	/**
	 * 
	 * @return True if the playableList has songs to clear Also clears the
	 *         playableList
	 */
	public boolean clear() {
		if (this.playableList.size() != 0) {
			this.playableList.clear();
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param s
	 * @return True if the song was added at the end of the playlist. Adds the
	 *         song to the end of the playlist
	 */
	public boolean addSong(Song s) {
		playableList.add(s);
		return (playableList.get(playableList.size() - 1).equals(s));

	}

	// /**
	// *
	// * @param index
	// * @return The song removed at index
	// * Removes song from the playableList
	// */
	// public Song removeSong(int index)
	// {
	// if (index < 0 || index >= playableList.size())
	// return null;
	// Song s = playableList.get(index);
	// playableList.remove(index);
	// return s;
	// }
	//
	// /**
	// *
	// * @param s
	// * @return Song s
	// * Removes all instances where a song appears in the playableList
	// */
	// public Song removeSong(Song s)
	// {
	// for (int i = 0; i < playableList.size(); i++)
	// if (playableList.get(i).equals(s))
	// playableList.remove(s);
	// return s;
	// }
	//
	/**
	 * 
	 * @param index
	 * @return The song that is at index.
	 */
	public Playable getPlayable(int index) {
		if (index < 0 || index >= playableList.size())
			return null;
		return playableList.get(index);
	}

	/**
	 * Sorts the list of songs alphabetical order starting with the time.
	 * Implements compareTo() method of Song
	 */

	public void sortByTime() {
		Collections.sort(playableList, new CompareSeconds());
	}

	/**
	 * sorts the list of playables by name of the playable.
	 */
	public void sortByName() {
		Collections.sort(playableList, new CompareName());
	}

	/**
	 * 
	 * @return the amount of songs in the playlist.
	 */
	public int size() {
		return playableList.size();
	}

	/**
	 * 
	 * @param pl
	 * @return false if the playableList contains the playlist adds playList to
	 *         the playableList
	 */
	public boolean addPlayList(PlayList pl) {
		if (playableList.contains(pl))
			return false;
		playableList.add(pl);
		return true;
	}

	/**
	 * 
	 * @return the total amount of time in MM:SS or HH:MM:SS form of the
	 *         playlist.
	 */
	public String totalPlayTime() {
		int min = 0;
		int sec = 0;
		for (int i = 0; i < playableList.size(); i++) {
			min += ((Song) playableList.get(i)).getMinutes();
			sec += ((Song) playableList.get(i)).getSeconds();
		}
		min += sec / 60;
		sec %= 60;
		int hours = min / 60;
		min %= 60;
		String minZero = "" + min;
		String secZero = "" + sec;
		String hoursZero = "" + hours;
		if (min < 10)
			minZero = "0" + min;
		if (sec < 10)
			secZero = "0" + sec;
		if (hours == 0)
			return minZero + ":" + secZero;
		if (hours < 10)
			hoursZero = "0" + hours;
		return hoursZero + ":" + minZero + ":" + secZero;
	}

	/**
	 * 
	 * @return the total number of seconds of the songs in the playlist
	 */
	public int getPlayTimeSeconds() {
		int time = 0;
		for (int i = 0; i < playableList.size(); i++) {
			if (playableList.get(i) instanceof PlayList)
				for (int j = 0; j < ((PlayList) playableList.get(i)).size(); j++)
					time += (((PlayList) (playableList.get(i))).getPlayable(j))
							.getPlayTimeSeconds();
			if (playableList.get(i) instanceof Song)
				time += playableList.get(i).getPlayTimeSeconds();
			if (playableList.get(i) instanceof Video)
				time += playableList.get(i).getPlayTimeSeconds();
		}
		return time;
	}

	// /**
	// *
	// * @param fileName
	// * @return True if a song was added
	// * Adds song from file
	// */
	// @SuppressWarnings("resource")
	// public boolean loadSongs(String fileName)
	// {
	// try
	// {
	// Scanner scan = new Scanner(new File(fileName));
	// String mp3Name = "";
	// while (scan.hasNext())
	// {
	// String title = scan.nextLine().trim();
	// String artist = scan.nextLine().trim();
	// String time = scan.nextLine().trim();
	// String[] times = time.split(":");
	// int minutes = Integer.parseInt(times[0]);
	// int seconds = Integer.parseInt(times[1]);
	// mp3Name = scan.nextLine().trim();
	// if (!new File(mp3Name).exists())
	// return false;
	// Song s = new Song(artist, title, minutes, seconds, mp3Name);
	// playableList.add(s);
	// scan.nextLine();
	// }
	// scan.close();
	// return true;
	// }
	// catch (Exception e)
	// {
	// e.printStackTrace();
	// return false;
	// }
	// }

	/**
	 * 
	 * Takes any .txt file and takes any possible Playable Songs or Videos out of it
	 * and adds all of them to the PlayList
	 */
	public boolean loadMedia(String fileName) {
		try {
			Scanner scan = new Scanner(new File(fileName));
			int lineNumber = 0;
			String comment = "//";
			boolean isValid = true;
			boolean isVideo = false;
			String line1 = "";
			String line2 = "";
			String line3 = "";
			String line4 = "";
			int minutes = 0;
			int seconds = 0;
			while (scan.hasNextLine()) {
				String currentLine = scan.nextLine().trim();
				++lineNumber;
				String newLine = currentLine;
				if (currentLine.contains(comment)) {
					int newLineStart = 0;
					int newLineEnd = 0;
					int currentLineCheck = currentLine.indexOf(comment);
					newLineEnd = currentLineCheck;
					if (newLineEnd >= 0) {
						newLine = currentLine.substring(newLineStart,
								newLineEnd).trim();
						newLine = newLine.trim();
					}
				}
				newLine.trim();
				if (newLine.length() == 0) {
					isValid = false;
					--lineNumber;
				}
				if (isValid) {
					switch (lineNumber) {
						case 1:
							line1 = newLine.trim();
							break;
						case 2:
							line2 = newLine.trim();
							break;
						case 3:
							line3 = newLine.trim();
							if (line3.length() == 5) {
								minutes = Integer.parseInt(line3.substring(0, 2));
								seconds = Integer.parseInt(line3.substring(3));
							}
							else if (line3.length() == 4) {
								minutes = Integer.parseInt(line3.substring(0, 1));
								seconds = Integer.parseInt(line3.substring(2));
							}
							minutes = minutes + (seconds / 60);
							seconds = seconds % 60;
							break;
						case 4:
							if (newLine.length() > 7) {
								String youtube = "youtube";
								String youtubeCheck = newLine.substring(0, 7);
								youtubeCheck = youtubeCheck.toLowerCase();
								if (youtube.equals(youtubeCheck)) {
									isVideo = true;
									String http = "http://";
									line4 = newLine.trim().substring(8).trim();
									line4 = http + line4;
								}
							} else {
								line4 = newLine.trim();
								if (!new File(line4).exists())
									return false;
							}
							Playable p;
							if (isVideo) {
								String title = line1.trim();
								String user = line2.trim();
								String youtubeLocation = line4.trim();
								p = new Video(user, title, minutes, seconds,
										youtubeLocation);
							} else {
								String artist = line1.trim();
								String title = line2.trim();
								String mediaName = line4.trim();
								if (!new File(mediaName).exists())
									return false;
								p = new Song(artist, title, minutes, seconds,
										mediaName);
							}
							playableList.add(p);
							break;
					}
				}
				isValid = true;
				lineNumber = lineNumber % 4;
			}
			scan.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * Adds any type Playable into the PlayList as long as the PlayList does not
	 * already contain it
	 */
	public boolean addPlayable(Playable p) {
		if (playableList.contains(p))
			return false;
		playableList.add(p);
		return true;
	}

	/**
	 * 
	 * @param p
	 * @return true if all elements in the playList are equal
	 */
	@Override
	public boolean equals(Object p) {
		if (p instanceof PlayList) {
			for (int i = 0; i < playableList.size(); i++)
				if (!playableList.get(i).equals(
						((PlayList) p).getPlayableList().get(i)))
					return false;
			return this.name.equals(((PlayList) p).getName());
		}
		return false;
	}

	@Override
	public void play() {
		for (int i = 0; i < playableList.size(); i++) {
			if (playableList.get(i) instanceof Song)
				playableList.get(i).play();
			if (playableList.get(i) instanceof PlayList)
				for (int j = 0; j < ((PlayList) playableList.get(i)).size(); j++)
					((PlayList) playableList.get(i)).getPlayable(j).play();
			if (playableList.get(i) instanceof Video)
				playableList.get(i).play();
		}

	}

	@Override
	public void play(double seconds) {
		for (int i = 0; i < playableList.size(); i++) {
			if (playableList.get(i) instanceof Song)
				playableList.get(i).play(seconds);
			if (playableList.get(i) instanceof PlayList)
				for (int j = 0; j < ((PlayList) playableList.get(i)).size(); j++)
					((PlayList) playableList.get(i)).getPlayable(j).play(
							seconds);
			if (playableList.get(i) instanceof Video)
				playableList.get(i).play();
		}
	}

	/**
	 * 
	 * Tests if the loadMedia method can load a .txt file
	 */
	public static void main(String[] args) {
		PlayList p = new PlayList();
		System.out.println(p.loadMedia("simple.txt"));
		System.out.println(p);
	}
}
