/**
 * Copyright 2016-05-19 the original author or authors.
 */
package pl.test.ws.soap;

import pl.com.softproject.ws.SampleService_Service;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public class SoapTest {

    public static void main(String[] args) {

        SampleService_Service ws = new SampleService_Service();

        String res = ws.getSampleServiceImplPort().sayHallo("Ala");

        System.out.println(res);

    }
}
