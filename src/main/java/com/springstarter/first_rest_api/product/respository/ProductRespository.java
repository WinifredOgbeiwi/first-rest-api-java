package com.springstarter.first_rest_api.product.respository;

import com.springstarter.first_rest_api.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ProductRespository extends JpaRepository<Product,Long> {

}
//    protected  final Map<Long, Product> map = new HashMap<>();
//    protected  long counter = 1;
//
//    public Product save(Product entity){
//    setId(entity);
//    return  entity;
//    }
//
//    private Product setId(Product entity){
//        if(entity.getId() != null){
//            map.put(entity.getId(),entity);
//        }
//        else {
//            entity.setId(counter);
//            map.put(counter,entity);
//            counter++;
//        }
//        return entity;
//    }
//
//    public Optional<Product> findById(Long id){
//        return Optional.ofNullable(map.get(id));
//    }
//
//    public List<Product> findAll(){
//        return  new ArrayList<>(map.values());
//    }
//
//    public void deleteById(Long id){
//        map.remove(id);
//    }

