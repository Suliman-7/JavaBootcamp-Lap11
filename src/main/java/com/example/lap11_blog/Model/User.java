package com.example.lap11_blog.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "username should be not empty")
    @Size(min = 5 , message = "name should be more than 4 characters")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String username;

    @NotEmpty(message = "password should be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @NotEmpty(message = "email should be not empty")
    @Email(message = "email should be formatted correctly")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;


    @Column(columnDefinition = "datetime")
    private LocalDate registration_date;
}
