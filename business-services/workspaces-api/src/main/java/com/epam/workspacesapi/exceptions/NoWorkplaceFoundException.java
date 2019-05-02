package com.epam.workspacesapi.exceptions;

public class NoWorkplaceFoundException extends RuntimeException {

    public NoWorkplaceFoundException() {
    }

    public NoWorkplaceFoundException(String message) {
        super(message);
    }
}
