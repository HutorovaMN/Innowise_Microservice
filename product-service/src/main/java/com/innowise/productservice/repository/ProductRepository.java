package com.innowise.productservice.repository;

import com.innowise.productservice.dto.ProductResponse;
import com.innowise.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository <Product,String>{

}
