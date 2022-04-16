package com.productservice.ordermanager.service;

import com.productservice.ordermanager.entity.Product;
import com.productservice.ordermanager.entity.dto.ProductDto;
import com.productservice.ordermanager.external.ProductRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService{

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ProductDto addProducts(ProductDto productDto){
        Product newProduct = convertToEntity(productDto);
        Product savedProduct=null;
        if(productRepository.findAllByName(newProduct.getName())!=null){
            logger.error("Product exist with the same name");
            return null;
        }
        try{
            savedProduct = productRepository.save(newProduct);
        }
        catch (Exception e){
            logger.error("Product save failed: "+e.getMessage());
        }

        return convertToDto(savedProduct);
    }

    public List<ProductDto> getAllProducts(){
        List<Product> products= productRepository.findAll();
        List<ProductDto> productsDto = new ArrayList<>();
        for(Product product:products){
            productsDto.add(convertToDto(product));
        }
        return productsDto;
    }

    public ProductDto getProduct(int id){
        Product product = new Product();
        try{
            product = productRepository.getById(id);
        }
        catch (EntityNotFoundException e){
            logger.error("Product id not found: "+id);
        }
        return convertToDto(product);
    }

    public void deleteProduct(int id){
        productRepository.deleteById(id);
        logger.info("Delete product with product id: "+id);
    }


    private ProductDto convertToDto(Product product){
        ProductDto productDto = modelMapper.map(product,ProductDto.class);
        return productDto;
    }

    private Product convertToEntity(ProductDto productDto){
        Product product = modelMapper.map(productDto,Product.class);
        return product;
    }



}
