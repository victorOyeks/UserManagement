package com.example.weeseventask.controllers;

import com.example.weeseventask.DTO.UserDTO;
import com.example.weeseventask.model.Product;
import com.example.weeseventask.model.User;
import com.example.weeseventask.services.ProductService;
import com.example.weeseventask.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @GetMapping("/index")
    public String showIndexPage() {
        return "index";
    }

    @GetMapping("/user/new")
    public  String showNewForm (Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Register");
        return  "register";
    }

    @PostMapping("/users/save")
    public String saveUser(@ModelAttribute("user") UserDTO userDTO) {
        userService.save(userDTO);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("user", new UserDTO());
        return modelAndView;
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") UserDTO userDTO, HttpServletRequest httpServletRequest, Model model){
        User user = userService.findUser(userDTO);
        if (user==null || !user.getPassword().equals(userDTO.getPassword())){
            return "login";
        }
        HttpSession session = httpServletRequest.getSession();
        Long id = user.getId();
        session.setAttribute("email", id);
        List<Product> productList = productService.findAllByUserId(id);
        if(productList==null){
            productList = new ArrayList<>();
        }
        model.addAttribute("products", productList);
        return "home";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        session.removeAttribute("email");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("user", new UserDTO());
        return modelAndView;
    }

}
