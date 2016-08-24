import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Joe Urbanek jcu5df, Reid Pixler rmb3yz
 */
public class Mp3Player
{
	private PlayList p = new PlayList("playlist");
	private ArrayList<PlayList> lists = new ArrayList<PlayList>();

	/**
	 * Constructor for Mp3Player
	 */
	public Mp3Player()
	{
		lists.add(p);
	}
	/**
	 * 
	 * @param args
	 * Starts the Mp3Player
	 */
	public static void main(String[] args)
	{
		Mp3Player m = new Mp3Player();
		m.start();
	}

	/**
	 * UI for the Mp3Player
	 */
	public void start()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter FileName: ");
		String fileName = scan.next();
		p.loadSongs(fileName);
		System.out.println(p);
		p.play(5);
		scan.close();
	}

	public PlayList getDefaultPlayList()
	{
		return this.p;
	}

	public ArrayList<PlayList> getPlayLists()
	{
		return lists;	
	}
}
