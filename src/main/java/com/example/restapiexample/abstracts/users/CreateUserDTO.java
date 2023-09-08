package com.example.restapiexample.abstracts.users;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class CreateUserDTO {
    @NotNull(message = "Username is required")
    @NotBlank(message = "Username is required")
    @Length(min = 6, max = 20, message = "Username must be from 6 to 20 characters")
    private String username;

    @NotNull(message = "Password is required")
    @NotBlank(message = "Password is required")
    //@Pattern(regexp = "")
    private String password;

    @NotNull(message = "Name is required")
    private String name;

    @Nullable
    private String hobby;

    @NotNull(message = "Age is required")
    @Range(min = 1, max = 120, message = "Age must be from 1 to 120")
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
