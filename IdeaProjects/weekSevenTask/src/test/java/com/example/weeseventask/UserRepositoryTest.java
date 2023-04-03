//package com.example.weeseventask;
//
//import com.example.weeseventask.model.Product;
//import com.example.weeseventask.model.ProductRepository;
//import com.example.weeseventask.model.User;
//import com.example.weeseventask.model.UserRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
//public class UserRepositoryTest {
//    @Autowired
//    private UserRepository repo;
//
//    @Test
//    public void testAddNewUser() {
//        User user = new User();
//        user.setId(001);
//        user.setFirstName("Victor");
//        user.setLastName("Oyeks");
//        user.setEmail("oyeks@email.com");
//        user.setPassword("12345");
//
//        User savedUser = repo.save(user);
//
//        Assertions.assertThat(savedUser).isNotNull();
//        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
//    }
//
//    @Test
//    public void testListAll() {
//        Iterable<User> users = repo.findAll();
//        Assertions.assertThat(users).hasSizeGreaterThan(0);
//        for (User user : users) {
//            System.out.println(user);
//        }
//    }
//}
