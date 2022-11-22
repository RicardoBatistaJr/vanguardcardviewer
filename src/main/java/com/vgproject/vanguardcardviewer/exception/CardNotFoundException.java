package com.vgproject.vanguardcardviewer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CardNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public static final String message = "Card não encontrado na nossa base de dados";
    public CardNotFoundException(){
        super(message);
    }
}
