package rest.webservices.webservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.webservices.webservices.entities.Name;
import rest.webservices.webservices.entities.PersonV1;
import rest.webservices.webservices.entities.PersonV2;

@RestController
public class VersioningController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Bob");
    }

    @GetMapping("/v2/person")
    public PersonV2 getFirstVersionOfPersonV2(){
        return new PersonV2(new Name("Bob", "Standler"));
    }

/*
        Passing version by parameter header.
        http://localhost:8080/person?version=1
        http://localhost:8080/person?version=2
 */
    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonParamsV1(){
        return new PersonV1("Bob");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getFirstVersionOfPersonParamsV2(){
        return new PersonV2(new Name("Bob", "Standler"));
    }
}
