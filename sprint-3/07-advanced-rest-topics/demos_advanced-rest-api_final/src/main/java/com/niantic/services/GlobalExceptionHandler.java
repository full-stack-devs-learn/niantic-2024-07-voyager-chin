package com.niantic.services;

import com.niantic.models.HttpError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request)
    {
        // check if this should be a 404 or 500 response
        if(ex instanceof ErrorResponse && ((ErrorResponse)ex).getStatusCode() == HttpStatus.NOT_FOUND)
        {
            // all 404 errors
            HttpError body = new HttpError(404, HttpStatus.NOT_FOUND.toString(), "The requested resource was not found.");
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
        else
        {
            // all other errors
            HttpError body = new HttpError(500, HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Something went wrong.");
            return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
