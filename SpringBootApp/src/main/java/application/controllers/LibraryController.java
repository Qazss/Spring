package application.controllers;

import application.entity.Book;
import application.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("/library")
public class LibraryController {
	private BooksService booksService;

	@Autowired
	public void setBooksService(BooksService booksService) {
		this.booksService = booksService;
	}

	@RequestMapping(path="/showAll", method= RequestMethod.GET)
	public String showAllBooks(Model model) {
		List<Book> booksList = booksService.getAllBooks();
		model.addAttribute("booksList", booksList);
		return "show-all-books";
	}

	@RequestMapping(path="/form", method= RequestMethod.GET)
	public String fillBookForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "add-book-form";
	}

	@RequestMapping(path="/form", method= RequestMethod.POST)
	public String fillBookForm(Book book) {
		booksService.saveBook(book);
		return "redirect:/library/showAll";
	}

	@RequestMapping(path="/remove/{id}", method= RequestMethod.GET)
	public String removeById(@PathVariable(name = "id") Long id) {
		booksService.removeById(id);
		return "redirect:/library/showAll";
	}
}
