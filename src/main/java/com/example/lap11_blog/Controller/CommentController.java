package com.example.lap11_blog.Controller;


import com.example.lap11_blog.Model.Comment;
import com.example.lap11_blog.Service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("api/v1/comment")
@RequiredArgsConstructor


public class CommentController {

    private final CommentService commentService;

    @GetMapping("/get")
    public ResponseEntity getAllComment(){
        return ResponseEntity.status(200).body(commentService.getAllComment());
    }

    @PostMapping("/post")
    public ResponseEntity postComment(@Valid @RequestBody Comment comment , Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        commentService.addComment(comment);
        return ResponseEntity.status(200).body("comment added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateComment(@PathVariable Integer id , @Valid @RequestBody Comment comment , Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        commentService.updateComment(id,comment);
        return ResponseEntity.status(200).body("comment updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteComment(@PathVariable Integer id){
        commentService.deleteComment(id);
        return ResponseEntity.status(200).body("comment deleted successfully");
    }

    @GetMapping("/beforedate/{date}")
    public ResponseEntity getCommentBefore(@PathVariable LocalDate date){
        List<Comment> ls = commentService.getBeforeDate(date);
        return ResponseEntity.status(200).body(ls);
    }

    @GetMapping("/byuserid/{user_id}")
    public ResponseEntity getCommentByUserId(@PathVariable Integer user_id){
        List<Comment> ls = commentService.getByUserId(user_id);
        return ResponseEntity.status(200).body(ls);
    }

    @GetMapping("bypostid/{post_id}")
    public ResponseEntity getCommentPostId(@PathVariable Integer post_id){
        List<Comment> ls = commentService.getByPostId(post_id);
        return ResponseEntity.status(200).body(ls);
    }

}
