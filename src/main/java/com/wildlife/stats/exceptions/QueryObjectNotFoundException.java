package com.wildlife.stats.exceptions;

import jakarta.persistence.EntityNotFoundException;


public class QueryObjectNotFoundException extends EntityNotFoundException {

    public QueryObjectNotFoundException(String message) {
        super(message);
    }
}
