
public class Employee extends Person {

	private String workAddress;
	private int employeeId;
	
	public Employee(String n, String ha) {
		super(n, ha);
		
	}

	public Employee(String n, String ha, String wa, int id) {
		super(n, ha);
//		name = n;
//		homeaddress = ha;
		workAddress = wa;
		employeeId = id;
	}
	
	@Override
	public String toString() {
		return "Employee [name = " + name + ", homeaddress= " + homeaddress + ", workAddress=" + workAddress + ", employeeId="
				+ employeeId + "]";
	}

	@Override
	public String getMailingaddress() {
		return name + ", " + workAddress;
	}	
	
	public static void main(String[] args) {
		Employee nada = new Employee("nada", "101 York", "Rice 405", 700);
		System.out.println(nada);
		System.out.println(nada.getMailingaddress());
	}
	
}
