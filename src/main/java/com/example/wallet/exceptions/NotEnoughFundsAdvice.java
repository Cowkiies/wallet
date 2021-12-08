package com.example.wallet.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotEnoughFundsAdvice {

    @ResponseBody
    @ExceptionHandler(NotEnoughFundsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String notEnoughFundsHandler(NotEnoughFundsException ex) {
        return ex.getMessage();
    }
}
