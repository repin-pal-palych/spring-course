package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.service.ConstructorGreetingService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstructorInjectedControllerTest {

    private ConstructorInjectedController constructorInjectedController;

    @Before
    public void setUp() throws Exception {
        constructorInjectedController = new ConstructorInjectedController(new ConstructorGreetingService());
    }

    @Test
    public void testGreeting() {
        assertEquals(ConstructorGreetingService.GREETING_MESSAGE, constructorInjectedController.sayHello());
    }
}