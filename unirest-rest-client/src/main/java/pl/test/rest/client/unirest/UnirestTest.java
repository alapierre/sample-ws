/**
 * Copyright 2016-05-18 the original author or authors.
 */
package pl.test.rest.client.unirest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public class UnirestTest {


    public static void main(String[] args) throws Exception {

        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8080/api/person/1")
                .header("content-type", "application/json")
                .header("accept", "application/json")
                .header("cache-control", "no-cache")
                .asJson();

        JsonNode json = response.getBody();

        System.out.println(json.getObject().get("name"));

        System.out.println(json);

    }
}
