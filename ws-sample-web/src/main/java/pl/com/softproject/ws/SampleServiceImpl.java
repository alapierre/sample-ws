/**
 * Copyright 2016-05-13 the original author or authors.
 */
package pl.com.softproject.ws;

import pl.com.softproject.ws.model.Customer;

import javax.jws.WebService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */

@WebService(endpointInterface = "pl.com.softproject.ws.SampleService", serviceName = "sampleService")
public class SampleServiceImpl implements SampleService {

    public String sayHallo(String name) {
        return "Hello " + name;
    }


    @Override
    public Customer loadCustomer(int id) throws IOException {

        Customer customer = new Customer();

        Path path = Paths.get("D:\\foto\\DSC_0458.JPG");
        byte[] data = Files.readAllBytes(path);

        customer.setImageData(data);

        return customer;

    }

}
