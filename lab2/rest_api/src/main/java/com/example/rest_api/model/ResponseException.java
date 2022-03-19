package com.example.rest_api.model;

public class ResponseException extends Exception{
    private String code;

    public ResponseException(String code, String message) {
        super(message);
        this.setCode(code);
    }

    public ResponseException (String code, String message, Throwable cause) {
        super(message, cause);
        this.setCode(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

