package com.library.main;

import com.library.managers.*;
import com.library.models.*;

public class LibraryManagementSystem {
	public static void main(String[] args) {
		// Instantiate managers
		BookManager bookManager = new BookManager();
		PatronManager patronManager = new PatronManager();
		LendingManager lendingManager = new LendingManager(bookManager, patronManager); // Inject dependencies

		// Create Books
		Book book1 = new Book("B101", "Java", "Sun Microsystems", "12345");
		Book book2 = new Book("B102", "OracleDB", "Oracle", "56789");

		bookManager.addBook(book1);
		bookManager.addBook(book2);

		// Create Patrons
		Patron patron1 = new Patron("P101", "Pawan", "pawan@example.com");
		Patron patron2 = new Patron("P102", "Khizer", "kiz@example.com");

		patronManager.registerPatron(patron1);
		patronManager.registerPatron(patron2);

		// Borrow Books
		System.out.println("Issuing book to Pawan:");
		boolean issued1 = lendingManager.issueBook("P101", "B101");
		System.out.println("Success: " + issued1);

		System.out.println("Issuing book to Khizer:");
		boolean issued2 = lendingManager.issueBook("P102", "B102");
		System.out.println("Success: " + issued2);

		// Return Book
		System.out.println("Returning book from Pawan:");
		lendingManager.returnBook("P101", "B101");

		// Searching for Books
		System.out.println("Searching for 'B101':");
		Book book = bookManager.searchBookById("B101");

		System.out.println("Found Book ID: " + book.getBookId());

	}
}
