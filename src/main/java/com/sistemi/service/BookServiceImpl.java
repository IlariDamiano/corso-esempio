package com.sistemi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.sistemi.entity.Book;
import com.sistemi.repository.BookRepository;


//@ComponentScan("com.sistemi.BookRepository")
//@Configuration
@Service
public class BookServiceImpl implements BookService
{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${message.save.success}")
    private String saveSuccess;

    @Value("${message.save.fail}")
    private String saveFail;

    @Value("${message.remove.success}")
    private String removeSuccess;

    @Value("${message.remove.fail}")
    private String removeFail;

    @Value("${message.read.fail}")
    private String readFail;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public void saveOrUpdateBook(Book book) 
	{
		if(book!=null && bookRepository.save(book).getISBN() == book.getISBN())
		{
			logger.info(saveSuccess);
		} 
		else
			logger.info(saveFail);
		
	}

	@Override
	public void removeBook(String isbn) {
		if(isbn !=null && bookRepository.existsById(isbn))
		{
			bookRepository.deleteById(isbn);
			if(!bookRepository.existsById(isbn))
				logger.info(removeSuccess);

				else
					logger.info("sas");
				
		}
		else
			logger.info(removeFail);
		}
		
		
	

	@Override
	public void findAllBooks() {

		
		List<Book> books = bookRepository.findAll();
			
		if(!books.isEmpty())
			books.forEach(book->System.out.println(book + "\n"));
		else {
			logger.info(readFail);
		}
		
	}

	@Override
	public void findAllBooksByGenre(String genre) {

		List<Book> booksListByGenreBooks = bookRepository.findByGenre(genre);
		
		if(!booksListByGenreBooks.isEmpty())
			booksListByGenreBooks.forEach(booksList->System.out.println(booksList + "\n"));
		else {
			logger.info(readFail);
		}
		
		
	}

}
