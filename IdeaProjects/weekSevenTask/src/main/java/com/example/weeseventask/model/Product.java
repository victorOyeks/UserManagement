package com.example.weeseventask.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.example.weeseventask.DTO.ProductDTO;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;


@Entity
@Table (name ="product")

@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;

    @Column(length = 200, nullable = false)
    private String description;

    @Column(name = "image")
    private String imageUrl;

    @Column(name = "price")
    @NotNull
    private BigDecimal price;

    @Column(name = "status")
    @NotNull(message="Please, select the status of the product.")
    private boolean status = true;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Product(ProductDTO productDTO) {
        this.name = productDTO.getProductName();
        this.category = productDTO.getCategory();
        this.price =  productDTO.getPrice();
    }

    public Product() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;

        return id == product.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                '}';
    }
}
