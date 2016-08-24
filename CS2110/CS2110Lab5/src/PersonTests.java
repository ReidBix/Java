import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;


public class PersonTests {

	@Test
	public void testPersonOnly() {
		Person p1 = new Person("Jane", "100 Main St, Somewhere");
		Person p2 = new Person("Raul", "27 Elm St, Elsewhere");
		
		assertEquals("toString", "{Person: name=Jane, homeAddress=100 Main St, Somewhere|", p1.toString());
		assertEquals("toString", "{Person: name=Raul, homeAddress=27 Elm St, Elsewhere|", p2.toString());
	}
	@Test
	public void testPersonEmployee() {
		ArrayList<Person> list = new ArrayList<Person>();
		Person p = new Person("Mai", "3156 Grove Rd, Somewhere");
		list.add(p);
		p = new Employee("Don", "6562 Trask Way, Elsewhere", "Front Desk", 2110);
		list.add(p);
		
		assertEquals("toString", "{Person: name=Mai, homeAddress=3156 Grove Rd, Somewhere|", list.get(0).toString());
		assertEquals("toString", "{Empl: n=Don, ha=6562 Trask Way, Elsewhere, wa=Front Desk, id=2110}", list.get(1).toString());
	}
	@Test
	public void testPersonEmployeeStudent() {
		ArrayList<Person> list = new ArrayList<Person>();
		Person p = new Person("Mai", "3156 Grove Rd, Somewhere");
		list.add(p);
		p = new Employee("Don", "6562 Trask Way, Elsewhere", "Front Desk", 2110);
		list.add(p);
		// TODO: uncomment the following
		p = new Student("Dana Wahoo", "21 Wahoo Ave, NOVA", "1 JPA, CVille, VA");
		list.add(p);
		
		assertEquals("toString", "{Person: name=Mai, homeAddress=3156 Grove Rd, Somewhere|", list.get(0).toString());
		assertEquals("toString", "{Empl: n=Don, ha=6562 Trask Way, Elsewhere, wa=Front Desk, id=2110}", list.get(1).toString());
		assertEquals("toString", "{Student: n=Dana Wahoo, ha=21 Wahoo Ave, NOVA, ca=1 JPA, CVille, VA, gpa=0.0}", list.get(2).toString()); // TODO: finish this
		assertEquals(true, list.get(0) instanceof Person);
		assertEquals(true, list.get(1) instanceof Person);
		assertEquals(true, list.get(2) instanceof Person);
		assertEquals(true, list.get(0) instanceof Comparable);
		assertEquals(true, list.get(1) instanceof Comparable);
		assertEquals(true, list.get(2) instanceof Comparable);

		
	}
//	@Test
//	public void testPersonList() {
//		ArrayList<Person> list = new ArrayList<Person>();
//		Person p = new Person("Mai", "3156 Grove Rd, Somewhere");
//		list.add(p);
//		Person p2 = new Employee("Don", "6562 Trask Way, Elsewhere", "Front Desk", 2110);
//		list.add(p2);
//		// TODO: uncomment the following
//		Person p3 = new Student("Dana Wahoo", "21 Wahoo Ave, NOVA", "1 JPA, CVille, VA");
//		list.add(p3);
//		Person p4 = new Person ("Bob", "1234 Maple Rd, Washington");
//		list.add(p4);
//		Person p5 = new Employee("Chuck", "5678 Redwood Lane, California", "Behind the Counter", 1111);
//		list.add(p5);
//		Person p6 = new Student("Sally", "1968 Tiger Blvd, Michigan", "5 Treehouse Drive, CVille, VA");
//		list.add(p6);
//		
//		ArrayList<Person> list2 = new ArrayList<Person>();
//		list2.add(p4);
//		list2.add(p5);
//		list2.add(p3);
//		list2.add(p2);
//		list2.add(p);
//		list2.add(p6);
//		
//		
//		assertEquals(Collections.sort(list)), list2.toArray());
//	}

}
