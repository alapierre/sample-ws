/**
 * Copyright 2016-05-19 the original author or authors.
 */
package pl.test.ws.soap;

import pl.com.softproject.ws.Customer;
import pl.com.softproject.ws.IOException_Exception;
import pl.com.softproject.ws.SampleService_Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public class SoapWithAtachment {

    public static void main(String[] args) throws IOException_Exception {


        SampleService_Service ws = new SampleService_Service();



        long start = System.currentTimeMillis();

        Customer res = ws.getSampleServiceImplPort().loadCustomer(1);

        try {
            InputStream is = res.getImageData().getInputStream();

            Path p = Paths.get("d:\\out.jpg");

            Files.copy(is, p, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("time: " + (end - start));

    }
}
