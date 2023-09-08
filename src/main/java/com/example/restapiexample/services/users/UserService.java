package com.example.restapiexample.services.users;

import com.example.restapiexample.abstracts.users.CreateUserDTO;
import com.example.restapiexample.abstracts.users.UpdateUserDTO;
import com.example.restapiexample.database.entities.User;
import com.example.restapiexample.database.repositories.UserRepository;
import com.example.restapiexample.abstracts.users.IUserService;
import com.example.restapiexample.errors.AppError;
import com.example.restapiexample.errors.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<User> getUsers() {
        List<User> users = userRepo.findAll();
        return users;
    }

    @Override
    public User getUser(int id) throws ServiceException {
        User user = null;
        Optional<User> findResult = userRepo.findById(id);
        if (findResult.isPresent()) {
            user = findResult.get();
        } else {
            throw new ServiceException(new AppError("User not found"));
        }
        return user;
    }

    @Override
    public boolean isExisted(CreateUserDTO dto) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnorePaths("id")
                .withMatcher("username", (config) -> {
                    config.exact();
                });
        User testUser = new User();
        testUser.setUsername(dto.getUsername());
        Example<User> userExample = Example.of(testUser, matcher);
        return userRepo.exists(userExample);
    }

    @Override
    public User createUser(CreateUserDTO dto) throws ServiceException {
        User user = null;
        if (!isExisted(dto)) {
            user = new User();
            user.setName(dto.getName());
            user.setAge(dto.getAge());
            user.setUsername(dto.getUsername());
            user.setHobby(dto.getHobby());
            user.setPassword(dto.getPassword());
            user = userRepo.save(user);
        } else {
            throw new ServiceException(new AppError("User already existed"));
        }
        return user;
    }

    @Override
    public User updateUser(int id, UpdateUserDTO dto) throws ServiceException {
        User user = null;
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
            user.setName(dto.getName());
            user.setAge(dto.getAge());
            user.setHobby(dto.getHobby());
            user = userRepo.save(user);
        } else {
            throw new ServiceException(new AppError("User not found"));
        }
        return user;
    }

    @Override
    public User deleteUser(int id) throws ServiceException {
        User user = null;
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
            userRepo.delete(user);
        } else {
            throw new ServiceException(new AppError("User not found"));
        }
        return user;
    }
}
