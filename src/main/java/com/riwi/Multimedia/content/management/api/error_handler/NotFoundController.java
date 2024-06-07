package com.riwi.Multimedia.content.management.api.error_handler;

import com.riwi.Multimedia.content.management.api.dto.error.BaseErrorResponse;
import com.riwi.Multimedia.content.management.api.dto.error.ErrorResponse;
import com.riwi.Multimedia.content.management.util.exeptions.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundController {


    @ExceptionHandler(IdNotFoundException.class)
    public BaseErrorResponse handleIdNotFound(IdNotFoundException ex){

        return ErrorResponse.builder()
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.name())
                .code(HttpStatus.NO_CONTENT.value())
                .build();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public BaseErrorResponse handleInternalServerError(Exception ex){
        return ErrorResponse.builder()
                .message("Check your url. " + ex.getMessage())
                .status(HttpStatus.NOT_EXTENDED.name())
                .code(HttpStatus.NO_CONTENT.value())
                .build();
    }
}
