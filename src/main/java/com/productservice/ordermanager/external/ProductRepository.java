package com.productservice.ordermanager.external;


import com.productservice.ordermanager.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Object findAllByName(String name);
}
