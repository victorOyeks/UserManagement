package com.example.weeseventask.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table (name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45, name = "email")
    @NotEmpty (message = "E-mail is required")
    private String email;

    @Column(length = 15, nullable = false, name = "password")
    @NotEmpty(message = "Password is required")
    @Size(min = 6, max = 20, message = "Password length must be between 6 and 20 characters")
    private String password;

    @Column(length = 45, nullable = false, name = "first_Name")
    @NotEmpty (message = "First name is required")
    private String firstName;

    @Column(length = 45, nullable = false, name = "last_Name")
    @NotEmpty (message = "Last name is required")
    private String lastName;


    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public User() {
    }

    public boolean checkPassword(String password){
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}


