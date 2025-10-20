package com.example.Ecom.Controllers;

import com.example.Ecom.Model.Product;
import com.example.Ecom.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String  greet(){
        return "Hello";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>( service.getProduct(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product pro = service.getProductById(id);
        if(pro!=null)
            return new ResponseEntity<>( pro ,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(service.addProduct(product) , HttpStatus.OK);

    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id){
       if( service.deleteProduct(id))
        return new ResponseEntity<>(HttpStatus.OK);
       else
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
