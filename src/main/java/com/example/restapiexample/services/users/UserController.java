package com.example.restapiexample.services.users;

import com.example.restapiexample.abstracts.users.CreateUserDTO;
import com.example.restapiexample.abstracts.users.UpdateUserDTO;
import com.example.restapiexample.database.entities.User;
import com.example.restapiexample.errors.BadRequestException;
import com.example.restapiexample.abstracts.users.IUserService;
import com.example.restapiexample.abstracts.users.IUserController;
import com.example.restapiexample.errors.AppError;
import com.example.restapiexample.errors.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements IUserController {
    @Autowired
    IUserService userService;

    @Override
    public List<User> getUsers() {
        List<User> users = userService.getUsers();
        return users;
    }

    @Override
    public User getUser(int id) throws ServiceException {
        User user = userService.getUser(id);
        return user;
    }

    @Override
    public User createUser(CreateUserDTO dto) throws ServiceException {
        User user = userService.createUser(dto);
        return user;
    }

    @Override
    public User updateUser(int id, UpdateUserDTO dto) throws ServiceException {
        User user = userService.updateUser(id, dto);
        return user;
    }

    @Override
    public User deleteUser(int id) throws ServiceException {
        User user = userService.deleteUser(id);
        return user;
    }
}
