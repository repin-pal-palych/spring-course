package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.model.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private static final String AUTHORS_VIEW = "authors";
    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute(AUTHORS_VIEW, authorRepository.findAll());

        return AUTHORS_VIEW;
    }
}
