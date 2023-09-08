package com.example.restapiexample.services.products;

import com.example.restapiexample.abstracts.products.CreateProductDTO;
import com.example.restapiexample.abstracts.products.IProductController;
import com.example.restapiexample.abstracts.products.IProductService;
import com.example.restapiexample.database.entities.Product;
import com.example.restapiexample.errors.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController implements IProductController {
    @Autowired
    private IProductService productService;

    @Override
    public List<Product> getProducts() {
        List<Product> products = productService.getProducts();
        return products;
    }

    @Override
    public Product createProduct(CreateProductDTO dto) throws ServiceException {
        Product product = productService.createProduct(dto);
        return product;
    }
}
