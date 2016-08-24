/**
 * Name: Reid Bixler
 * Computing ID: rmb3yz
 * Assignment: Homework 1
 * Lab Section: 2110-103
 * Date: February 10, 2014
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 
 * @author Reid rmb3yz
 * 
 */
public class PlayList{

	private String name; // contains the name of the playlist
//	private ArrayList<Song> songList; // ArrayList of songs that make up the
//										// play list
	private ArrayList<Playable> playableList;

	@Override
	public String toString() {
		return "Playlist [name=" + name + ", songList=" + playableList + "]";
	}

	/**
	 * Creates an empty play list name "Untitled"
	 */
	public PlayList() {
		this.name = "Untitled";
		playableList = new ArrayList<Playable>();
	}

	/**
	 * Creates an empty play list with a given input name
	 * 
	 * @param newName
	 */
	public PlayList(String newName) {
		this.name = newName;
		playableList = new ArrayList<Playable>();
	}

	/**
	 * Takes a file that contains songs and systematically adds them one by one
	 * into the play list based on the formatting specified on the Assignments
	 * page
	 * 
	 * @param fileName
	 * @return
	 * @throws FileNotFoundException
	 */
	public boolean loadSongs(String fileName) throws FileNotFoundException {
		File f = new File(fileName);
		Scanner fileReader = new Scanner(f);
		String artist = "";
		String title = "";
		String time = "";
		int minutes = 0;
		int seconds = 0;
		while (fileReader.hasNextLine()) {
			int lineNumber = 1;
			String line = fileReader.nextLine();
			if (lineNumber == 1) {
				artist = line.trim();
			}
			if (lineNumber == 2) {
				title = line.trim();
			}
			if (lineNumber == 3) {
				time = line.trim();
				String[] array = time.split(":");
				minutes = Integer.parseInt(array[0]);
				seconds = Integer.parseInt(array[1]);
				minutes = minutes + seconds / 60;
				seconds = seconds % 60;
			}
			if (lineNumber == 4) {
				Song s = new Song(artist, title, minutes, seconds, fileName);
				playableList.add(s);
			}
			++lineNumber;
			if (lineNumber == 4) {
				lineNumber = 1;
			}
		}
		fileReader.close();
		return true;
	}

	/**
	 * Removes all songs from the play list
	 * 
	 * @return
	 */
	public boolean clear() {
		playableList.clear();
		return true;
	}

	/**
	 * Adds Song s to the end of the play list
	 * 
	 * @param s
	 * @return
	 */
	public boolean addSong(Song s) {
		playableList.add(s);
		return true;
	}

	/**
	 * Removes Song at index from the play list and returns the song, returns
	 * null if index given is out of range
	 * 
	 * @param index
	 * @return
	 */
	public Playable removeSong(int index) {
		if (index < 0 || index >= playableList.size()) {
			return null;
		} else {
			Playable s = playableList.get(index);
			playableList.remove(index);
			return s;
		}
	}

	/**
	 * Removes every occurrence of Song s from the play list and returns s,
	 * returns null if song is not found in the play list
	 * 
	 * @param s
	 * @return
	 */
	public Playable removeSong(Song s) {
		for (Playable songs : playableList) {
			if (songs.equals(s)) {
				playableList.removeAll(Collections.singleton(s));
				return s;
			}
		}
		return null;
	}

	/**
	 * Returns the song found at the input index, returns null if index is out
	 * of range
	 * 
	 * @param index
	 * @return
	 */
	public Playable getSong(int index) {
		if (index < 0 || index >= playableList.size()) {
			return null;
		} else {
			Playable s = playableList.get(index);
			return s;
		}
	}

	/**
	 * Sorts the class's song list by artist first, then by title if the artists
	 * are equal, then shortest first if both artist and title are equal. Uses
	 * the Comparable<Song> and compareTo in the Song class
	 */
	public void sortByArtist(){
		Collections.sort(playableList, new ComparePlayable);
	}

	/**
	 * Plays the play list by calling play() on each Song in the play list in
	 * order
	 */
	public void play() {
		for (Playable s : playableList) {
			s.play();
		}
	}

	/**
	 * Returns the number of songs in the play list
	 * 
	 * @return
	 */
	public int size() {
		return playableList.size();
	}

	/**
	 * returns the total time the play list will take in the format HH:MM:SS if
	 * there are hours, or MM:SS if there are no hours.
	 * 
	 * @return
	 */
	public String totalPlayTime() {
		DecimalFormat df = new DecimalFormat("00");
		int totalH = 0;
		int totalM = 0;
		int totalS = 0;
		for (Song s : songList) {
			totalM = totalM + s.getMinutes();
			totalS = totalS + s.getSeconds();
		}
		int extraM = totalS / 60;
		totalS = totalS % 60;
		totalM = totalM + extraM;
		int extraH = totalM / 60;
		totalM = totalM % 60;
		totalH = totalH + extraH;
		if (totalH > 0) {
			return df.format(totalH) + ":" + df.format(totalM) + ":"
					+ df.format(totalS);
		} else {
			return df.format(totalM) + ":" + df.format(totalS);
		}
	}

	/**
	 * Returns the total time the play list will take as the number of seconds
	 * 
	 * @return
	 */
	public int getPlayTimeSeconds() {
		int totalM = 0;
		int totalS = 0;
		for (Song s : songList) {
			totalM = totalM + s.getMinutes();
			totalS = totalS + s.getSeconds();
		}
		totalS = totalS + totalM * 60;
		return totalS;
	}

	// Getters / Setters for name and songList
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Song> getSongList() {
		return songList;
	}

	public void setSongList(ArrayList<Song> songList) {
		this.songList = songList;
	}
}
