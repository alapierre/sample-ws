/**
 * Copyright 2016-05-13 the original author or authors.
 */
package pl.com.softproject.ws;

import pl.com.softproject.ws.model.Customer;

import javax.jws.WebService;
import java.io.IOException;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */

@WebService
public interface SampleService {
    String sayHallo(String name);

    Customer loadCustomer(int id) throws IOException;
}
