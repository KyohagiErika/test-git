package com.example.restapiexample.errors;

import java.util.List;

public class RequestValidationError extends AppError {
    private List<String> validationMessages;

    public List<String> getValidationMessages() {
        return validationMessages;
    }

    public void setValidationMessages(List<String> validationMessages) {
        this.validationMessages = validationMessages;
    }

    public RequestValidationError(List<String> validationMessages) {
        super("Validation error");
        this.validationMessages = validationMessages;
    }
}
