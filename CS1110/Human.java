import java.awt.Rectangle;

/**
 * Human.java
 * 
 * The player's character. This class should have fields that can represent the
 * players' current location, the location to which it is trying to go, a
 * relative speed, and a number of bombs, and a Rectangle representing the
 * player's hitbox. Other fields for the size of the player and the hitbox may
 * be useful, along with frame information if you do animation. You should
 * create methods for the following: 1. checking to see if the player's hitbox
 * Rectangle is colliding with any other hitbox Rectangle (just obstacle
 * Rectangles - Zombies can handle Human collision) 2. movement (normal movement
 * and what to do if there is a collision) 3. constructors 4. getters/setters 5.
 * bomb counting 6. anything else you may need.
 * 
 * @authors
 * @compids
 * @lab
 * 
 */
public class Human {

	private double locationx;
	private double locationy;
	private int directionsprite;
	private double gox;
	private double goy;
	private double changey;
	
	private double xcoord;
	private double ycoord;
	private double angle;
	private double speed;
	
	private int bombs;
	
	private Rectangle hitbox = new Rectangle();
	
	private int direction;
	
	
	public Human(){
		locationx = 350;
		locationy = 350;
		speed = 40;
		bombs = 3;
		
		direction = 45;
		hitbox.setRect(locationx, locationy, 2, 2);
		
		
	}
	
	public boolean collisionCheckZombie(Zombie z){
		Rectangle hitboxz = z.getHitbox();
		Rectangle hitboxh = getHitbox();
		if (hitboxh.intersects(hitboxz)){
			return true;
		}
		return false;
	}
	
	public Rectangle collisionCheckObstacle(Rectangle r){
		Rectangle hitboxh = getHitbox();
		
		Rectangle intersection = hitboxh.intersection(r);
		
		return intersection;
	}
	
	public boolean bombCheck(){
		
		if (bombs>0){
			return true;
		}
		else{
			return false;
		}
	}
	public Rectangle dropBomb(){
		if (bombs>0){
			bombs -= 1;
			Rectangle boom = new Rectangle();
			boom.setRect(locationx-70, locationy-70, 140, 149);
			return boom;
		}
		else{
			Rectangle boom = new Rectangle();
			boom.setRect(locationx-15, locationy-25, 0, 0);
			return boom;
		}
	}
	
	public void move2 (float elapsedTime){
		gox = getGox();
		goy = getGoy();
		
		changey = goy + 2*(locationy - goy);
		
		double dx = gox-locationx;
		double dy = changey-locationy;
		
		angle = Math.atan2(dy, dx)*180/ Math.PI;
		
			if (angle>-22.5 && angle<22.5){
				setDirection(0);
			}
			if (angle>22.5 && angle<67.5){
				setDirection(45);
			}
			if (angle>67.5 && angle<112.5){
				setDirection(90);
			}
			if (angle>112.5 && angle<157.5){
				setDirection(135);
			}
			if ((angle>157.5 && angle<180) || (angle<-157.5 && angle>-180)){
				setDirection(180);
			}
			if (angle>-157.5 && angle<-112.5){
				setDirection(-135);
			}
			if (angle>-122.5 && angle<-67.5){
				setDirection(-90);
			}
			if (angle>-67.5 && angle<-22.5){
				setDirection(-45);
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

	
	
	
	
	public int getBombs() {
		return bombs;
	}

	public void setBombs(int bombs) {
		this.bombs = bombs;
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

	public double getXcoord() {
		return xcoord;
	}

	public void setXcoord(double xcoord) {
		this.xcoord = xcoord;
	}

	public double getYcoord() {
		return ycoord;
	}

	public void setYcoord(double ycoord) {
		this.ycoord = ycoord;
	}
	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public int getDirectionsprite() {
		return directionsprite;
	}

	public void setDirectionsprite(int directionsprite) {
		this.directionsprite = directionsprite;
	}

}
