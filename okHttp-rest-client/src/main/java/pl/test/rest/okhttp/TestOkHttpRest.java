/**
 * Copyright 2016-05-18 the original author or authors.
 */
package pl.test.rest.okhttp;

import com.squareup.okhttp.*;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public class TestOkHttpRest {

    public static void main(String[] args) throws Exception {

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");

        Request request = new Request.Builder()
                .url("http://localhost:8080/api/person/1")
                .get()
                .addHeader("content-type", "application/json")
                .addHeader("accept", "application/json")
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());

    }
}
