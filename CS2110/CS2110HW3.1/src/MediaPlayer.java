import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author Joe Urbanek jcu5df, Reid Bixler rmb3yz
 * 
 */

public class MediaPlayer {
	private PlayList p = new PlayList("playlist");
	private ArrayList<PlayList> lists = new ArrayList<PlayList>();

	/**
	 * Constructor for Mp3Player
	 */
	public MediaPlayer() {
		lists.add(p);
	}

	/**
	 * 
	 * @param args
	 *            Starts the Mp3Player
	 */
	public static void main(String[] args) {
		MediaPlayer m = new MediaPlayer();
		m.start();
	}

	/**
	 * UI for the Mp3Player
	 */
	public void start() {
		Scanner scan = new Scanner(System.in);

		Map<String, PlayList> m = new HashMap<String, PlayList>();
		for (int i = 0; i < lists.size(); i++)
			m.put(lists.get(i).getName(), lists.get(i));
		boolean end = false;
		System.out
				.println("Commands:\n"
						+ "1.) Create a new playlist\n"
						+ "2.) Load song- or video-information into an existing playlist from a data file\n"
						+ "3.) Add Songs With mp3 Name and Playlist Name\n"
						+ "4.) Add a playlist to the end of a given playlist\n"
						+ "5.) Play all songs, videos, or playlists stored in playlist\n"
						+ "6.) Print the contents of a named playlist\n"
						+ "7.) Play a given MP3 file with a filename\n"
						+ "8.) Print just the titles or names of all songs, videos, or playlists stored in the default playlist\n"
						+ "9.) Print the names of all playlists stored by the application\n"
						+ "10.) Quit the application");
		while (!end) {
			System.out.println("Choose a Command\t");
			int selection = scan.nextInt();
			switch (selection) {
				case 1:
					Scanner scan1 = new Scanner(System.in);
					System.out.print("Name the PlayList:\t");
					String name = scan1.next();
					PlayList play = new PlayList(name);
					lists.add(play);
					m.put(name, play);
					break;
	
				case 2:
					Scanner scan2 = new Scanner(System.in);
					System.out.print("FileName:\t");
					String fname = scan2.next();
					System.out.print("PlayList Name:\t");
					String pname = scan2.next();
					play = m.get(pname);
					play.loadMedia(fname);
					m.put(pname, play);
					break;
	
				case 3:
					Scanner scan3 = new Scanner(System.in);
					System.out.print("mp3 Name:\t");
					String mp3name = scan3.next();
					System.out.print("PlayList Name:\t");
					pname = scan3.next();
					play = m.get(pname);
					play.addSong(new Song(mp3name));
					m.put(pname, play);
					break;
	
				case 4:
					Scanner scan4 = new Scanner(System.in);
					System.out.print("PlayList 1 Name:\t");
					String name1 = scan4.next();
					System.out.print("\nPlayList 2 Name:\t");
					String name2 = scan4.next();
					if (name1 == name2)
						break;
					PlayList p1 = m.get(name1);
					p1.addPlayList(m.get(name2));
					break;
	
				case 5:
					Scanner scan5 = new Scanner(System.in);
					System.out.print("PlayList Name:\t");
					name = scan5.next();
					System.out.print("Play for Certain Time?(Y/N)\t");
					boolean time = scan.next().equals("Y");
					if (time) {
						System.out.print("Enter Number of Seconds:\t");
						double seconds = scan.nextDouble();
						m.get(name).play(seconds);
					} else
						m.get(name).play();
					break;
	
				case 6:
					Scanner scan6 = new Scanner(System.in);
					System.out.print("PlayList Name:\t");
					name = scan6.next();
					System.out.println(m.get(name));
					break;
	
				case 7:
					Scanner scan7 = new Scanner(System.in);
					System.out.print("File Name:\t");
					fname = scan7.next();
					this.p.loadMedia(fname);
					p.getPlayable(p.size()).play();
					break;
					
				case 8:
					System.out.print(p);
					break;
					
				case 9:
					System.out.println(m.keySet());
					break;
					
				case 10:
					end = true;
					break;
			}
		}
		scan.close();
	}

	public PlayList getDefaultPlayList() {
		return this.p;
	}

	public ArrayList<PlayList> getPlayLists() {
		return lists;
	}
}
