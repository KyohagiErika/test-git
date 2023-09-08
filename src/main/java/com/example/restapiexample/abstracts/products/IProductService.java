package com.example.restapiexample.abstracts.products;

import com.example.restapiexample.database.entities.Product;
import com.example.restapiexample.errors.ServiceException;

import java.util.List;

public interface IProductService {
    List<Product> getProducts();
    Product createProduct(CreateProductDTO dto) throws ServiceException;
}
