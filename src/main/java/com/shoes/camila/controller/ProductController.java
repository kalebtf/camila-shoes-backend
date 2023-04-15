package com.shoes.camila.controller;

import com.shoes.camila.model.Product;
import com.shoes.camila.repository.ProductRepository;
import com.shoes.camila.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StorageService storageService;

    // Implement CRUD endpoints (GET, POST, PUT, DELETE)

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestParam("file") MultipartFile file, @RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("price") String price) {
        String imageUrl = storageService.store(file);
        Product product = new Product(name, description, imageUrl, price);
        Product savedProduct = productRepository.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

}
