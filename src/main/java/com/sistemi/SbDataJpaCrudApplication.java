package com.sistemi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.sistemi.entity.Book;
import com.sistemi.service.BookService;



@SpringBootApplication
public class SbDataJpaCrudApplication implements CommandLineRunner
{

	@Autowired
	private BookService bookService;
	
	public static void main(String[] args) {
		SpringApplication.run(SbDataJpaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		
		Book book = new Book("34437482384", "Hilly Billy", "Drama", "Hilli Billy il grassone motociclista");
		Book book1 = new Book("344375734653", "One Piece", "Adventure", "Pirati dei caraibi");
		Book book2 = new Book("3443748231321", "Homunculus", "Drama", "blablala");
		Book book3 = new Book("3443748231724", "Vagabond", "Drama", "ba bla lba");
		Book book4 = new Book("344374823134", "Bleach", "Action", "Svolta psicologica tandrica");
		Book book5 = new Book("344374823179", "Black Colver", "Action", "sasasasas");
		Book book6 = new Book("344374823166", "Horimya", "Slice of Life", "cacacacacac");
		Book book6b = new Book("344374823166b", "Horimyaaa", "Slice of Life", "cacacacacac");
		Book book7 = new Book("344374823134", "Gintama", "Comedy", "gagagagag");
		
		
		
		bookService.saveOrUpdateBook(book);
		bookService.saveOrUpdateBook(book1);
		bookService.saveOrUpdateBook(book2);
		bookService.saveOrUpdateBook(book3);
		bookService.saveOrUpdateBook(book4);
		bookService.saveOrUpdateBook(book5);
		bookService.saveOrUpdateBook(book6);
		bookService.saveOrUpdateBook(book6b);
		bookService.saveOrUpdateBook(book7);
		

		bookService.findAllBooks();
		
		bookService.removeBook("344374823166b");
	
		bookService.findAllBooksByGenre("Slice of Life");
		
		bookService.findAllBooksByGenre("Drama");
		
	
	}

}
