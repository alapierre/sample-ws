/**
 * Copyright 2016-05-18 the original author or authors.
 */
package pl.com.softproject.ws.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.com.softproject.ws.rest.model.Person;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    public Iterable<Person> findByNameLikeIgnoreCase(String name);
}
