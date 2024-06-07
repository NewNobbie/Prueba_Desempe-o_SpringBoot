package com.riwi.Multimedia.content.management.api.error_handler;


import com.riwi.Multimedia.content.management.api.dto.error.BaseErrorResponse;
import com.riwi.Multimedia.content.management.api.dto.error.ErrorResponse;
import com.riwi.Multimedia.content.management.api.dto.error.ErrorsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalErrorServerController {

    @ExceptionHandler(CannotCreateTransactionException.class)
    public BaseErrorResponse handleCannotCreateTransactionException(CannotCreateTransactionException ex){
        return ErrorResponse.builder()
                .message("A transaction could not be opened fot the database. Please try again later.")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public BaseErrorResponse handleGlobalException(Exception ex){
        return ErrorResponse.builder()
                .message("An unexpected error ocurred: " + ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
    }


}
