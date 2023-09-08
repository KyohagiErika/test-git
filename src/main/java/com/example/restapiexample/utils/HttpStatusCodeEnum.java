package com.example.restapiexample.utils;

public enum HttpStatusCodeEnum {
    OK(200),
    BAD_REQUEST(400);

    private int value;

    public int getValue() {
        return value;
    }

    HttpStatusCodeEnum(int value) {
        this.value = value;
    }
}
