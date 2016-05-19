/**
 * Copyright 2016-05-13 the original author or authors.
 */
package pl.com.softproject.ws.model;

import javax.xml.bind.annotation.XmlMimeType;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public class Person {

    private String name;
    private String lastName;
    private int age;

    @XmlMimeType("application/octet-stream")
    private byte[] imageData;

    public Person() {
    }

    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
