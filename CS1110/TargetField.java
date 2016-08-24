import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

/**
 * TargetField.java
 * 
 * The TargetField is the field of play for the game. It passes messages between
 * the mouse and the Targets. This is the class that will have the main method
 * to start the game.
 * 
 * @authors
 * @compid
 * @lab
 */
public class TargetField {

	// The TargetField needs a canvas to draw on. The canvas is the window that
	// we'll use as the field.
	private SimpleCanvas canvas;

	// The InfoFrame that you use for output instead of System.out. It makes it
	// as a popup to the side.
	private InfoFrame output;

	private int ticks = 0;
	private boolean finalScorePrinted = false;
	private Random rand = new Random();

	private int score;
	// --------------------------------------------------------------------------
	// Methods - Declare your methods down here! Also, fill in the ones we tell
	// you to!
	
	private ArrayList<Target> targetList = new ArrayList<Target>();
	
	private int numtargets = 4;
	
	public void addTarget(){
			targetList.add(new Target(rand.nextInt(345),rand.nextInt(450),4));
	}

	/**
	 * The Constructor - This method should instantiate a new canvas and place the first targets.
	 */
	public TargetField() {

		// Create canvas object with 500x500 spatial dimensions.
		canvas = new SimpleCanvas(500, 500, this);

		// Initialize your output frame
		output = new InfoFrame();
		output.println("Target Clicker v0.1!");

		// ACTIVITY 6 - Add the appropriate number of targets to start the game
		for (int i = 0; i<numtargets; ++i){
			addTarget();
		}
		
	}

	/**
	 * This method should control all of your mouse actions. The mouse activity
	 * is picked up by the SimpleCanvas and then it should call this method,
	 * passing either the button that was pressed or some other flag.
	 */
	public void mouseAction(float x, float y, int button) {

		if (button == 1) {
			// Update this code to check to see if the mouse click is within hit distance of every Target you have!!!
			output.println("(" + x + "," + y + ")");
			for (int i = 0; i<targetList.size(); ++i){
				Target t = targetList.get(i);
				boolean b = t.hitTarget(x, y, t);
				if (b == true){
					targetList.remove(i);
					score += 1;
					output.println("HIT!");
					output.println("Score = " + score);
					break;
				}
			}
		}

		if (button == 3) {
			//output.println("You clicked the right mouse button!");
		}

	}


	/**
	 * This is the main drawing function that is automatically called whenever
	 * the canvas is ready to be redrawn. The 'elapsedTime' argument is the
	 * time, in seconds, since the last time this function was called.
	 * 
	 * Other things this method should do: - draw the targets on
	 * the screen - check to see if the
	 * game is over - halt the game if the game is over - update
	 * the number of ticks by 1 - add a new target every 5000 ticks
	 */
	public void draw(Graphics2D g, float elapsedTime) {

		ticks++;

		if (ticks % 5000 == 0) {
			// ACTIVITY 7 - add a new target every 5000 ticks!!!
			addTarget();
		}

		// ACTIVITY 7 - Update this code to make a loop that draws all the Targets in your field!!!!
		for (int i = 0; i<targetList.size();++i){
			Target t = targetList.get(i);
			int x = t.getX();
			int y = t.getY();
			canvas.drawDot(g, x, y, Color.red, 4);
			}

	}

	/**
	 * This method prints the final score / time to the output window by
	 * calculating the current end time and then figuring out the difference in
	 * seconds from the start time.
	 */
	public void printFinalScore() {
		if (!finalScorePrinted) {
			output.println("Game Over!");
			
			// Print out how much time has elapsed
			
			
			finalScorePrinted = true;
		}
	}

	/**
	 * Your standard main method. Nothing for you to change here.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		TargetField simulator = new TargetField();
		simulator.play();
	}

	/**
	 * This method starts the game. Nothing for you to change here.
	 */
	public void play() {
		canvas.setupAndDisplay();
	}
}
