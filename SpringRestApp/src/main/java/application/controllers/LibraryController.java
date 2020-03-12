package application.controllers;

import application.entity.Book;
import application.services.BooksService;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;


@RestController
@RequestMapping("/library")
public class LibraryController {
	private static final String QUEUE_NAME = "books";

	private BooksService booksService;

	@Autowired
	public void setBooksService(BooksService booksService) {
		this.booksService = booksService;
	}

	@GetMapping("/showAll")
	public List<Book> showAllBooks(Model model) {
		return booksService.getAllBooks();
	}

	@PostMapping("/book")
	public Book postBook(@RequestBody Book book) {
		booksService.saveBook(book);
		return book;
	}

	@PutMapping(path = "/book", consumes = (MediaType.APPLICATION_JSON_VALUE))
	public Book putBook(@RequestBody Book book) {
		booksService.saveBook(book);

		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String msg = "добавлена новая книга" + book.getTitle();
			channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

		return book;
	}

	@DeleteMapping("/remove/{id}")
	public int removeById(@PathVariable(name = "id") Long id) {
		booksService.removeById(id);
		return HttpStatus.OK.value();
	}
}
