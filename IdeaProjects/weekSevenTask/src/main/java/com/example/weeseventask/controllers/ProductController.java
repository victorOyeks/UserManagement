package com.example.weeseventask.controllers;

import com.example.weeseventask.DTO.ProductDTO;
import com.example.weeseventask.services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {


    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ModelAndView homePageWithMV(ModelAndView modelAndView, HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("email")==null){
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }
        modelAndView.setViewName("cart");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add-products")
    public String productForm(Model model, HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("email")==null){
            return "login";
        }
        model.addAttribute("product", new ProductDTO());
        return "add_product";
    }
    @PostMapping("/add-products")
    public String productForm(@ModelAttribute("product") ProductDTO product, HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("email")==null){
            return "login";
        }
        productService.saveProduct(product, (Long)session.getAttribute("email"));
        return "home";
    }
}



//package com.example.weeseventask.controllers;
//
//
//import com.example.weeseventask.model.Product;
//import com.example.weeseventask.model.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
//@Controller
//public class ProductController {
//    @Autowired private ProductService service;
//
//    @GetMapping("/home")
//    public  String showProductList(Model model) {
//        List<Product> listProducts = service.listAll();
//        model.addAttribute("listProducts", listProducts);
//        return "home";
//    }
//}
