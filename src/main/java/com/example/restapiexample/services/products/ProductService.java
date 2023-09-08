package com.example.restapiexample.services.products;

import com.example.restapiexample.abstracts.products.CreateProductDTO;
import com.example.restapiexample.abstracts.products.IProductService;
import com.example.restapiexample.abstracts.users.IUserService;
import com.example.restapiexample.database.entities.Product;
import com.example.restapiexample.database.entities.User;
import com.example.restapiexample.database.repositories.ProductRepository;
import com.example.restapiexample.errors.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private IUserService userService;

    @Override
    public List<Product> getProducts() {
        List<Product> products = productRepo.findAll();
        return products;
    }

    @Override
    public Product createProduct(CreateProductDTO dto) throws ServiceException {
        User owner = userService.getUser(dto.getOwnerId());
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setOwner(owner);
        productRepo.save(product);
        return product;
    }
}
