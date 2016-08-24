import static org.junit.Assert.*;

import org.junit.Test;


public class CompareTest {

	@Test
	public void testCompareSeconds()
	{
		Song s = new Song("Shakira", "Hips Don't Lie", 6, 7, "file.txt");
		Song s2 = new Song("ACDC", "Back in Black", 3, 4, "newfile.text");
		Song s3 = new Song("Kendrick Lamar", "Hol' Up", 3, 30, "kendrick.txt");
		Song s4 = new Song("Childish Gambino", "V. 3005", 4, 67, "gambino.txt");
		Song s5 = new Song("Eminem", "So Far...", 3, 64, "sofar.txt");
		
		PlayList p = new PlayList();
		p.addSong(s);
		p.addSong(s2);
		p.addSong(s3);
		p.addSong(s4);
		p.addSong(s5);
		
		p.sortByName();
		
		assertEquals("Hol' Up", p.getPlayableList().get(2).getName());
	}
	
	@Test
	public void testLoadSongs()
	{
		Song s = new Song("ACDC", "Back in Black", 3, 4, "newfile.mp3");
		Song s2 = new Song("Shakira", "Hips Don't Lie", 3, 56, "newerfile.mp3");
		PlayList p = new PlayList();
		p.loadSongs("text.txt");
		
		assertEquals(s, p.getPlayable(0));
	}

}
