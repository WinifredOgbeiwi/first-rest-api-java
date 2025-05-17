package com.springstarter.first_rest_api.product.support;

import com.springstarter.first_rest_api.product.api.request.ProductRequest;
import com.springstarter.first_rest_api.product.api.request.UpdateProductRequest;
import com.springstarter.first_rest_api.product.api.response.ProductResponse;
import com.springstarter.first_rest_api.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toProduct(ProductRequest productRequest){
        return new Product(productRequest.getName());
    }

    public ProductResponse toProductResponse(Product product){
        return new ProductResponse(product.getId(), product.getName());
    }

    public Product toProduct(Product product, UpdateProductRequest updateProductRequest){
        product.setName(updateProductRequest.getName());
        return product;
    }
}
