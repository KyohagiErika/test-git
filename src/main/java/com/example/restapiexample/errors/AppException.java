package com.example.restapiexample.errors;

public class AppException extends Throwable {
    private AppError error;

    public AppError getError() {
        return error;
    }

    public void setError(AppError error) {
        this.error = error;
    }

    public AppException(AppError error) {
        this.error = error;
    }
}
