
public class Target {
	
	private int x;
	private int y;
	private int r;
	
	private boolean hit; 
	
	public Target(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	
	public boolean hitTarget(float xx, float yy, Target t){
		x = t.getX();
		y = t.getY();
		r = t.getR();
		
		double d = Math.sqrt(Math.pow((xx-x), 2)+Math.pow((yy-y), 2));
		if (d<36){
			hit = true;
		}
		else if (d>=36){
			hit = false;
		}
		
		return hit;
	}
	
	
	public String toString() {
		return "Target [x=" + x + ", y=" + y + ", r=" + r + "]";
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}


	public boolean isHit() {
		return hit;
	}


	public void setHit(boolean hit) {
		this.hit = hit;
	}
	
	
}
