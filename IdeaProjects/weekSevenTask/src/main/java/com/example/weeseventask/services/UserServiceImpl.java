//package com.example.weeseventask.services;
//
//import com.example.weeseventask.model.User;
//import com.example.weeseventask.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Override
//	public void saveUser(User user) {
//		userRepository.save(user);
//	}
//
//	@Override
//	public boolean checkExist(String email) {
//		return userRepository.existsById(email);
//	}
//
//}
