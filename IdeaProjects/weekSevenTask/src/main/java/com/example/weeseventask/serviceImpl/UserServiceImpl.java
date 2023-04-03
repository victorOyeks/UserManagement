package com.example.weeseventask.serviceImpl;

import com.example.weeseventask.DTO.UserDTO;
import com.example.weeseventask.model.User;
import com.example.weeseventask.repositories.UserRepository;
import com.example.weeseventask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserDTO userDTO) {
        User user = new User(userDTO.getEmail(), userDTO.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User findUser(UserDTO userDTO) {
        User user =  userRepository.findByEmail(userDTO.getEmail()).get();
//        TODO:EXPLAIN REASON FOR ERROR WITH HASHING
        boolean match = user.checkPassword(userDTO.getPassword());
        if (match){
            return user;
        }
        return null;
    }
}
