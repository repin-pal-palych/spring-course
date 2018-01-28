package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.model.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    public static final String BOOKS_VIEW_NAME = "books";
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute(BOOKS_VIEW_NAME, bookRepository.findAll());

        return BOOKS_VIEW_NAME;
    }
}
