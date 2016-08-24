import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Joe Urbanek jcu5df, Reid Bixler rmb3yz
 * 
 */
public class PlayListTest {
	Song song1;
	Song song2;
	Song song3;
	Video video1;
	Video video2;
	Video video3;
	PlayList p1;
	PlayList p2;
	PlayList p3;
	PlayList p4;
	PlayList p5;
	PlayList p6;
	MediaPlayer m;
	File f1;
	File f2;
	File f3;
	File f4;
	File f5;
	File f6;
	
	/**
	 * Before setup for tests
	 */
	@Before
	public void setup() {
		song1 = new Song("Nirvana", "Smells Like Teen Spirit", 4, 59,
				"smellslike.mp3");
		song2 = new Song("Jet", "Are You Gonna Be My Girl", 3, 33,
				"areyougonna.mp3");
		song3 = new Song("Led Zeppelin", "Stairway To Heaven", 8, 49,
				"stairway.mp3");
		video1 = new Video("Mark Boyle",
				"Weatherman Duped Into Giving 'Hugh Janus' Bday Shoutout", 1,
				29, "http://www.youtube.com/embed/Cm-lA3GkKBc");
		video2 = new Video("Rob Chapman",
				"Amazing busker \"Nelly Niel\" get's a surprise!", 3, 42,
				"http://www.youtube.com/embed/5PnIu1hd4q0");
		video3 = new Video("Arnold Schwarzenegger", "We Have A Winner",
				1, 01, "http://www.youtube.com/embed/U8x9iDsoIvQ");
		p1 = new PlayList();
		p2 = new PlayList();
		p3 = new PlayList();
		p4 = new PlayList();
		p5 = new PlayList();
		p6 = new PlayList();
		m = new MediaPlayer();
		f1 = new File("simple.txt");
	}
	
	/**
	 * First Test: Checks if an empty playlist is equal to itself
	 * Second Test: Checks if a playlist with an empty playlist inside is equal to another
	 */
	@Test
	public void testAddPlayList1() {
		p2.addPlayList(p1);
		p3.addPlayList(p1);
		assertEquals(true, p1.equals(p1));
		assertEquals(true, p2.equals(p3));
	}
	
	/**
	 * First Test: Checks if the first Playable (p1 in this instance) is the first Playable in p2
	 * Second Test: Checks for the instance of going past the total number of Playables in the PlayList
	 */
	@Test
	public void testAddPlayList2() {
		p1.addPlayable(song1);
		p1.addPlayable(video1);
		p2.addPlayList(p1);
		assertEquals(true, p2.getPlayable(0).equals(p1));
		assertEquals(null, p2.getPlayable(1));
	}

	/**
	 * First Test: Checks for nested Playlists
	 * Second Test: Checks for Playables within nested Playlists
	 */
	@Test
	public void testAddPlayList3() {
		p2.addPlayable(song2);
		p2.addPlayable(video2);
		p1.addPlayList(p2);
		p3.addPlayList(p1);
		p4.addPlayList(p2);
		p6.addPlayList(p4);
		assertEquals(true, p3.equals(p6));
		assertEquals(true, p3.getPlayable(0).equals(p6.getPlayable(0)));
	}
	
	/**
	 * First Test: Checks for attempting to put duplicates of Playables in a PlayList
	 * Second Test: Checks for attempting to put duplicates of PlayLists in a PlayList
	 */
	@Test
	public void testAddPlayList4() {
		p1.addPlayable(song1);
		p1.addPlayable(song1);
		assertEquals(null, p1.getPlayable(1));
		p2.addPlayList(p1);
		p2.addPlayList(p1);
		assertEquals(null, p2.getPlayable(1));
	}
	
	/**
	 * First Test: Checks for comparisons between Songs and Videos
	 * Second Test: Checks for comparisons between same song
	 * Third Test: Checks for comparisons between same video
	 */
	@Test
	public void testAddPlayable1() {
		p1.addPlayable(song1);
		p1.addPlayable(song2);
		p1.addPlayable(song3);
		p2.addPlayable(video1);
		p2.addPlayable(video2);
		p2.addPlayable(video3);
		assertEquals(false, p1.getPlayable(0).equals(p2.getPlayable(0)));
		assertEquals(true, p1.getPlayable(0).equals(song1));
		assertEquals(true, p2.getPlayable(0).equals(video1));
	}
	
	/**
	 * First Test: Checks for adding duplicate and checking size
	 * Second Test: Checks for adding multiple types of Playable and checking size
	 * Third Test: Checks the size of an empty playlist
	 */
	@Test
	public void testAddPlayable2() {
		p1.addPlayable(song1);
		p1.addPlayable(song2);
		p1.addPlayable(song3);
		p1.addPlayable(song1);
		p1.addPlayable(song2);
		p1.addPlayable(song3);
		assertEquals(3, p1.size());
		p1.addPlayable(video1);
		assertEquals(4, p1.size());
		assertEquals(0, p2.size());
	}
	
