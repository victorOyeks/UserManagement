package com.example.weeseventask.serviceImpl;

import com.example.weeseventask.DTO.ProductDTO;
import com.example.weeseventask.model.Product;
import com.example.weeseventask.model.User;
import com.example.weeseventask.repositories.ProductRepository;
import com.example.weeseventask.repositories.UserRepository;
import com.example.weeseventask.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {


    private Map<Integer, Integer> cart;
    private ProductRepository productRepository;
    private UserRepository userRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public ProductServiceImpl() {
        this.cart = new HashMap<>();
    }

    @Override
    public Product saveProduct(ProductDTO productDTO, Long id) {
        Product product = new Product(productDTO);
        User user = userRepository.findById(id).get();
        product.setUser(user);
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAllByUserId(Long id) {
        return productRepository.findByUserId(id);
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList =  productRepository.findAll();
        return productList;
    }

    @Override
    public void addToCart(ProductDTO productDTO) {
        if (productDTO < 1) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        if (cart.containsKey(productId)) {
            int currentQuantity = cart.get(productId);
            cart.put(productId, currentQuantity + quantity);
        } else {
            cart.put(productId, quantity);
        }
    }
}
