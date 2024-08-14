package com.example.lap11_blog.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor


public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(columnDefinition = "int not null ")
    private int category_id;
    @Column(columnDefinition = "varchar(20) not null ")
    private String title;
    @Column(columnDefinition = "varchar(100) not null ")
    private String content;
    @Column(columnDefinition = "int not null ")
    private int user_id;
    @Column(columnDefinition = "datetime")
    private LocalDate publish_date;


}
