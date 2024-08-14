package com.example.lap11_blog.Repository;

import com.example.lap11_blog.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    Post findById(int id);

    @Query("select p from Post p where p.user_id=?1")
    List<Post> getByUserId(int user_id);

    @Query("select p from Post p where p.category_id=?1")
    List<Post> getByCategoryId(int category_id);

    @Query("select p from Post p where p.publish_date > ?1 ")
    List<Post> afterDate(LocalDate publish_date);



}
