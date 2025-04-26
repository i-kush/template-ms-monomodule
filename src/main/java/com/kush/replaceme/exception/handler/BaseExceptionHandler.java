package com.kush.replaceme.exception.handler;

import com.kush.replaceme.controller.dto.response.ErrorDto;
import com.kush.replaceme.controller.dto.response.ValidationFailedDto;
import com.kush.replaceme.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BaseExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(BaseExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handle(MethodArgumentNotValidException e) {
        List<ValidationFailedDto> validationResult = e
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ValidationFailedDto(error.getField(), error.getDefaultMessage()))
                .toList();
        log.error("Validation failed: {} ", validationResult, e);
        ErrorDto response = new ErrorDto(validationResult);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> handle(NotFoundException exception) {
        ErrorDto response = new ErrorDto(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handle(Exception e) {
        log.error("Unknown error", e);
        ErrorDto response = new ErrorDto(e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
