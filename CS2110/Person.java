
public class Person {

	private String name;
	private String homeaddress;
	
	public Person(String n, String ha) {
		name = n;
		homeaddress = ha;
	}
	
	// ** GETTERS & SETTERS ** ----------------------------	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHomeaddress() {
		return homeaddress;
	}

	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
	}
	// ----------------------------------------------------

	public static void main(String[] args) {
		Person p1 = new Person("bob", "101 York");
		System.out.println(p1);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", homeaddress=" + homeaddress + "]";
	}

}
