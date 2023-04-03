package com.company.User;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
@Table (name ="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column (length = 15, nullable = false)
    private String password;

    @Column(length = 45, nullable = false, name = "firstName")
    private String FirstName;

    @Column(length = 45, nullable = false, name = "lastName")
    private String lastName;

    private boolean enabled;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
