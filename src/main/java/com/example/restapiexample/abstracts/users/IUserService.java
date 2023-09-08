package com.example.restapiexample.abstracts.users;

import com.example.restapiexample.database.entities.User;
import com.example.restapiexample.errors.ServiceException;

import java.util.List;

public interface IUserService {
    List<User> getUsers();
    User getUser(int id) throws ServiceException;
    boolean isExisted(CreateUserDTO dto);
    User createUser(CreateUserDTO dto) throws ServiceException;
    User updateUser(int id, UpdateUserDTO dto) throws ServiceException;
    User deleteUser(int id) throws ServiceException;
}
