package com.library.models;

public class Patron {
	private String patronId;
	private String name;
	private String email;
	private int borrowedBooksCount;
	private int maxBooksAllowed;

	public Patron(String patronId, String name, String email) {
		this.patronId = patronId;
		this.name = name;
		this.email = email;
		this.borrowedBooksCount = 0;
		this.maxBooksAllowed = 5;
	}

	public boolean canBorrow() {
		return borrowedBooksCount < maxBooksAllowed;
	}

	public void borrowBook() {
		if (canBorrow())
			borrowedBooksCount++;
	}

	public void returnBook() {
		if (borrowedBooksCount > 0)
			borrowedBooksCount--;
	}

	public String getPatronId() {
		return patronId;
	}

	public String getName() {
		return name;
	}
}
