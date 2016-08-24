
public class Circle {

	private Point center;
	private double radius;
	
	public Circle(Point c, double rad) {  // Circle constructor 
		this.center = c;
		this.radius = rad;
	}

	@Override
	public String toString() {
		return "<" + center + "," + radius + ">";		
	}	
	
	public static void main(String[] args) {
//		Point p1 = new Point(1.3, 5.2);
//		Circle c1 = new Circle(p1, 1.5);
//		System.out.println(c1.center.getX());
		
		// Testing encloses
		Point p1 = new Point(0,0);
		Circle c1 = new Circle(p1, 1);
		
		Point p2 = new Point(1.0001,0);
		boolean result = c1.encloses(p2);
		System.out.println(result);
		
	}

	private boolean encloses(Point p2) {
		double dist = p2.distance(center);
		return (dist <= radius);
		}

}
