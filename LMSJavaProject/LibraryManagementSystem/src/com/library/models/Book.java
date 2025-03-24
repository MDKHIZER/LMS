package com.library.models;

public class Book {
	private String bookId;
	private String title;
	private String authors;
	private String isbn;
	private BookStatus status;

	public Book(String bookId, String title, String authors, String isbn) {
		this.bookId = bookId;
		this.title = title;
		this.authors = authors;
		this.isbn = isbn;
		this.status = BookStatus.AVAILABLE;
	}

	public void updateStatus(BookStatus status) {
		this.status = status;
	}

	public String getBookId() {
		return bookId;
	}

	public String getTitle() {
		return title;
	}

	public BookStatus getStatus() {
		return status;
	}
}
