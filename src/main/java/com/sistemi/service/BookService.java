package com.sistemi.service;


import com.sistemi.entity.Book;

public interface BookService 
{
	public void saveOrUpdateBook(Book book);
	public void removeBook(String isbn);
	public void findAllBooks();
	public void findAllBooksByGenre(String genre);

}
