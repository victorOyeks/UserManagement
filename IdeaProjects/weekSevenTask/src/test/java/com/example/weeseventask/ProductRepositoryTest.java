//package com.example.weeseventask;
//
//import com.example.weeseventask.model.Product;
//import com.example.weeseventask.model.ProductRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//
//    @DataJpaTest
//    @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//    @Rollback(false)
//    public class ProductRepositoryTest {
//        @Autowired
//        private ProductRepository repo;
//
//        @Test
//        public void testAddNew() {
//            Product product = new Product();
//            product.setName("Sneakers");
//            product.setDescription("Upgrade your style with our premium sneakers. Order now and step up your shoe game!");
//            product.setPrice("1500");
//
//            Product savedProduct = repo.save(product);
//
//            Assertions.assertThat(savedProduct).isNotNull();
//            Assertions.assertThat(savedProduct.getId()).isGreaterThan(0);
//        }
//    }
