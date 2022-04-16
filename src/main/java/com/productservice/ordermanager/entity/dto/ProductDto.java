package com.productservice.ordermanager.entity.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class ProductDto {

    private int productId;
    private String name;
    private String description;
    private Long stock_count;
}
