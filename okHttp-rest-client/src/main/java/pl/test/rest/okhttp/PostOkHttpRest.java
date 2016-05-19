/**
 * Copyright 2016-05-18 the original author or authors.
 */
package pl.test.rest.okhttp;

import com.squareup.okhttp.*;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public class PostOkHttpRest {

    public static void main(String[] args) throws Exception {

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");

        RequestBody body = RequestBody.create(mediaType, "{\"name\": \"Alicja\",\n  \"age\": 11,\n  \"addressCity\": \"Warszawa\",\n  \"addressPostCode\": \"00-001\",\n  \"addressStreet\": \"Marszałkowska 123\"\n}");

        Request request = new Request.Builder()
                .url("http://localhost:8080/api/person")
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("accept", "application/json")
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
        System.out.println(response.headers().names());

        System.out.println(response.header("Location"));

        Request request2 = new Request.Builder()
                .url(response.header("Location"))
                .get()
                .addHeader("content-type", "application/json")
                .addHeader("accept", "application/json")
                .addHeader("cache-control", "no-cache")
                .build();

        Response response2 = client.newCall(request2).execute();
        System.out.println(response2.body().string());

    }
}
