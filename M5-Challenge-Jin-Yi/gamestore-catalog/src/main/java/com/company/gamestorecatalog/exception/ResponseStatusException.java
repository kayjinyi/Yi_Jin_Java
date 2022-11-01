package com.company.gamestorecatalog.exception;

import org.springframework.http.HttpStatus;

public class ResponseStatusException extends RuntimeException {
    public ResponseStatusException() {
        super();
    }

    public ResponseStatusException(HttpStatus notFound, String s){
        super(s);
    }

    public ResponseStatusException(String message) {
        super(message);
    }
}
