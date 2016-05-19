/**
 * Copyright 2016-05-18 the original author or authors.
 */
package pl.com.softproject.ws.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.com.softproject.ws.rest.converter.PersonConverter;
import pl.com.softproject.ws.rest.dto.PersonDTO;
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
    private PersonConverter personConverter;

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
    public ResponseEntity<?> save(@RequestBody PersonDTO personDTO) {

        System.out.println(personDTO);

        Person person = personConverter.toDBO(personDTO);

        System.out.println(person);

        personRepository.save(person);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(person.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(value = "person/{id}", method = RequestMethod.GET)
    public ResponseEntity<PersonDTO> load(@PathVariable int id) {

        Person person = personRepository.findOne(id);
        if(person == null) {
            return (ResponseEntity) ResponseEntity.notFound().build();//(ResponseEntity<PersonDTO>) HttpEntityUtil.notFound(); //ResponseEntity.notFound().build();
        }

        System.out.println(person);

        return ResponseEntity.ok(personConverter.toDTO(person)); //HttpEntityUtil.responseEntity(personConverter.toDTO(person)); //ResponseEntity.ok(personConverter.toDTO(person));
    }

    @RequestMapping(value = "persons", method = RequestMethod.GET)
    public Iterable<PersonDTO> list() {
        return personConverter.toDTO(personRepository.findAll());
    }

    @RequestMapping(value = "person/search/{name}", method = RequestMethod.GET)
    public Iterable<PersonDTO> findByName(@PathVariable String name) {
        return personConverter.toDTO(personRepository.findByNameLikeIgnoreCase(name + '%'));
    }
}
