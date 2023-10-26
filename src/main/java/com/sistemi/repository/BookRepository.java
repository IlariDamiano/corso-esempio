package com.sistemi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemi.entity.Book;

public interface BookRepository extends JpaRepository<Book, String>
{

	List<Book> findByGenre(String genre);
	

}
