package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.repositories.AuthorRepository;
import guru.springframework.spring5webapp.model.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book dddBook = new Book("Domain Driven Development", "1234", "Harper Collins");
        eric.getBooks().add(dddBook);
        dddBook.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(dddBook);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEjbBook = new Book("J2EE Development without EJB", "23444", "Worx");
        rod.getBooks().add(noEjbBook);
        noEjbBook.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEjbBook);
    }
}