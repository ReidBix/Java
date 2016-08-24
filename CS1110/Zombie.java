import java.awt.Rectangle;
import java.util.Random;

/**
 * Zombie.java
 * 
 * The class representing the Zombie object in the game. This class needs to
 * have some representation of current location, a reference to its target (aka
 * the Human), a speed, and a Rectangle representing its hitbox. It might also
 * help to have variables representing the size of both the Zombie and its
 * hitbox. You should create methods for the following: 1. checking to see if
 * this Zombie's hitbox Rectangle is colliding with any other hitbox Rectangle
 * (either the Human or an obstacle Rectangle) 2. movement (normal movement and
 * what to do if there is a collision) 3. constructors 4. getters/setters 5.
 * anything else you may need.
 * 
 * @authors
 * @compids
 * @lab
 */
public class Zombie {
	private double locationx;
	private double locationy;
	
	private double gox;
	private double goy;
	
	private int direction;
	
	private double speed;
	
	private Rectangle hitbox = new Rectangle();
	
	
	
	public Zombie(){
		locationx = 10;
		locationy = 10;
		speed = 20;
		gox = locationx;
		goy = locationy;
		hitbox.setRect(locationx, locationy, 2, 2);
	}
	
	
	public Zombie(double ranx, double rany){
		this.locationx = ranx;
		this.locationy = rany;
		speed = 20;
		gox = locationx;
		goy = locationy;
		hitbox.setRect(locationx, locationy, 2, 2);
	}
	
	public Zombie(double ranx, double rany, Human h){
		gox = h.getLocationx();
		goy = h.getLocationy();
		this.locationx = ranx;
		this.locationy = rany;
		speed = 20;
		hitbox.setRect(locationx, locationy, 2, 2);
	}
	
	public Rectangle collisionCheckObstacle(Rectangle r){
		Rectangle hitboxz = getHitbox();
		
		Rectangle intersection = hitboxz.intersection(r);
		
		return intersection;
	}
	
	public Rectangle collisionCheckZombie(Zombie z){
		Rectangle hitboxz = getHitbox();
		Rectangle hitboxz2 = z.getHitbox();
		
		Rectangle intersection = hitboxz.intersection(hitboxz2);
		
		return intersection;
	}
	public void move (float elapsedTime, Human h){
		gox = h.getLocationx();
		goy = h.getLocationy();
		
		gox -= 10;
		goy -= 20; 
		
		if (locationx<gox && locationy<goy){
			setDirection(-45);
		}
		else if(locationx<gox && locationy>goy){
			setDirection(45);
		}
		else if (locationx>gox && locationy<goy){
			setDirection(-135);
		}
		else if(locationx>gox && locationy>goy){
			setDirection(135);
		}
		else if (locationx==gox && locationy<goy){
			setDirection(-90);
		}
		else if(locationx==gox && locationy>goy){
			setDirection(90);
		}
		else if (locationx<gox && locationy==goy){
			setDirection(0);
		}
		else if(locationx>gox && locationy==goy){
			setDirection(180);
		}
		
		
		switch (direction){
		case 0:
			//move right
			locationx = locationx + speed*elapsedTime;
			locationy = locationy + 0;
			break;
		case 45:
			//move up-right
			locationx = locationx + (speed*elapsedTime)/2;
			locationy = locationy - (speed*elapsedTime)/2;
			break;
		case 90:
			//move up
			locationx = locationx + 0;
			locationy = locationy - speed*elapsedTime;
			break;
		case 135:
			//move up-left
			locationx = locationx - (speed*elapsedTime)/2;
			locationy = locationy - (speed*elapsedTime)/2;
			break;
		case 180:
			//move left
			locationx = locationx - speed*elapsedTime;
			locationy = locationy + 0;
			break;
		case -135:
			//move down-left
			locationx = locationx - (speed*elapsedTime)/2;
			locationy = locationy + (speed*elapsedTime)/2;
			break;
		case -90:
			//move down
			locationx = locationx + 0;
			locationy = locationy + speed*elapsedTime;
			break;
		case -45:
			//move down-right
			locationx = locationx + (speed*elapsedTime)/2;
			locationy = locationy + (speed*elapsedTime)/2;
			break;
		default:
			break;
		}
	}
	
	public double getLocationx() {
		return locationx;
	}

	public void setLocationx(double locationx) {
		this.locationx = locationx;
	}
	
	

	public double getLocationy() {
		return locationy;
	}

	public void setLocationy(double locationy) {
		this.locationy = locationy;
	}

	
	
	public double getGox() {
		return gox;
	}

	public void setGox(double gox) {
		this.gox = gox;
	}

	public double getGoy() {
		return goy;
	}

	public void setGoy(double goy) {
		this.goy = goy;
	}

	
	
	
	
	
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	
	
	
	public Rectangle getHitbox() {
		return hitbox;
	}

	public void setHitbox(Rectangle hitbox) {
		this.hitbox = hitbox;
	}


	public int getDirection() {
		return direction;
	}


	public void setDirection(int direction) {
		this.direction = direction;
	}
	

}
