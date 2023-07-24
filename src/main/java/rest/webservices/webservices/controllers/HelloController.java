package rest.webservices.webservices.controllers;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import rest.webservices.webservices.entities.HelloWorld;

import java.util.Locale;

@RestController
public class HelloController {

    private MessageSource messageSource;

    public HelloController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-message")
    public HelloWorld helloWorldMessage() {
        return new HelloWorld("Hello World");
    }

    @GetMapping(path = "/hello-world/variable/{name}")
    public HelloWorld helloWorldMessage(@PathVariable String name) {
        return new HelloWorld(String.format("Hello World, %s", name));
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
      return messageSource.getMessage("example.message", null, "Default Message", locale);
    }
}
