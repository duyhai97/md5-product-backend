package com.example.testconnectbackend.controller;

import com.example.testconnectbackend.model.Product;
import com.example.testconnectbackend.repository.IProductRepository;
import com.example.testconnectbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;



    @GetMapping()
    public ResponseEntity<Iterable<Product>> findAll(){

        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> findByID(@PathVariable Long id){
        return new ResponseEntity<>( productService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> saveCategory(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateBlog(@PathVariable Long id, @RequestBody Product product){
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteBlog(@PathVariable Long id){
        productService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
