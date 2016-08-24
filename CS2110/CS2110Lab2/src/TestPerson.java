import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestPerson {

	Person me;

	
	
	@Before
	public void setup() {
		me = new Person("Justin");

	}
	
	@Test
	public void testWatch() {
		int total = me.watch("Dark Knight Rises");
		assertEquals("I should have just watched 1 movie", 1, total);
	}

	@Test
	public void testWatch1() {
		me.watch("Scooby Doo");
		int total = me.watch("Dark Knight Rises");

		assertEquals("I should have just watched 1 movie", 2, total);
	}

	@After
	public void tearDown() {
		
	}
}
