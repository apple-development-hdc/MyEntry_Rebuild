package com.myentry.MyEntry.Handlers;

import lombok.extern.slf4j.Slf4j;

/**
 * Author :SAURAV ROY
 */
@Slf4j
public class AppExceptionHandler extends RuntimeException {

    private  String message;


    public AppExceptionHandler(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        log.error("Application Level Error");
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}