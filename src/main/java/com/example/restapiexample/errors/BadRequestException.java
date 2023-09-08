package com.example.restapiexample.errors;

public class BadRequestException extends AppException {
    public BadRequestException(AppError error) {
        super(error);
    }
}
