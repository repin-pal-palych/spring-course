package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    @Autowired
    private GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String hello() {
        return greetingService.sayGreeting();
    }
}
