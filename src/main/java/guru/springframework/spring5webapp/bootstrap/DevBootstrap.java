package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.model.repositories.AuthorRepository;
import guru.springframework.spring5webapp.model.repositories.BookRepository;
import guru.springframework.spring5webapp.model.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher harperCollinsPublisher = new Publisher("Harper Collins", "Somewhere in USA");
        publisherRepository.save(harperCollinsPublisher);
        Publisher worxPublisher = new Publisher("Workx", "Some other place");
        publisherRepository.save(worxPublisher);
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book dddBook = new Book("Domain Driven Development", "1234");
        dddBook.setPublisher(harperCollinsPublisher);
        eric.getBooks().add(dddBook);
        dddBook.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(dddBook);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEjbBook = new Book("J2EE Development without EJB", "23444");
        noEjbBook.setPublisher(worxPublisher);
        noEjbBook.getAuthors().add(rod);
        rod.getBooks().add(noEjbBook);

        authorRepository.save(rod);
        bookRepository.save(noEjbBook);
    }
}
