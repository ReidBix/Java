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

public class Person {

	// Initialized fields for the Person class
	private String name;
	private int id;
	private ArrayList<Book> read;

	// Constructor for the Person class, consisting of a name, id, and an empty
	// ArrayList of Books
	public Person(String name, int id) {
		this.name = name;
		this.id = id;
		this.read = new ArrayList<Book>();
	}

	// Method for the Person class that adds a Book to the ArrayList of Books
	// for the Person the method is being used on and returns true, if the Book
	// is already in the ArrayList, returns false
	public boolean addBook(Book b) {
		for (Book a : read) {
			if (b.equals(a)) {
				return false;
			}
		}
		read.add(b);
		return true;
	}

	// Method for the Person class that checks the ArrayList of Books for the
	// Person the method is being used on and returns true if the Book is found,
	// if the Book is not in the ArrayList, returns false
	public boolean hasRead(Book b) {
		for (Book a : read) {
			if (b.equals(a)) {
				return true;
			}
		}
		return false;
	}

	// Method for the Person class that checks the ArrayList of Books for the
	// Person the method is being used on and returns true if the Book is found
	// and removes it, if the Book is not in the ArrayList, returns false
	public boolean forgetBook(Book b) {
		for (Book a : read) {
			if (b.equals(a)) {
				read.remove(b);
				return true;
			}
		}
		return false;
	}

	// Method for the Person class that returns the ArrayList of Books' size
	public int numBooksRead() {
		return read.size();
	}

	// Method for the Person class to compare a person to an object (hopefully
	// another person) to see if they are the same/equal
	public boolean equals(Object o) {
		if (o instanceof Person) {
			Person aPerson = (Person) o;
			return this.id == aPerson.getId();
		} else
			return false;
	}

	// The toString method for the Person class
	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + ", read=" + read + "]";
	}

	// Getter for name for the Person class
	public String getName() {
		return name;
	}

	// Setter for name for the Person class
	public void setName(String name) {
		this.name = name;
	}

	// Getter for id for the Person class
	public int getId() {
		return id;
	}

	// Setter for id for the Person class
	public void setId(int id) {
		this.id = id;
	}

	// Getter for Array List of Books for the Person class
	public ArrayList<Book> getRead() {
		return read;
	}

	// Setter for Array List of Books for the Person class
	public void setRead(ArrayList<Book> read) {
		this.read = read;
	}

}
