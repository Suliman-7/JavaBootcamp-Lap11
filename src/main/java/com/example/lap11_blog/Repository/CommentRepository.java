package com.example.lap11_blog.Repository;

import com.example.lap11_blog.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    Comment findById(int id);

    @Query("select c from Comment c where c.comment_date <= ?1" )
    List<Comment> findCommentByDate(LocalDate date);

    @Query("select c from Comment c where c.user_id = ?1 ")
    List<Comment> getByUserId(int userId);

    @Query("select c from Comment c where c.post_id = ?1 ")
    List<Comment> getByPostId(int postId);



}
