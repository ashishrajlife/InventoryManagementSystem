package com.managementsystem.Service;

import com.managementsystem.Entity.Product;
import com.managementsystem.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    // public Product updateProduct(Product product) {
    //     Product existingProduct = repository.findById(product.getId()).orElse(null);
    //     existingProduct.setName(product.getName());
    //     existingProduct.setQuantity(product.getQuantity());
    //     existingProduct.setPrice(product.getPrice());
    //     return repository.save(existingProduct);
    // }

    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElseThrow(() -> 
            new RuntimeException("Product with ID " + product.getId() + " not found.")
        );
    
        // Update only the fields you want to allow changing
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        
        return repository.save(existingProduct);
    }
    


}