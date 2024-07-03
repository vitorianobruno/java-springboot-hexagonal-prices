package com.project.prices.domain.exceptions;

public class ConflictException extends RuntimeException {

    public ConflictException(String detail) {
        super(detail);
    }

}
