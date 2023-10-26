package com.sistemi.entity;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book implements Serializable
{
	private static final long serialVersionUID = -7323677063962688089L;

	@Id
	private String ISBN;
	private String titolo; 
	private String genre; 
	private String descrizione;
	
	protected Book() {
		
	}
	
	public Book(String iSBN, String titolo, String genre, String descrizione) {
		super();
		ISBN = iSBN;
		this.titolo = titolo;
		this.genre = genre;
		this.descrizione = descrizione;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + 
				", titolo=" + titolo + 
				", genre=" + genre + 
				", descrizione=" + descrizione + "]";
	}
	
}
