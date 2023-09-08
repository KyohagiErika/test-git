package com.example.restapiexample.abstracts.products;

import com.example.restapiexample.database.entities.Product;
import com.example.restapiexample.errors.ServiceException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/products")
public interface IProductController {
    @GetMapping("/")
    List<Product> getProducts();

    @PostMapping("/")
    Product createProduct(@RequestBody @Valid CreateProductDTO dto) throws ServiceException;
}
