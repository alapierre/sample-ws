/**
 * Copyright 2016-05-13 the original author or authors.
 */
package pl.com.softproject.ws;

import javax.jws.WebService;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */

@WebService
public interface SampleService {
    String sayHallo(String name);
}
