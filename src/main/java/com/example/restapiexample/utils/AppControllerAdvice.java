package com.example.restapiexample.utils;

import com.example.restapiexample.errors.AppError;
import com.example.restapiexample.errors.BadRequestException;
import com.example.restapiexample.errors.RequestValidationError;
import com.example.restapiexample.errors.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class AppControllerAdvice {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<AppError> badRequest(BadRequestException ex, HttpServletRequest req) {
        return new ResponseEntity<>(ex.getError(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AppError> validationFailed(MethodArgumentNotValidException ex, HttpServletRequest req) {
        List<String> errors = new ArrayList<>();
        for (ObjectError err : ex.getAllErrors()) {
            errors.add(err.getDefaultMessage());
        }
        RequestValidationError validationError = new RequestValidationError(errors);
        return badRequest(new BadRequestException(validationError), req);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<AppError> serviceError(ServiceException ex, HttpServletRequest req) {
        return badRequest(new BadRequestException(ex.getError()), req);
    }
}
