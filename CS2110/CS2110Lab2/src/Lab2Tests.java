/**
* Name: Reid Bixler, Brooke Kanarek
* Computing ID: rmb3yz, blk4fa
* Lab Section: 2110-103
* Date: January 27, 2014
*/


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class Lab2Tests {
	Student j;
	Student s;
	Course cs;
	Course uwbw;
	
	@Before
	public void setup(){
		j = new Student("Jeff",3.6);
		s = new Student("Sally",3.9);
		cs = new Course("CS2110","Software Development Methods");
		uwbw = new Course("ART1010","Intro to Underwater Basket Weaving Techniques");
	}
	
	
	@Test
	public void testAdd() {
		boolean result = j.add(uwbw);
		assertEquals("Jeff is in Underwater Basket Weaving", true, result);
	}
	@Test
	public void testAdd2() {
		j.add(uwbw);
		boolean result = j.add(uwbw);
		assertEquals("Jeff is still in Underwater Basket Weaving", false, result);	
	}
	@Test
	public void testAdd3() {
		j.add(uwbw);
		boolean result = s.add(uwbw);
		assertEquals("Jeff and Sally are in Underwater Basket Weaving", true, result);
	}
	@Test
	public void testAdd4() {
		boolean result = uwbw.add(j);
		assertEquals("Jeff is in Underwater Basket Weaving", true, result);
	}
	@Test
	public void testAdd5() {
		uwbw.add(j);
		boolean result = uwbw.add(j);
		assertEquals("Jeff is still in Underwater Basket Weaving", false, result);	
	}
	@Test
	public void testAdd6() {
		uwbw.add(j);
		boolean result = uwbw.add(s);
		assertEquals("Jeff and Sally are in Underwater Basket Weaving", true, result);
	}
	@Test
	public void testAdd7() {
		j.add(uwbw);
		boolean result = j.drop(uwbw);
		assertEquals("Jeff has decided not to take Underwater Basket Weaving", true, result);
	}
	@Test
	public void testAdd8() {
		j.add(uwbw);
		boolean result = j.drop(cs);
		assertEquals("Jeff isn't taking Software Development Methods", false, result);
	}
	@Test
	public void testAdd9() {
		j.add(uwbw);
		s.add(uwbw);
		j.add(uwbw);
		s.drop(uwbw);
		boolean result = j.drop(uwbw);
		assertEquals("Jeff and Sally have dropped Underwater Basket Weaving", true, result);
	}
	
	
}
