package com.example.restapiexample.errors;

public class ServiceException extends AppException {
    public ServiceException(AppError error) {
        super(error);
    }
}
