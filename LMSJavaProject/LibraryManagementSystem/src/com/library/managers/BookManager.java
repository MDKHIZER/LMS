package com.library.managers;

import com.library.models.Book;
import java.util.*;


public class BookManager {
	private Map<String, Book> books;

	public BookManager() {
		this.books = new HashMap<>();
	}

	public void addBook(Book book) {
		books.put(book.getBookId(), book);
	}

	public Book searchBookById(String bookId) {
		 return books.get(bookId);
	}

	
}
