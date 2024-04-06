package org.spring.customermanagementapplication.customermanagementapplication.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
