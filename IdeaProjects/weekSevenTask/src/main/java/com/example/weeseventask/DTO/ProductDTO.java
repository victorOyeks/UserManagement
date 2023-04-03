package com.example.weeseventask.DTO;

import com.example.weeseventask.model.Category;
import com.example.weeseventask.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductDTO {
    private String productName;
    private Category category;
    private BigDecimal price;
    public ProductDTO(Product product) {
        this.productName = product.getName();
        this.category = product.getCategory();
        this.price =  product.getPrice();
    }

}
