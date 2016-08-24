
public class Point {

	private double x;
	private double y;

	public Point(double x, double y) {  // Point constructor 
		this.x = x;
		this.y = y;
		
		x = x; //bad!
		x = this.x; // no good!
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}	
	
	public boolean equals(Point p2) {
		System.out.println("Hello from equals - wish you were here! ");
		return (this.x == p2.x) && (this.y == p2.y);
	}
	
	public static void main(String[] args) {
//		Point p1 = new Point(1.3, 5.2);
//		System.out.println("Point p1 is: " + p1); //sysout then CTRL+ space bar
		
		//Testing distance
		Point p1 = new Point(0,0);
		Point p2 = new Point(0,1);
		System.out.println(p1.distance(p2));
		
		System.out.println("Are these two points equal? " + p1.equals(p2));
		

	}

	public double distance(Point p2) {  //Calculate the distance between points
		return Math.sqrt( (this.x-p2.x) * (this.x-p2.x) + (this.y-p2.y)*(this.y-p2.y) );
	}
	
}
