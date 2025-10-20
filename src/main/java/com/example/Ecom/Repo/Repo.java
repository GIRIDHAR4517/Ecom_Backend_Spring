package com.example.Ecom.Repo;

import com.example.Ecom.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Product , Integer> {
}
