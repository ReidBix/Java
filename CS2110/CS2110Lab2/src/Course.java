import java.util.ArrayList;
/**
* Name: Reid Bixler, Brooke Kanarek
* Computing ID: rmb3yz, blk4fa
* Lab Section: 2110-103
* Date: January 27, 2014
*/

public class Course {

	private String id;
	private String name;
	private ArrayList<Student> roll;
	
	
	
	
	public Course(String id, String name) {
		if (id == null){
			throw new IllegalArgumentException();
		}
		this.id = id;
		if (name == null){
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.roll = new ArrayList<Student>();
	}
	
	
	public boolean add(Student aStudent){
		for (Student bStudent: roll){
			if (aStudent.equals(bStudent)){
				return false;
			}
		}
		roll.add(aStudent);
		return true;
	}
	
	public boolean drop(Student aStudent){
		for (Student bStudent: roll){
			if (aStudent.equals(bStudent)){
				roll.remove(aStudent);
				return true;
			}
		}
		return false;
	}
	
	public void cancel(){
		roll.clear();
	}
	
	public double averageGPA(){
		double averageGPA = -1.0;
		double addedGPA = 0.0;
		for (Student bStudent: roll){
			addedGPA = addedGPA + bStudent.getGpa();
		}
		if (roll.size() != 0){
			averageGPA = addedGPA / roll.size();
		}
		return averageGPA;
	}
	
	public String rollAsString(){
		return roll.toString();
	}
	
	public boolean equals(Object s2){
		if (s2 instanceof Course){
			Course aCourse = (Course) s2;
			return this.id.equals(aCourse.getId());
		}
		else
			return false;
	}
	
	@Override
	public String toString() {
		return "ID: "+id+"; Name: "+name+"; Number of students: "+roll.size(); 		
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Student> getRoll() {
		return roll;
	}
	public void setRoll(ArrayList<Student> roll) {
		this.roll = roll;
	}
	
}
