/**
 * Copyright 2015-09-24 the original author or authors.
 */
package pl.com.softproject.ws.rest.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class HttpEntityUtil {

    public static <T> ResponseEntity<T> ok(final T body) {
        return ResponseEntity.ok(body);
    }

    public static ResponseEntity<?> ok() {
        return ResponseEntity.ok().build();
    }

    public static ResponseEntity<?> notFound() {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public static <T> ResponseEntity<T> responseEntity(final T body) {

        if(body != null) {
            return ok(body);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    public static URI uri(String path, Object... params) {

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(params).toUri();

        return uri;
    }

}
