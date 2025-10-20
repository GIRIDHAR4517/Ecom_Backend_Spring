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

    public  Product addProduct(Product product){
        return repo.save(product);
    }

    public boolean deleteProduct(int id) {
       Product pro = repo.findById(id).orElse(null);
       if(pro !=null){
           repo.deleteById(id);
           return true;
       }
       return false;
    }
}
