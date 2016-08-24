
public class Student extends Person {
	private String campusAddress;
	private double gpaValue;
	
	public Student(String n, String ha, String ca){
		super(n, ha);
		this.campusAddress = ca;
		this.gpaValue = 0.0;
	}

	@Override
	public String getMailingAddress() {
		return campusAddress;
	}
	
	public String toString() {
		return "{Student: " + "n=" + super.name + ", ha=" + super.homeAddress + ", ca=" + campusAddress + ", gpa=" + gpaValue + "}";
		//
	}
	
	
	
	public static void main(String[] args){
		Person p = new Student("Dana Wahoo", "21 Wahoo Ave, NOVA", "1 JPA, CVille, VA");
		System.out.println(p);
	}
}
