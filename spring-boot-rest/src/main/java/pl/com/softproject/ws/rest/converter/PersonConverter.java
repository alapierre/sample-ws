/**
 * Copyright 2016-05-19 the original author or authors.
 */
package pl.com.softproject.ws.rest.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.com.softproject.ws.rest.dto.PersonDTO;
import pl.com.softproject.ws.rest.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
@Component
public class PersonConverter {

    private ModelMapper modelMapper = new ModelMapper();

    public Person toDBO(PersonDTO personDTO) {

        return modelMapper.map(personDTO, Person.class);

    }

    public PersonDTO toDTO(Person personDBO) {
        return modelMapper.map(personDBO, PersonDTO.class);
    }

    public Iterable<PersonDTO> toDTO(Iterable<Person> personsDBO) {

        List<PersonDTO> res = new ArrayList<>();

        personsDBO.forEach(person -> {
            res.add(modelMapper.map(person, PersonDTO.class));
        });

        return res;
    }

    public Iterable<Person> toDBO(Iterable<PersonDTO> personsDTO) {

        List<Person> res = new ArrayList<>();

        personsDTO.forEach(person -> {
            res.add(modelMapper.map(person, Person.class));
        });

        return res;
    }
}
