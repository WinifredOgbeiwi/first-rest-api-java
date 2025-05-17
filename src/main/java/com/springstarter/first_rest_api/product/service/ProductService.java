package com.springstarter.first_rest_api.product.service;

import com.springstarter.first_rest_api.product.api.request.ProductRequest;
import com.springstarter.first_rest_api.product.api.request.UpdateProductRequest;
import com.springstarter.first_rest_api.product.api.response.ProductResponse;
import com.springstarter.first_rest_api.product.domain.Product;
import com.springstarter.first_rest_api.product.respository.ProductRespository;
import com.springstarter.first_rest_api.product.support.ProductExceptionSupplier;
import com.springstarter.first_rest_api.product.support.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRespository productRespository;
    private final ProductMapper productMapper;

    public ProductService(ProductRespository productRespository, ProductMapper productMapper){
        this.productRespository = productRespository;
        this.productMapper = productMapper;
    }
    public ProductResponse create(ProductRequest productRequest){
        Product product = productRespository.save(productMapper.toProduct(productRequest));
        return productMapper.toProductResponse(product);
    }

    public ProductResponse find(Long id){
        Product product = productRespository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        return productMapper.toProductResponse(product);
    }

    public ProductResponse update(Long id, UpdateProductRequest updateProductRequest){
        Product product = productRespository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productRespository.save(productMapper.toProduct(product, updateProductRequest));
        return productMapper.toProductResponse(product);
    }

    public List<ProductResponse> findAll(){
        return productRespository.findAll().stream().map(productMapper::toProductResponse).collect(Collectors.toList());
    }

    public void delete (Long id){
        Product product = productRespository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productRespository.deleteById(product.getId());
    }


}
