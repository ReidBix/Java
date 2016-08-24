/**
 *
* Name: Reid Bixler
* Computing ID: rmb3yz
* Assignment: Homework 0
* Lab Section: 2110-103
* Date: January 29, 2014
* 
*/


// SUBMITTING THIS TESTS FILE JUST BECAUSE I USED IT IN ORDER
// TO CHECK MY WORK ON THE BOOK AND PERSON CLASSES, WHILE IT
// WASN'T IN THE REQUIRED SUBMISSIONS I CONSIDERED THIS TO BE
// PART OF MY HOMEWORK, SORRY IF I WASN'T SUPPOSED TO!

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class HW0Tests {
	// Initializes the variables for later use in Tests
	Book a;
	Book b;
	Book c;
	Person x;
	Person y;
	Person z;

	// Before setups used so that new Books and Persons don't have to be created
	// in every test
	@Before
	public void setup() {
		a = new Book("The Most Dangerous Game", "Richard Connell");
		b = new Book("Ender's Game", "Orson Scott Card");
		c = new Book("The Hunger Games", "Suzanne Collins");
		x = new Person("Sanger Rainsford", 1924);
		y = new Person("Ender Wiggin", 1985);
		z = new Person("Katniss Everdeen", 2008);
	}

	// Tests the equals method for the Book class in the instance of two
	// separate books, a and b
	@Test
	public void testBookEquals() {
		boolean result = a.equals(b);
		assertEquals(
				"The Most Dangerous Game and Ender's Game are not the same book",
				false, result);
	}

	// Tests the equals method for the Book class in the instance of one single
	// book compared to itself
	@Test
	public void testBookEquals2() {
		boolean result = c.equals(c);
		assertEquals("The Hunger Games is the same book as The Hunger Games",
				true, result);
	}

	// Tests the equals method for the Book class in the instance of one single
	// book compared to another object that is not a book, which should
	// automatically return false because the object being compared is not a
	// book
	@Test
	public void testBookEquals3() {
		boolean result = a.equals("Hello");
		assertEquals(
				"The Most Dangerous Game cannot be compared to something that isn't a book",
				false, result);
	}

	// Tests the addBook method for the Person class in the instance of one
	// Person
	// adding one Book that has not been added before
	@Test
	public void testAddBook() {
		boolean result = x.addBook(a);
		assertEquals("Sanger Rainsford added The Most Dangerous Game", true,
				result);
	}

	// Tests the addBook method for the Person class in the instance of one
	// Person
	// adding two Books and then trying to add a previously added book
	@Test
	public void testAddBook2() {
		y.addBook(a);
		y.addBook(b);
		boolean result = y.addBook(b);
		assertEquals("Ender Wiggin cannot add Ender's Game again", false,
				result);
	}

	// Tests the hasRead method for the Person class in the instance of one
	// Person adding one Book and then seeing if the Person has read that one
	// added Book
	@Test
	public void testHasRead() {
		z.addBook(c);
		boolean result = z.hasRead(c);
		assertEquals("Katniss Everdeen has read The Hunger Games", true, result);
	}

	// Tests the hasRead method for the Person class in the instance of one
	// Person adding one Book and then seeing if the Person has read a Book
	// which has not yet been added
	@Test
	public void testHasRead2() {
		x.addBook(a);
		boolean result = x.hasRead(c);
		assertEquals("Sanger Rainsford has not read The Hunger Games", false,
				result);
	}

	// Tests the forgetBook method for the Person class in the instance of one
	// Person adding one Book and then forgetting the book which has just been
	// added
	@Test
	public void testForgetBook() {
		y.addBook(c);
		boolean result = y.forgetBook(c);
		assertEquals("Ender Wiggin has forgotten The Hunger Games", true,
				result);
	}

	// Tests the forgetBook method for the Person class in the instance of one
	// Person adding one Book and then trying to forget a book which has not
	// been added
	@Test
	public void testForgetBook2() {
		z.addBook(b);
		boolean result = z.forgetBook(c);
		assertEquals(
				"Katniss Everdeen cannot forget The Hunger Games because she hasn't read it",
				false, result);
	}

	// Tests the numBooksRead method for the Person class in the instance of one
	// Person adding two Books and finding the number of books read
	@Test
	public void testNumBooksRead() {
		x.addBook(a);
		x.addBook(b);
		int result = x.numBooksRead();
		assertEquals(
				"Sanger Rainsford has read 2 books; The Most Dangerous Game and Ender's Game",
				2, result);
	}

	// Tests the numBooksRead method for the Person class in the instance of one
	// Person adding zero Books and finding the number of books read
	@Test
	public void testNumBooksRead2() {
		int result = z.numBooksRead();
		assertEquals("Katniss Everdeen hasn't read any books", 0, result);
	}

	// Tests the equals method for the Person class in the instance of two
	// separate Persons, x and y
	public void testPersonEquals() {
		boolean result = x.equals(y);
		assertEquals("Sanger Rainsford is not the same person as Ender Wiggin",
				false, result);
	}

	// Tests the equals method for the Person class in the instance of only one
	// Person being compared to itself
	@Test
	public void testPersonEquals2() {
		boolean result = y.equals(y);
		assertEquals("Ender Wiggin is the same person as Ender Wiggin", true,
				result);
	}

	// Tests the equals method for the Person class in the instance of only one
	// Person being compared to an object which is not a Person
	@Test
	public void testPersonEquals3() {
		boolean result = z.equals("A tribute");
		assertEquals(
				"Katniss Everdeen cannot be compared to something that isn't a Person ",
				false, result);
	}

}
