package com.angel.restexample.controller;

import com.angel.restexample.dto.ErrorDto;
import com.angel.restexample.exception.InputDataException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = InputDataException.class)
    public ResponseEntity<ErrorDto> handleException(final InputDataException e) {

        HttpHeaders headers = getHttpHeaders();

        final ErrorDto messageDTO = new ErrorDto();
        messageDTO.setMensaje(e.getMessage());
        return new ResponseEntity<>(messageDTO, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private static HttpHeaders getHttpHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
