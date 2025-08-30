package com.Hackout.config;


public class ApiCallException extends RuntimeException {
    public ApiCallException(String message, Throwable cause) {
        super(message, cause);
    }
}