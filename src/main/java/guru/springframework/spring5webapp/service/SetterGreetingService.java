package guru.springframework.spring5webapp.service;

import org.springframework.stereotype.Service;

@Service
public class SetterGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello from setter greeting service!";
    }
}
