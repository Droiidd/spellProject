package com.csc340.jpacruddemo.product;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sentini
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProduct(long productId) {
        return repo.getReferenceById(productId);
    }

    public void deleteProduct(long productId) {
        repo.deleteById(productId);
    }

    void saveProduct(Product product) {

        repo.save(product);
    }

}
