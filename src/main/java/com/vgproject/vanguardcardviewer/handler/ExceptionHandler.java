package com.vgproject.vanguardcardviewer.handler;

import com.vgproject.vanguardcardviewer.exception.ApiCallException;
import com.vgproject.vanguardcardviewer.exception.CardNotFoundException;
import com.vgproject.vanguardcardviewer.exception.ExceptionResponse;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler
    extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class, ApiCallException.class})
    public final ResponseEntity<ExceptionResponse> handleInternalServerErrorException(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({CardNotFoundException.class, MethodArgumentTypeMismatchException.class})
    public final ResponseEntity<ExceptionResponse> handleBadRequest (Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
            request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}