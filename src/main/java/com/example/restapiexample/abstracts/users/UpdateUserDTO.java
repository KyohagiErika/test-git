package com.example.restapiexample.abstracts.users;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

public class UpdateUserDTO {
    @NotNull(message = "Name is required")
    private String name;

    @Nullable
    private String hobby;

    @NotNull(message = "Age is required")
    @Range(min = 1, max = 120, message = "Age must be from 1 to 120")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
