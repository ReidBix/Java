import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Joseph Urbanek jcu5df, Reid Bixler rmb3yz
 * Homework 1
 * Lab Section 103
 */
public class PlayList implements Playable
{

	private String name;
	private ArrayList<Playable> playableList = new ArrayList<Playable>();

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public ArrayList<Playable> getPlayableList()
	{
		return playableList;
	}
	public void setPlayableList(ArrayList<Playable> playableList)
	{
		this.playableList = playableList;
	}
	/**
	 * Returns the list of Songs, based on the Song toString()
	 */
	public String toString()
	{
		return this.name + ": " + this.playableList;
	}

	/**
	 * Empty Constructor for Playlist. Assigns "Untitled" to Playlist title.
	 */
	public PlayList()
	{
		this.name = "Untitled";
	}

	/**
	 * Constructor for PlayList.  Assigns s to the playlist title
	 * @param s
	 */
	public PlayList(String s)
	{
		this.name = s;
	}

	/**
	 * 
	 * @return True if the playableList has songs to clear
	 * Also clears the playableList
	 */
	public boolean clear()
	{
		if (this.playableList.size() != 0)
		{
			this.playableList.clear();
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param s
	 * @return True if the song was added at the end of the playlist.
	 * Adds the song to the end of the playlist
	 */
	public boolean addSong(Song s)
	{
		playableList.add(s);
		return (playableList.get(playableList.size() - 1).equals(s));

	}

	//	/**
	//	 * 
	//	 * @param index
	//	 * @return The song removed at index
	//	 * Removes song from the playableList
	//	 */
	//	public Song removeSong(int index)
	//	{
	//		if (index < 0 || index >= playableList.size())
	//			return null;
	//		Song s = playableList.get(index);
	//		playableList.remove(index);
	//		return s;
	//	}
	//	
	//	/**
	//	 * 
	//	 * @param s
	//	 * @return Song s
	//	 * Removes all instances where a song appears in the playableList
	//	 */
	//	public Song removeSong(Song s)
	//	{
	//		for (int i = 0; i < playableList.size(); i++)
	//			if (playableList.get(i).equals(s))
	//				playableList.remove(s);
	//		return s;
	//	}
	//	
	/**
	 * 
	 * @param index
	 * @return The song that is at index.
	 */
	public Playable getPlayable(int index)
	{
		if (index < 0 || index >= playableList.size())
			return null;
		return playableList.get(index);
	}

	/**
	 * Sorts the list of songs alphabetical order starting with the time.
	 * Implements compareTo() method of Song
	 */

	public void sortByTime()
	{
		Collections.sort(playableList, new CompareSeconds());
	}

	/**
	 * sorts the list of playables by name of the playable.
	 */
	public void sortByName()
	{
		Collections.sort(playableList, new CompareName());
	}

	/**
	 * 
	 * @return the amount of songs in the playlist.
	 */
	public int size()
	{
		return playableList.size();
	}

	/**
	 * 
	 * @param pl
	 * @return false if the playableList contains the playlist
	 * adds playList to the playableList
	 */
	public boolean addPlayList(PlayList pl)
	{
		if (playableList.contains(pl))
			return false;
		playableList.add(pl);
		return true;
	}
	/**
	 * 
	 * @return the total amount of time in MM:SS or HH:MM:SS form of the playlist.
	 */
	public String totalPlayTime()
	{
		int min = 0;
		int sec = 0;
		for (int i = 0; i < playableList.size(); i++)
		{
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
	public int getPlayTimeSeconds()
	{
		int time = 0;
		for (int i = 0; i < playableList.size(); i++)
		{
			if (playableList.get(i) instanceof PlayList)
				for (int j = 0; j < ((PlayList) playableList.get(i)).size(); j++)
					time += (((PlayList) (playableList.get(i))).getPlayable(j)).getPlayTimeSeconds();
			if (playableList.get(i) instanceof Song)
				time += playableList.get(i).getPlayTimeSeconds();
		}
		return time;
	}

	/**
	 * 
	 * @param fileName
	 * @return True if a song was added
	 * Adds song from file
	 */
	public boolean loadSongs(String fileName)
	{
		try
		{
			Scanner scan = new Scanner(new File(fileName));
			String mp3Name = "";
			while (scan.hasNext())
			{
				String title = scan.nextLine().trim();
				String artist = scan.nextLine().trim();
				String time = scan.nextLine().trim();
				String[] times = time.split(":");
				int minutes = Integer.parseInt(times[0]);
				int seconds = Integer.parseInt(times[1]);
				mp3Name = scan.nextLine().trim();
				if (!new File(mp3Name).exists())
					return false;
				Song s = new Song(artist, title, minutes, seconds, mp3Name);
				playableList.add(s);
				scan.nextLine();
			}
			scan.close();
			return true;
		}	
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 
	 * @param p
	 * @return true if all elements in the playList are equal
	 */
	@Override
	public boolean equals(Object p)
	{
		if (p instanceof PlayList)
		{
			for (int i = 0; i < playableList.size(); i++)
				if (!playableList.get(i).equals(((PlayList) p).getPlayableList().get(i)))
					return false;
			return this.name.equals(((PlayList) p).getName());
		}
		return false;
	}
	
	@Override
	public void play()
	{
		for (int i = 0; i < playableList.size(); i++)
		{
			if (playableList.get(i) instanceof Song)
				playableList.get(i).play();
			if (playableList.get(i) instanceof PlayList)
				for (int j = 0; j < ((PlayList) playableList.get(i)).size(); j++)
					((PlayList) playableList.get(i)).getPlayable(j).play();
		}
		
	}
	@Override
	public void play(double seconds)
	{
		for (int i = 0; i < playableList.size(); i++)
		{
			if (playableList.get(i) instanceof Song)
				playableList.get(i).play(seconds);
			if (playableList.get(i) instanceof PlayList)
				for (int j = 0; j < ((PlayList) playableList.get(i)).size(); j++)
					((PlayList) playableList.get(i)).getPlayable(j).play(seconds);
		}
	}
	
	public boolean addPlayable(Playable p){
		try
		{
			@SuppressWarnings("resource")
			Scanner scan = new Scanner((Readable) p);
			String mp3Name = "";
			int check = 0;
			int linenum = 0;
			String line1 = "";
			String line2 = "";
			String line3 = "";
			String line4 = "";
			int minutes = 0;
			int seconds = 0;
			int video = 0;
			while (scan.hasNext())
			{	
				check = 0;
				String line = scan.nextLine().trim();
				linenum++; // = 1  = 2   =3   =4
				String comment = "//";
				if (line.contains(comment)){
					int linestart = 0;
					int lineend = 0;
					int linecheck = line.indexOf(comment);
					lineend = linecheck - 1;
					line = line.substring(linestart, lineend);
				}
				if (line.length() == 0){
					check = 1;
					linenum--;
				}
				if (check == 0){
					if (linenum == 1){
						line1 = line;
					}
					if (linenum == 2){
						line2 = line;
					}
					if (linenum == 3){
						line3 = line;
						String[] times = line3.split(":");
						minutes = Integer.parseInt(times[0]);
						seconds = Integer.parseInt(times[1]);
					}
					if (linenum == 4){
						String youtube = "youtube";
						String ycheck = line.substring(0,6);
						ycheck = ycheck.toLowerCase();
						if (youtube.equals(ycheck)){
							video = 1;
							line4 = line.substring(8);
						}
						else{
							video = 0;
							line4 = line;
						}
					}
				}
				linenum = linenum%4;// = 1  =2  =3  =0
				mp3Name = scan.nextLine().trim();
				if (!new File(mp3Name).exists())
					return false;
				if (video == 0){
					Song s = new Song(line1, line2, minutes, seconds, line4);
					playableList.add(s);
				}
				if (video == 1){
					Video v = new Video(line1, line2, minutes, seconds, line4);
					playableList.add((Playable) v);
				}
				video = 0;
				scan.nextLine();
			}
			scan.close();
			return true;
		}	
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

}
