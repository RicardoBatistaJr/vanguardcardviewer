package com.vgproject.vanguardcardviewer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ApiCallException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String message = "Ocorreu um erro durante a chamada da API";
    public ApiCallException(){
        super(message);
    }
}
