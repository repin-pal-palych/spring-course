package guru.springframework.spring5webapp.service;

import org.springframework.stereotype.Service;

@Service
public class PropertyGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello from property greeting service!";
    }
}
