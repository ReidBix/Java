import static org.junit.Assert.*;

import org.junit.Test;


public class testZeroDivision {

	@Test (timeout=200, expected=ArithmeticException.class)
	public void testZeroDivision() throws ArithmeticException{
		assertEquals("divide (0/3)", 0, 0 / 3);
		int giveError = 3 / 0;	
		fail("Not yet implemented");
	}

}
