package com.example.firebase.springbootfirebasedemo.controller;

import com.example.firebase.springbootfirebasedemo.model.model.Product;
import com.example.firebase.springbootfirebasedemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService ;

    @PostMapping("/products")
    public String saveProduct(@RequestBody Product product) throws ExecutionException, InterruptedException {
        return productService.saveProduct(product);
    }

    @PutMapping("/products")
    public String updateProduct(@RequestBody Product product) throws ExecutionException, InterruptedException {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/products/{name}")
    public String deleteProduct(@PathVariable("name") String name) throws ExecutionException, InterruptedException {
        return productService.deleteProduct(name);
    }


    @GetMapping("/products/{name}")
    public Product getProductByName(@PathVariable("name")String name) throws ExecutionException, InterruptedException {
        return productService.getProductDetailsByName(name);
    }


    @GetMapping("/products")
    public List<Product> getProductByName() throws ExecutionException, InterruptedException {
        return productService.getProductDetails();
    }
}
