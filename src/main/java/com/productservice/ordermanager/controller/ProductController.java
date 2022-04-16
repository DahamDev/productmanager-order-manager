package com.productservice.ordermanager.controller;

import com.productservice.ordermanager.entity.dto.ProductDto;
import com.productservice.ordermanager.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    //get product details by product id
    @GetMapping("/get/{id}")
    public ResponseEntity getProductsById(@PathVariable int id){
        logger.debug("Received get products request");
        ProductDto products = productService.getProduct(id);
        return ResponseEntity.ok().body(products);

    }

    //add / delete products
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return ResponseEntity.ok().body("Deleted product id: "+id);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
        logger.debug("Received add product request");
        ProductDto saved = productService.addProducts(productDto);
        return ResponseEntity.created(URI.create("/add")).body(saved);

    }

    @GetMapping("/get")
    public ResponseEntity getProducts(){
        logger.debug("Received get products request");
        List<ProductDto> products = productService.getAllProducts();
        return ResponseEntity.ok().body(products);

    }



}
