/**
 * Copyright 2016-05-18 the original author or authors.
 */
package pl.com.softproject.ws.model;

import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
@XmlType
public class Customer {

    private int id;
    private String name;

    @XmlMimeType("application/octet-stream")
    private byte[] imageData;

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

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}
