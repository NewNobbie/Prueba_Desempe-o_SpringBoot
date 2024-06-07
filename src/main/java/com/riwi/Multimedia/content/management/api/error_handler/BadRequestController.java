package com.riwi.Multimedia.content.management.api.error_handler;


import com.riwi.Multimedia.content.management.api.dto.error.BaseErrorResponse;
import com.riwi.Multimedia.content.management.api.dto.error.ErrorResponse;
import com.riwi.Multimedia.content.management.api.dto.error.ErrorsResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestController {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public BaseErrorResponse handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        return ErrorResponse.builder
                        ()
                .message("There is a unique field that cannot be repeated [Lesson: title].")
                .status(HttpStatus.BAD_REQUEST.name())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    public BaseErrorResponse handleJsonParseException(HttpMessageConversionException ex) {
        return ErrorResponse.builder
                        ()
                .message("Check your Json format. " + ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.name())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public BaseErrorResponse handleIllegalArgumentException(IllegalArgumentException ex) {
        return ErrorResponse.builder
                        ()
                .message("Invalid value for enum: " + ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.name())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorResponse handleErrors(MethodArgumentNotValidException ex){

        List<String> errors = new ArrayList<>();

        ex.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));

        return ErrorsResponse.builder
                ()
                .errors(errors)
                .status(HttpStatus.BAD_REQUEST.name())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    /*public BaseErrorResponse handleIdNotFound(OptionsAreNullexception)*/






}
