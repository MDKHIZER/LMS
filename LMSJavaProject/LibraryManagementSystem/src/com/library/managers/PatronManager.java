package com.library.managers;

import com.library.models.Patron;
import java.util.*;

public class PatronManager {
	private Map<String, Patron> patrons;

	public PatronManager() {
		this.patrons = new HashMap<>();
	}

	public void registerPatron(Patron patron) {
		patrons.put(patron.getPatronId(), patron);
	}

	public Patron getPatron(String patronId) {
		return patrons.get(patronId);	}
}
