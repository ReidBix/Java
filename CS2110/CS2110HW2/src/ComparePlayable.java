import java.awt.List;
import java.util.Comparator;


public class ComparePlayable implements Comparator<Song> {

	@Override
	public int compare(Song s1, Song s2) {
		int retVal = s1.artist.compareTo(s2.artist);
		if (retVal != 0)
			return retVal;
		retVal = s1.title.compareTo(s2.title);
		if (retVal != 0)
			return retVal;
		int minutes1 = s1.minutes;
		int minutes2 = s2.minutes;
		int seconds1 = s1.seconds;
		int seconds2 = s2.seconds;
		seconds1 = seconds1 + minutes1 * 60;
		seconds2 = seconds2 + minutes2 * 60;
		if (seconds1 < seconds2)
			return -1;
		if (seconds1 > seconds2)
			return 1;
		else
			return 0;
	}
	
	public void sort(List theList, Comparator cmpObj){
		for (Object o : theList){
			
		}
	}
	
}
