package com.example.Ecom.Services;

import com.example.Ecom.Model.Product;
import com.example.Ecom.Repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

   private Repo repo;

   @Autowired
    public ProductService(Repo repo) {
        this.repo = repo;
    }

    public List<Product> getProduct() {
       return repo.findAll();
    }

    public Product getProductById(int id) {
       return repo.findById(id).orElse(null);
    }

    public  void addProduct(Product product){
       repo.save(product);
    }
}
