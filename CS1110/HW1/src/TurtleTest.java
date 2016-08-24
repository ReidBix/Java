
import java.util.Scanner;

public class TurtleTest {

	public static void main(String[] args) {

		World myWorld = new World();
		Turtle myTurtle = new Turtle(myWorld, 0, 0);
	
		myTurtle.left(90);
		myTurtle.forward(100);
	}
		

}
