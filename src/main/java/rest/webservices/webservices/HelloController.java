package rest.webservices.webservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

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
}
