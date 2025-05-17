package com.springstarter.first_rest_api.product.support.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id){
        super (String.format("Product with %d not found",id));
    }
}
