/**
* Name: Reid Bixler, Brooke Kanarek
* Computing ID: rmb3yz, blk4fa
* Lab Section: 2110-103
* Date: January 27, 2014
*/

import java.util.ArrayList;
import java.util.Collections;


public class Student implements Comparable<Student>{
	private String name;
	private double gpa;
	private ArrayList<Course> courses;
	
	public static void main(String[] args){
		Student Bob = new Student("Smith, Bob", 3.6);
		Student Sally = new Student("Jane, Sally", 3.9);
		Student Alex = new Student("Smith, Alex", 2.9);
		Student Jeff = new Student("Lee, Jeff", 3.9);
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(Bob);
		studentList.add(Sally);
		studentList.add(Alex);
		studentList.add(Jeff);
		
		System.out.println(Bob.compareTo(Sally));
		System.out.println(Bob.compareTo(Alex));
		System.out.println(Sally.compareTo(Jeff));
		System.out.println(Jeff.compareTo(Jeff));
		System.out.println(studentList);
		Collections.sort(studentList);
		System.out.println(studentList);

	}
	
	public Student(String name, double gpa){
		this.name = name;
		if (gpa < 0.0 || gpa > 4.0){
			throw new IllegalArgumentException();
		}
		this.gpa = gpa;
		this.courses = new ArrayList<Course>();
	}
	public Student(String name){
		this.name = name;
		gpa = 0.0;
		this.courses = new ArrayList<Course>();
	}
	
	public boolean add(Course aCourse){
		for (Course bCourse : courses){
			if (aCourse.equals(bCourse)){
				return false;
			}
		}
		courses.add(aCourse);
		return true;
	}
	
	
	public boolean drop(Course aCourse){
		for (Course bCourse: courses){
			if (aCourse.equals(bCourse)){
				courses.remove(aCourse);
				return true;
			}
		}
		return false;
	}
	
	public void dropAll(){
		courses.clear();
	}
	
	
	@Override
	public String toString() {
		return "Name: "+name+"; GPA: "+gpa+"; Number of classes: "+courses.size();		
	}
	
	public String coursesAsString(){
		return courses.toString();
	}
	
	public boolean equals(Object s2){
		if (s2 instanceof Student){
			Student aStudent = (Student) s2;
			return this.name.equals(aStudent.getName());
		}
		else
			return false;
	}
		
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getGpa() {
		return gpa;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	@Override
	public int compareTo(Student s) {
		int retVal = 0;
		Double gpa1 = this.gpa;
		Double gpa2 = s.gpa;
		if (gpa1 < gpa2) return 1;
		else if (gpa1 > gpa2) return -1;
		String[] array1 = this.name.trim().split(", ");
		String[] array2 = s.name.trim().split(", ");
		String lastName1 = array1[0];
		String lastName2 = array2[0];
		String firstName1 = array1[1];
		String firstName2 = array2[1];
		retVal = lastName1.compareTo(lastName2);
		if (retVal != 0) return retVal;
		retVal = firstName1.compareTo(firstName2);
		if (retVal != 0) return retVal;
		return 0;
	}
	
	
}
