package com.example.restapiexample.errors;

public class AppError {
    private String message;

    public AppError(String message) {
        this.message = message;
    }

    public AppError() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
