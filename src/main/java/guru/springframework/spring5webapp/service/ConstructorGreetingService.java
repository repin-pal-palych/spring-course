package guru.springframework.spring5webapp.service;

import org.springframework.stereotype.Service;

@Service
public class ConstructorGreetingService implements GreetingService {

    public static final String GREETING_MESSAGE = "Hello, world!";

    @Override
    public String sayGreeting() {
        return "Hello from constructor greeting service!";
    }
}
