/**
 *
* Name: Reid Bixler
* Computing ID: rmb3yz
* Assignment: Homework 0
* Lab Section: 2110-103
* Date: January 29, 2014
* 
*/


public class Book {

	// Initialized fields for the Book class
	private String title;
	private String author;

	// Constructor for the Book class, consisting of a title and author
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	// Method for the Book class to compare a book to an object (hopefully
	// another Book) to see if they are the same/equal
	public boolean equals(Object o) {
		if (o instanceof Book) {
			Book aBook = (Book) o;
			return (this.title.equals(aBook.getTitle()) && this.author
					.equals(aBook.getAuthor()));
		} else
			return false;
	}

	// The toString method for the Book class
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + "]";
	}

	// Getter for title for the Book class
	public String getTitle() {
		return title;
	}

	// Setter for title for the Book class
	public void setTitle(String title) {
		this.title = title;
	}

	// Getter for author for the Book class
	public String getAuthor() {
		return author;
	}

	// Setter for author for the Book class
	public void setAuthor(String author) {
		this.author = author;
	}
}
