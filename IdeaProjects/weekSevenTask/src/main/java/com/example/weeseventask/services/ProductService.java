package com.example.weeseventask.services;

import com.example.weeseventask.DTO.ProductDTO;
import com.example.weeseventask.model.Product;

import java.util.List;

public interface ProductService {
 Product saveProduct(ProductDTO productDTO, Long id);

 List<Product> findAllByUserId(Long id);
 List<Product> findAll();

 void addToCart(int productId, int quantity);

}
