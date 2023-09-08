package com.example.restapiexample.database.repositories;

import com.example.restapiexample.database.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
