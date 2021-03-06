/**
 * Copyright 2016-05-18 the original author or authors.
 */
package pl.test.rest.client.model;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public class Person {

    private int id;
    private String name;
    private int age;
    private String addressCity;
    private String addressPostCode;
    private String addressStreet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressPostCode() {
        return addressPostCode;
    }

    public void setAddressPostCode(String addressPostCode) {
        this.addressPostCode = addressPostCode;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", addressCity='" + addressCity + '\'' +
                ", addressPostCode='" + addressPostCode + '\'' +
                ", addressStreet='" + addressStreet + '\'' +
                '}';
    }
}
