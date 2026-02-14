package br.com.bibliotechApp.exception.handler;

import br.com.bibliotechApp.exception.ExceptionResponse;
import br.com.bibliotechApp.exception.ResourceNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> resourceNotFoundExceptionHandler(Exception e, WebRequest request) {
        ExceptionResponse response =  new ExceptionResponse(
                new Date(),
                e.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<ExceptionResponse> ConstraintViolationExceptionHandler(Exception e, WebRequest request) {
        ExceptionResponse response =  new ExceptionResponse(
                new Date(),
                e.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception e, WebRequest request) {
        ExceptionResponse response =  new ExceptionResponse(
                new Date(),
                e.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
