/**
 * Copyright 2016-05-13 the original author or authors.
 */
package pl.com.softproject.ws;

import javax.jws.WebService;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */

@WebService(endpointInterface = "pl.com.softproject.ws.SampleService", serviceName = "sampleService")
public class SampleServiceImpl implements SampleService {

    public String sayHallo(String name) {
        return "Hello " + name;
    }

}
