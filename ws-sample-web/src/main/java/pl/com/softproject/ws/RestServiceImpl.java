/**
 * Copyright 2016-05-13 the original author or authors.
 */
package pl.com.softproject.ws;

import pl.com.softproject.ws.model.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
@Path("/persons")
public class RestServiceImpl {

    @GET
    @Produces("application/json")
    @Path("/")
    public Collection<Person> persons() {

        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Jan", "Kowalski", 47));

        return persons;

    }

}
