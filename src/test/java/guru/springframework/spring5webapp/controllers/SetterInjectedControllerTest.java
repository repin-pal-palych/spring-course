package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.service.ConstructorGreetingService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SetterInjectedControllerTest {

    private SetterInjectedController setterInjectedController;

    @Before
    public void setUp() throws Exception {
        setterInjectedController = new SetterInjectedController();
        setterInjectedController.setGreetingService(new ConstructorGreetingService());
    }

    @Test
    public void testGreeting() {
        assertEquals(ConstructorGreetingService.GREETING_MESSAGE, setterInjectedController.sayHello());
    }
}