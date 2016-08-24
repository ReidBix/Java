/**
 * Names: Reid Bixler, Camille Hochheimer
 * Computing IDs: rmb3yz, cjh8uc
 * Lab Section: 1110-102
 * Date: November 13, 2013
 */

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ZombieSurvival {

	// The SurvivalField needs a canvas to draw on
	private SimpleCanvas canvas;
	
	// The InfoFrame that you use for output instead of System.out
	private InfoFrame output;
	
	// Default board size
	private final int BOARDHEIGHT = 700;
	private final int BOARDWIDTH = 700;
	private int end = 0;
	private int speedboost = 1;
	
	// --------------------------------------------------------
	// Fields
	// You should setup fields to keep up with:
	// - a whole bunch of Zombies
	// - a single Human
	// - a whole bunch of obstacles, represented as Rectangles
	// - some way to know if the game is over
	// - a way to keep track of the score
	// - how many zombies you should start with
	// --------------------------------------------------------
	private Human h = new Human();
	private int boomthing = 0;
	private float tick = 0;
	private float tick2 = 0;
	private int score = 0;
	private int speedclicked = 0;
	
	ArrayList<Zombie> zombieList = new ArrayList<Zombie>();
	
	ArrayList<Rectangle> obstacleList = new ArrayList<Rectangle>();
	
	
	
	
	
	
	// -----------------------------------------
	// Methods
	
	public void addObstacle(double x, double y, double w, double h){
		Rectangle r = new Rectangle();
		r.setRect(x, y, w, h);
		obstacleList.add(r);
	}
	
	
	public void addZombie(){
		zombieList.add(new Zombie(random(), random()));
	}
	
	public void speedBoost(){
		if (speedboost < 3){
			speedboost += 1;
			output.println("You found a speed boost! You have " + speedboost + " left!");
		}
		else if (speedboost >= 3){
			output.println("You have too many speed boosts! Use one by right-clicking!");
		}
	}
		
	
	
	public int random(){
		Random generator = new Random();
		int random = generator.nextInt(601);
		return random;
	}

	

	public ZombieSurvival() throws Exception {
		// Create canvas object with 500x500 spatial dimensions.
		canvas = new SimpleCanvas(BOARDWIDTH, BOARDHEIGHT, this);

		// Initialize your output frame
		output = new InfoFrame(this);
		
			
		loadObstacles(null);
		mouseAction(BOARDHEIGHT, BOARDHEIGHT, BOARDHEIGHT);
		
	}
	

	public void loadObstacles(String filename) throws Exception {
		// populate a list of obstacle Rectangles
		File f = new File("course.csv");
		Scanner fr = new Scanner(f);
		
		while (fr.hasNextLine()){
			String line = fr.nextLine();
			String[] array = line.split(",");
			Double[] darray = new Double[array.length];
			for (int i = 0; i<array.length; ++i){
				String num = array[i];
				double number = Double.parseDouble(num);
				darray[i] = number;
			}
			for (int i2 = 0; i2<darray.length; ++i2){
				double xpos = darray[0];
				double ypos = darray[1];
				double width = darray[2];
				double height = darray[3];
							
				addObstacle(xpos, ypos, width, height);
			}
		}
		fr.close();
	}


	public void mouseAction(float x, float y, int button) {
		int bombs = h.getBombs();
		bombs -= 1;
		
		if (end == 0){
			if (bombs != 1){
				if (bombs == -1){
					if (button == -1) {
						//output.println("Mouse: " + x + "," + y);
						h.setGox(x);
						h.setGoy(y);
					}
					if (button == 1) {
						output.println("You are out of bombs!");
					}
			
					if (button == 3) {
						if (speedboost > 0){
							speedboost -= 1;
							output.println("You have used a speed boost! You have " + speedboost + " left!");
							//h.setSpeed(1000);
							tick2 = 0;
	
	
							speedclicked = 1;
						}
						else if (speedboost == 0){
							output.println("You are already out of speed boosts!");
						}
					}
				}
				else if (bombs != -1){
					if (button == -1) {
						//output.println("Mouse: " + x + "," + y);
						h.setGox(x);
						h.setGoy(y);
					}
			
					if (button == 1) {
						detonateBomb();
			
						output.println("You dropped a bomb! You have " + bombs + " bombs left!");
					}
			
					if (button == 3) {
						if (speedboost > 0){
							speedboost -= 1;
							output.println("You have used a speed boost! You have " + speedboost + " left!");
							//h.setSpeed(1000);
							tick2 = 0;
	
	
							speedclicked = 1;
	
						}
						else if (speedboost == 0){
							output.println("You are already out of speed boosts!");
						}
					}
				}
			}
			else if (bombs == 1){
				if (button == -1) {
					//output.println("Mouse: " + x + "," + y);
					h.setGox(x);
					h.setGoy(y);
				}
		
				if (button == 1) {
					detonateBomb();
		
					output.println("You dropped a bomb! You have " + bombs + " bomb left!");
				}
		
				if (button == 3) {
					if (speedboost > 0){
						speedboost -= 1;
						output.println("You have used a speed boost! You have " + speedboost + " left!");
						//h.setSpeed(1000);
						tick2 = 0;
	
	
						speedclicked = 1;
					}
					else if (speedboost == 0){
						output.println("You are already out of speed boosts!");
					}
				}
			}
		}
		else{
			if (button == 1){
			output.println("You have already been eaten!");
			}
			if (button == 3){
				output.println("You have already been eaten!");
			}
		}

	}


	public void detonateBomb() {
		if (h.bombCheck()==true){			
			Rectangle boom = h.dropBomb();
			boomthing = 200;
			
			//repeat 10 times for a case of 10 zombies being within blast radius
			for (int i3 = 0; i3<10; ++i3){
				for (int i = 0; i<zombieList.size(); ++i){
					Zombie z = zombieList.get(i);
					
					Rectangle r = z.getHitbox();
					
					Rectangle inter3 = boom.intersection(r);
					
					if (r.intersects(inter3)){
						zombieList.remove(z);
					}
				}
				/*
				double width3 = inter3.getWidth();
				double height3 = inter3.getHeight();

				if (width3 > 0 && height3 > 0){
					//System.out.println(inter3);
					zombieList.remove(z);
				}
				*/
			}
		}
		
	}


	
	
	
	
	public void draw(Graphics2D g, float elapsedTime) {
		// Nearly ALL your game logic will go here!  This is called on 
		// every refresh of the screen and is the "main game loop".
		tick ++;
		tick2 ++;
		
		//System.out.println(tick);
		
		
		
		
		//System.out.println(score);
		// This is how you draw the Human, replacing the null with the human
		// object
		canvas.drawHuman(g, h, tick);
		//Rectangle r2 = h.getHitbox();
		//canvas.drawObstacle(g, r2);
		
		if (boomthing > 0){
			float time = elapsedTime + 200;
			//System.out.println(time);
			if (elapsedTime < time){
				int locationx = (int) h.getLocationx();
				int locationy = (int) h.getLocationy();
				canvas.drawBoom(g, locationx-75, locationy-73);
			}
			boomthing -= 1;
		}
		
		h.move2(elapsedTime);
	
		//Rectangle boom2 = h.dropBomb();
		//canvas.drawObstacle(g, boom2);

		// This is how you draw the Zombies, replacing the null with a zombie
		// object
		
		
		//move and draw zombie
		for (int i = 0; i<zombieList.size(); ++i){
			Zombie z = zombieList.get(i);
			canvas.drawZombie(g, z, tick);
			//canvas.drawDot(g, locationx-20, locationy-17, Color.red);
			//Rectangle r = z.getHitbox();
			//canvas.drawObstacle(g, r);
			z.move(elapsedTime, h);
		}
		
		
		// if hit loop
		if (end == 0){
			
			if (tick%100 == 0){
				score += 1;
			}
			if (tick%5000 == 0){
				Zombie z = new Zombie(random(),random());
				zombieList.add(z);
				output.println("Oh no! Another zombie!");
			}
			if (tick%25000 == 0){
				int bombs = h.getBombs();
				bombs += 1;
				h.setBombs(bombs);
				
				if (bombs != 1){
						output.println("You found a bomb! You now have " + bombs + " bombs!");
				}
				else if (bombs == 1){
					output.println("You found a bomb! You now have " + bombs + " bomb!");

				}
				
			}
			
			if (tick%50000 == 0){
				speedBoost();
			}
			
			
			if (speedclicked == 1){
				if (tick2 < 750){
					h.setSpeed(160);	
				}
				else if (tick2 > 750){
					h.setSpeed(40);
				}
			}
			
			for (int i = 0; i<zombieList.size(); ++i){
				Zombie z = zombieList.get(i);
				
				
				for (int i3 = 0; i3<zombieList.size(); ++i3){
					if (i != i3){
						Zombie z2 = zombieList.get(i3);
						
						Rectangle inter2 = z2.collisionCheckZombie(z);
						
						double width2 = inter2.getWidth();
						double height2 = inter2.getHeight();

						double locationx = z.getLocationx();
						double locationy = z.getLocationy();
						double locationx2 = z2.getLocationx();
						double locationy2 = z2.getLocationy();
						
						if (width2 > 0 && height2 > 0){
							//System.out.println(inter2);

							if (locationx < locationx2){
								z.setLocationx(locationx-1);
							}
							if (locationx > locationx2){
								z.setLocationx(locationx+1);
							}
							if (locationy < locationy2){
								z.setLocationy(locationy-1);
							}
							if (locationy > locationy2){
								z.setLocationy(locationy+1);
							}
						
						}	
					
					}
				}
			
			
				for (int i2 = 0; i2<obstacleList.size(); ++i2){
					Rectangle o = obstacleList.get(i2);
					
					Rectangle inter = z.collisionCheckObstacle(o);
					
					int direction = z.getDirection();
					
					double locationx = z.getLocationx();
					double locationy = z.getLocationy();
					
					double width = inter.getWidth();
					double height = inter.getHeight();
					
					if (width > 0 && height > 0){
						if (width > height){
							if (direction == 90 || direction == 135 || direction == 45){
								z.setLocationy(locationy+1);
							}
							if (direction == -90 || direction == -135 || direction == -45){
								z.setLocationy(locationy-1);
							}
						
						}
						if (height > width){
							if (direction == 180 || direction == 135 || direction == -135){
								z.setLocationx(locationx+1);
							}
							if (direction == 0 || direction == 45 || direction == -45){
								z.setLocationx(locationx-1);
							}
						}
					}
				}
				
				
				
				
				
				if (h.collisionCheckZombie(z)==true){
					h.setSpeed(0);
					h.setBombs(0);
					for (int i2 = 0; i2<zombieList.size(); ++i2){
						Zombie z2 = zombieList.get(i2);
						z2.setSpeed(0);
					}
					output.println("OMNOMNOMNOMNOMNOM!\nYou have been eaten!\n");					output.println("GAME OVER!");
					String s = "" + score;
					output.println("Your score is: " + s);
					end = 1;
					break;
				}
				
			}
		}
		
		// This is how your draw an obstacle, replacing the new Rectangle with
		// one from your list of obstacles
		
		for (int i = 0; i<obstacleList.size(); ++i){
			Rectangle r = obstacleList.get(i);
			canvas.drawObstacle(g, r);
		}
		
		for (int i = 0; i<obstacleList.size(); ++i){
			Rectangle o = obstacleList.get(i);
			
			Rectangle inter = h.collisionCheckObstacle(o);
			
			int direction = h.getDirection();
			
			double locationx = h.getLocationx();
			double locationy = h.getLocationy();
			
			double width = inter.getWidth();
			double height = inter.getHeight();
			
			if (width > 0 && height > 0){
				if (width > height){
					if (direction == 90 || direction == 135 || direction == 45){
						h.setLocationy(locationy+1);
					}
					if (direction == -90 || direction == -135 || direction == -45){
						h.setLocationy(locationy-1);
					}
				
				}
				if (height > width){
					if (direction == 180 || direction == 135 || direction == -135){
						h.setLocationx(locationx+1);
					}
					if (direction == 0 || direction == 45 || direction == -45){
						h.setLocationx(locationx-1);
					}
				}
			}
		}
		
		

	}
	

	public static void main(String[] args) throws Exception {
		ZombieSurvival simulator = new ZombieSurvival();
		simulator.play();
	}


	public void play() {
		int bombs = h.getBombs();
		output.println("New player created!");
		output.println("Left click for bombs, Right click for speed boosts!");
		output.println("You have " + bombs + " bombs and " + speedboost + " speedboost!\n");


		canvas.setupAndDisplay();
		for (int i = 0; i<4; ++i){
			addZombie();
		}
		//addObstacle(400,50,20,300);
	}
}
