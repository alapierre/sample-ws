/**
 * Copyright 2016-05-18 the original author or authors.
 */
package pl.com.softproject.ws.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.com.softproject.ws.rest.model.Person;
import pl.com.softproject.ws.rest.repository.PersonRepository;

import java.net.URI;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "person/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable int id) {

        System.out.println("usuwam " + id);

        personRepository.delete(id);

    }

    @RequestMapping(value = "person2", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Person saveOld(@RequestBody  Person person) {

        System.out.println(person);

        personRepository.save(person);

        return person;

    }

    @RequestMapping(value = "person", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody  Person person) {

        System.out.println(person);

        personRepository.save(person);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(person.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(value = "person/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> load(@PathVariable int id) {

        Person person = personRepository.findOne(id);
        if(person == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(person);
    }

    @RequestMapping(value = "persons", method = RequestMethod.GET)
    public Iterable<Person> list() {
        return personRepository.findAll();
    }

    @RequestMapping(value = "person/search/{name}", method = RequestMethod.GET)
    public Iterable<Person> findByName(@PathVariable String name) {

        return personRepository.findByNameLikeIgnoreCase(name + '%');

    }
}
