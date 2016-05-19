/**
 * Copyright 2016-05-19 the original author or authors.
 */
package pl.com.softproject.ws.rest.model;

import javax.persistence.Embeddable;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
@Embeddable
public class Address {

    private String city;
    private String postCode;
    private String street;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
