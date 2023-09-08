package com.example.restapiexample.abstracts.users;

import com.example.restapiexample.database.entities.User;
import com.example.restapiexample.errors.BadRequestException;
import com.example.restapiexample.errors.ServiceException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
public interface IUserController {
    @GetMapping("/")
    List<User> getUsers();

    @GetMapping("/{id}")
    User getUser(@PathVariable int id) throws ServiceException;

    @PostMapping("/")
    User createUser(@RequestBody @Valid CreateUserDTO dto) throws ServiceException;

    @PutMapping("/{id}")
    User updateUser(@PathVariable int id, @RequestBody @Valid UpdateUserDTO dto) throws ServiceException;

    @DeleteMapping("/{id}")
    User deleteUser(@PathVariable int id) throws ServiceException;
}
