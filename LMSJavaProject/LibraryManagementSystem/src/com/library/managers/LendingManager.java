package com.library.managers;

import com.library.models.*;
import java.util.*;

public class LendingManager {
	private final BookManager bookManager;
	private final PatronManager patronManager;
	private final List<BookLending> lendingRecords;

	public LendingManager(BookManager bookManager, PatronManager patronManager) {
		this.bookManager = bookManager;
		this.patronManager = patronManager;
		this.lendingRecords = new ArrayList<>();
	}

	public boolean issueBook(String patronId, String bookId) {
		Patron patron = patronManager.getPatron(patronId);
		Book book = bookManager.searchBookById(bookId);

		if (patron != null && book != null && patron.canBorrow() && book.getStatus() == BookStatus.AVAILABLE) {
			patron.borrowBook();
			book.updateStatus(BookStatus.ISSUED);
			lendingRecords.add(new BookLending(book, patron, new Date(), calculateDueDate()));
			return true;
		}
		return false;
	}

	public void returnBook(String patronId, String bookId) {
		for (BookLending lending : lendingRecords) {
			if (lending.getBook().getBookId().equals(bookId) && lending.getPatron().getPatronId().equals(patronId)) {
				lending.returnBook();
				break;
			}
		}
	}

	private Date calculateDueDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 14);
		return calendar.getTime();
	}
}
