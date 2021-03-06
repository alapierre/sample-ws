package pl.test.rest.client; /**
 * Copyright 2016-05-18 the original author or authors.
 */

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import pl.test.rest.client.model.Person;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public class RestTemplateTest {

    public static void main(String[] args) {
        automatic();
    }

    public static void manual() {

        RestTemplate restTemplate = new RestTemplate();

        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new StringHttpMessageConverter());
        restTemplate.setMessageConverters(converters);

        HttpEntity httpEntity = new HttpEntity(createBasicAuthHeaders("user", "c79f63b2-acf9-4261-b911-084e92fd5058"));

        ResponseEntity<String> resp = restTemplate.exchange("http://localhost:8080/api/person/1",
                HttpMethod.GET, httpEntity, String.class);

        //ResponseEntity<String> resp = restTemplate.getForEntity("http://localhost:8080/api/person/1", String.class);

        System.out.println(resp.getBody());

        ObjectMapper mapper = new ObjectMapper();

        try {
            Person p = mapper.readValue(resp.getBody(), Person.class);

            System.out.println(p);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void automatic() {
        RestTemplate restTemplate = new RestTemplate();

        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new StringHttpMessageConverter());
        converters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(converters);

        HttpEntity httpEntity = new HttpEntity(createBasicAuthHeaders("user", "c79f63b2-acf9-4261-b911-084e92fd5058"));

        ResponseEntity<Person> resp = restTemplate.exchange(
                "http://localhost:8080/api/person/1",
                HttpMethod.GET,
                httpEntity,
                Person.class);

        System.out.println(resp.getBody());
    }

    static protected HttpHeaders createBasicAuthHeaders(final String username, final String password) {
        return new HttpHeaders() {
            {
                String auth = username + ":" + password;
                byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("UTF-8")));
                String authHeader = "Basic " + new String(encodedAuth);
                set("Authorization", authHeader);
            }
        };
    }

}
