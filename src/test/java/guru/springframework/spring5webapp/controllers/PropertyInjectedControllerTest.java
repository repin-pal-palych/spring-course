package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.service.ConstructorGreetingService;
import guru.springframework.spring5webapp.service.PropertyGreetingService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PropertyInjectedControllerTest {

    private PropertyInjectedController propertyInjectedController;

    @Before
    public void setUp() throws Exception {
        propertyInjectedController = new PropertyInjectedController();
        propertyInjectedController.greetingService = new PropertyGreetingService();
    }

    @Test
    public void testGreeting() {
        assertEquals(ConstructorGreetingService.GREETING_MESSAGE, propertyInjectedController.sayHello());
    }
}