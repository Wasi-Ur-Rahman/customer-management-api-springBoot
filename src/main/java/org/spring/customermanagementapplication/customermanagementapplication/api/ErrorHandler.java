package org.spring.customermanagementapplication.customermanagementapplication.api;

import org.spring.customermanagementapplication.customermanagementapplication.exception.ApplicationError;
import org.spring.customermanagementapplication.customermanagementapplication.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApplicationError> handleCustomerNotFoundException(CustomerNotFoundException exception, WebRequest webRequest) {
        ApplicationError error = new ApplicationError();
        error.setCode(101);
        error.setMessage(exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
