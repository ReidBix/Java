/**
 *
* Name: Reid Bixler
* Computing ID: rmb3yz
* Assignment: Homework 0
* Lab Section: 2110-103
* Date: January 29, 2014
* 
*/

import java.util.ArrayList;

public class BookClub {

	// The method commonBooks takes the Array List of Books from Person a and
	// Person b and returns an Array List of Books that both Person a and Person
	// b have read, returns an empty set if no books have been read by both
	// Persons
	public static ArrayList<Book> commonBooks(Person a, Person b) {
		ArrayList<Book> aRead = a.getRead();
		ArrayList<Book> bRead = b.getRead();
		ArrayList<Book> commonBooks = new ArrayList<Book>();
		for (Book bookA : aRead) {
			for (Book bookB : bRead) {
				if (bookA.equals(bookB)) {
					commonBooks.add(bookA);
				}
			}
		}
		return commonBooks;
	}

	// The method similarity takes the Array List of Books from Person a and
	// Person b and returns a double to measure the similarity of the books read
	// by both Persons, the method commonBooks is used to figure the number of
	// books read by both Persons which is then divided by the least number of
	// books read by one Person, the similarity will return values between 0 and
	// 1 with 0 being no similarity and 1 being total similarity
	public static double similarity(Person a, Person b) {
		ArrayList<Book> commonBooks = commonBooks(a, b);
		ArrayList<Book> aRead = a.getRead();
		ArrayList<Book> bRead = b.getRead();

		double aReadSize = (double) aRead.size();
		double bReadSize = (double) bRead.size();
		double commonBooksSize = (double) commonBooks.size();

		double similarity = 0.0;

		if (aReadSize == 0.0 || bReadSize == 0.0) {
			return similarity;

		} else {
			if (aReadSize >= bReadSize) {
				similarity = commonBooksSize / bReadSize;
			} else {
				similarity = commonBooksSize / aReadSize;
			}
			return similarity;
		}

	}

	// The main method used to test the commonBooks and similarity methods
	public static void main(String[] args) {
		// 3 books and 3 people initialized
		Book a = new Book("The Most Dangerous Game", "Richard Connell");
		Book b = new Book("Ender's Game", "Orson Scott Card");
		Book c = new Book("The Hunger Games", "Suzanne Collins");
		Person x = new Person("Sanger Rainsford", 1924);
		Person y = new Person("Ender Wiggin", 1985);
		Person z = new Person("Katniss Everdeen", 2008);

		// Person x (Sanger Rainsford) adds Book a (The Most Dangerous Game) and
		// Book b (Ender's Game) to his Array List of Books
		x.addBook(a);
		x.addBook(b);
		// Person y (Ender Wiggin) adds Book b (Ender's Game) and
		// Book c (The Hunger Games) to his Array List of Books
		y.addBook(b);
		y.addBook(c);
		// The commonBooks method will take the two Persons, x and y (Sanger
		// Rainsford and Ender Wiggin), and compare the Array List of Books.
		// Since the two have one book in common, it should return an Array List
		// with Book b (Ender's Game)
		System.out.println(commonBooks(x, y));

		// Using the commonBooks method with Persons x and y, the similarity
		// method finds that there is one (1) Book in common and both Persons
		// have read two (2) books, therefore making the similarity 1/2, or 0.5
		System.out
				.println("The similarity of books between Sanger Rainsford and Ender Wiggin is: "
						+ similarity(x, y));
		// Using the commonBooks method with Persons y and z, with Person z
		// (Katniss Everdeen) having not read any books, the similarity
		// method finds that there is zero (0) Books in common but Person z has
		// read zero (0) books, which would return 0/0, but that is counteracted
		// by returning 0.0 in any case that a Person has a Book list of 0
		System.out
				.println("The similarity of books between Ender Wiggin and Katniss Everdeen is: "
						+ similarity(y, z));

	}

}
