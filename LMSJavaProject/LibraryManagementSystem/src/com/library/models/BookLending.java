package com.library.models;

import java.util.Date;
import java.util.UUID;

public class BookLending {
	private String transactionId;
	private Book book;
	private Patron patron;
	private Date issueDate;
	private Date dueDate;
	private Date returnDate;

	public BookLending(Book book, Patron patron, Date issueDate, Date dueDate) {
		this.transactionId = UUID.randomUUID().toString();
		this.book = book;
		this.patron = patron;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
	}

	public Book getBook() {
		return book;
	}

	public Patron getPatron() {
		return patron;
	}

	public void returnBook() {
		this.returnDate = new Date();
		book.updateStatus(BookStatus.AVAILABLE);
		patron.returnBook();
	}
}