	/**
	 * First Test: Checks for adding playlists as type Playable
	 * Second Test: Checks for adding all possible types of Playable in one PlayList
	 * Third Test: Also checking for adding all possible types of Playable
	 */
	@Test
	public void testAddPlayable3() {
		p1.addPlayable(p2);
		assertEquals(true, p1.getPlayable(0).equals(p2));
		p1.addPlayable(song1);
		p1.addPlayable(video2);
		assertEquals(true, p1.getPlayable(1).equals(song1));
		assertEquals(true, p1.getPlayable(2).equals(video2));
	}
	
	/**
	 * First Test: Checks for nesting all types of Playables
	 * Second Test: Checks for nesting all types of Playables
	 * Third Test: Checks for nesting all types of Playables
	 */
	@Test
	public void testAddPlayable4() {
		p1.addPlayable(song1);
		p1.addPlayable(video1);
		p2.addPlayable(p1);
		p3.addPlayable(p2);
		p4.addPlayable(p3);
		assertEquals(true, p4.getPlayable(0).equals(p3));
		assertEquals(true, p3.getPlayable(0).equals(p2));
		assertEquals(true, p2.getPlayable(0).equals(p1));
	}
	
	/**
	 * First Test: Checks for a file that contains a single song with no errors and checks Title 
	 * Second Test: Checks for Artist from previous file
	 * Third Test: Checks for TotalPlaytime
	 */
	@Test
	public void testLoadMedia1() {
		p1.loadMedia("simple.txt");
		System.out.println(p1);
		Song s = (Song) p1.getPlayable(0);
		String title = s.getTitle();
		String artist = s.getArtist();
		int time = s.getPlayTimeSeconds();
		assertEquals("a1a a1b", title);
		assertEquals("t1a t1b", artist);
		assertEquals(61, time);
	}
	
	/**
	 * First Test: Checks for a file that contains two songs with no errors and checks Title 
	 * Second Test: Checks for Artist from previous file
	 * Third Test: Checks for TotalPlaytime
	 */
	@Test
	public void testLoadMedia2() {
		p1.loadMedia("simple2.txt");
		System.out.println(p1);
		Song s = (Song) p1.getPlayable(1);
		String title = s.getTitle();
		String artist = s.getArtist();
		int time = s.getPlayTimeSeconds();
		assertEquals("a2a a2b a2c", title);
		assertEquals("t2a t2b t2c", artist);
		assertEquals(122, time);
	}
	
	/**
	 * First Test: Checks for a file that contains one song and two videos with no errors and checks User
	 * Second Test: Checks for Title from previous file
	 * Third Test: Checks for TotalPlaytime
	 * Fourth Test: Checks for the youtube Link
	 */
	@Test
	public void testLoadMedia3() {
		p1.loadMedia("videos.txt");
		System.out.println(p1);
		Video v = (Video) p1.getPlayable(2);
		String user = v.getUser();
		String title = v.getTitle();
		int time = v.getPlayTimeSeconds();
		String videoName = v.getVideoName();
		assertEquals("a3a a3b", user);
		assertEquals("t3a t3b", title);
		assertEquals(15, time);
		assertEquals("http://www.youtube.com/embed/c0FSDdCXzjw", videoName);
	}
	

	/**
	 * First Test: Checks for a file that contains one song and one video with no errors and checks User
	 * Second Test: Checks for Title from previous file
	 * Third Test: Checks for TotalPlaytime
	 * Fourth Test: Checks for the youtube Link
	 */
	@Test
	public void testLoadMedia4() {
		p1.loadMedia("videos2.txt");
		System.out.println(p1);
		Video v = (Video) p1.getPlayable(1);
		String user = v.getUser();
		String title = v.getTitle();
		int time = v.getPlayTimeSeconds();
		String videoName = v.getVideoName();
		assertEquals("a2a a2b a2c", user);
		assertEquals("t2a t2b t2c", title);
		assertEquals(122, time);
		assertEquals("http://www.youtube.com/embed/IRj6L2VOWWg", videoName);
	}
	
	
	/**
	 * First Test: Checks for a file that contains one song with errors and checks Artist 
	 * Second Test: Checks for Title from previous file
	 * Third Test: Checks for TotalPlaytime
	 */
	@Test
	public void testLoadMedia5() {
		p1.loadMedia("spaces.txt");
		System.out.println(p1);
		Song s = (Song) p1.getPlayable(0);
		String title = s.getTitle();
		String artist = s.getArtist();
		int time = s.getPlayTimeSeconds();
		assertEquals("t1a t1b", artist);
		assertEquals("a1a a1b", title);
		assertEquals(61, time);
	}
	
	/**
	 * First Test: Checks for a file that contains one song and one video with no errors and checks User
	 * Second Test: Checks for Title from previous file
	 * Third Test: Checks for TotalPlaytime
	 * Fourth Test: Checks for the youtube Link
	 */
	@Test
	public void testLoadMedia6() {
		p1.loadMedia("messy.txt");
		System.out.println(p1);
		Video v = (Video) p1.getPlayable(1);
		String user = v.getUser();
		String title = v.getTitle();
		int time = v.getPlayTimeSeconds();
		String videoName = v.getVideoName();
		assertEquals("a2a a2b a2c", user);
		assertEquals("t2a t2b t2c", title);
		assertEquals(122, time);
		assertEquals("http://www.youtube.com/embed/IRj6L2VOWWg", videoName);
	}
	
	@After
	public void tearDown() {

	}
}
