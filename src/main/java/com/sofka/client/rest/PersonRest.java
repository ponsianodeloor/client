package com.sofka.client.rest;

import com.sofka.client.model.Person;
import com.sofka.client.service.PersonService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Person", description = "API para person")
@RestController
@RequestMapping("/api/v1.0")
@CrossOrigin(origins = {"*"})
public class PersonRest {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable("id") String id) {
        return personService.getPersonById(id);
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

}
