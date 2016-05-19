/**
 * Copyright 2016-05-13 the original author or authors.
 */
package pl.com.softproject.ws;

import pl.com.softproject.ws.model.Customer;
import pl.com.softproject.ws.model.Person;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import java.io.IOException;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */

@WebService
public interface SampleService {

    String sayHallo(String name);

    void savePerson(@WebParam(name = "person") @XmlElement(required=true, nillable=false) Person person);

    Person loadPerson(int id);

    Customer loadCustomer(int id) throws IOException;
}
