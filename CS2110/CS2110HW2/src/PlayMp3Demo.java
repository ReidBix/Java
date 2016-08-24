import java.io.File;

import edu.virginia.cs2110.Mp3FilePlayer;

public class PlayMp3Demo {

    public static void main(String[] args) {
        Mp3FilePlayer mp3 = new Mp3FilePlayer("good-ole-song.mp3");
        mp3.playAndBlock(); // play whole song
        mp3.playAndBlock(10); // play just 10 seconds
        Mp3FilePlayer mp3x = new Mp3FilePlayer(
                "The_Kielbasas-The_Chicken_Dance.mp3");
        mp3x.playAndBlock(9.3); // play just enough of that one!

        // What's below is not needed for HW2, but you might enjoy them for some
        // other need
        // mp3.playInBackground(); // start some "background music"
        // mp3x.playAndBlock(10); // oops, playing two thing at once

        System.out.println("Done!");
    }

}
