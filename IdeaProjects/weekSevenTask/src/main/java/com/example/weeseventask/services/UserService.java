package com.example.weeseventask.services;

import com.example.weeseventask.DTO.UserDTO;
import com.example.weeseventask.model.User;

public interface UserService {

    User save(UserDTO userDTO);
    User findUser(UserDTO userDTO);
}
