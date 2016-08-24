import java.util.ArrayList; // Need to import this to use ArrayList
							// Place at the top of the file, above public class Polygon


public class Polygon {

	// ArrayList<Point> vertices; -- insufficient ArrayList declaration
	// It's your responsibility to guarantee that every field has been initialized.
	// (In constructor, OR where it is declared)
	
	// In Java 7 it allows you to only put < >'s (called the "Diamond" operator)
	// Such as:  ArrayList<Point> vertices = new ArrayList<>();
	// However Web-CAT doesn't recognize the new Java version. Therefore you must
	// put Point (the type) in the diamond operator.
	ArrayList<Point> vertices = new ArrayList<Point>(); 
	
	public Polygon() {  // Polygon constructor
		
	}
	
	private void addVertex(Point p) {
		vertices.add(p);  // appends the specified element to the end of the list
		
	}
	
	@Override
	public String toString() {
		return vertices.toString();
	}

	public static void main(String[] args) {
		Point p1 = new Point(0,0);
		Point p2 = new Point(0,2);
		Point p3 = new Point(2,2);
		Point p4 = new Point(2,0);
		
		Polygon poly = new Polygon();  //Create a new Polygon called poly
		
		// Want to add vertices to the Polygon poly
		// Adding four vertices 
		poly.addVertex(p1);
		poly.addVertex(p2);
		poly.addVertex(p3);
		poly.addVertex(p4);
		
		System.out.println(poly); 
		
		System.out.println(poly.getPerimeter());
		boolean result = poly.hasVertex(p3);
		System.out.println("Is " + p3 + " a vertex? "+ result);
		
		Point p5 = new Point(2,2);
		result = poly.hasVertex(p5);
		System.out.println("Is " + p5 + " a vertex? "+ result);
		
		System.out.println("contains() says: " + poly.vertices.contains(p5));
		
	}

	private boolean hasVertex(Point p) {
		for(Point v : vertices) {
			if (v.equals(p))
				return true;
		}
		return false;
	}

	private double getPerimeter() {
		double sum = 0.0;
		for (int i=0; i<vertices.size()-1; i++) {
			sum = sum + vertices.get(i).distance(vertices.get(i+1));
		}
		sum = sum + vertices.get(vertices.size()-1).distance(vertices.get(0));
		return sum;
	}



}
