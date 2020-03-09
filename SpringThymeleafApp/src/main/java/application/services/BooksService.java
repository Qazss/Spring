package application.services;


import application.entity.Book;
import application.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
	private BooksRepository booksRepository;

	@Autowired
	public void setBooksRepository(BooksRepository booksRepository) {
		this.booksRepository = booksRepository;
	}

	public List<Book> getAllBooks(){
		return (List<Book>) booksRepository.findAll();
	}

	public void saveBook(Book book) {
		booksRepository.save(book);
	}

	public void removeById(Long id) {
		booksRepository.deleteById(id);
	}
}
