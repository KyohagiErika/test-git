package com.example.restapiexample.database.repositories;

import com.example.restapiexample.database.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
