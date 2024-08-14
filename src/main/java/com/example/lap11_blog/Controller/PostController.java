package com.example.lap11_blog.Controller;

import com.example.lap11_blog.Model.Post;
import com.example.lap11_blog.Service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/get")
    public ResponseEntity getAllPosts() {
        return ResponseEntity.status(200).body(postService.getAllPost());
    }

    @PostMapping("/post")
    public ResponseEntity addPost(@Valid @RequestBody Post post , Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        postService.addPost(post);
        return ResponseEntity.status(200).body("post added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePost(@PathVariable Integer id, @Valid @RequestBody Post post , Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        postService.updatePost(id, post);
        return ResponseEntity.status(200).body("post updated successfully");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        postService.deletePost(id);
        return ResponseEntity.status(200).body("post deleted successfully");
    }

    @GetMapping("getbyuserid/{userid}")
    public ResponseEntity getPostByUserid(@PathVariable Integer userid) {
        return ResponseEntity.status(200).body(postService.getPostsByUserId(userid));
    }

    @GetMapping("getbycategoryid/{categoryid}")
    public ResponseEntity getPostByCategoryId(@PathVariable Integer categoryid) {
        return ResponseEntity.status(200).body(postService.getPostByCategoryId(categoryid));
    }

    @GetMapping("afterdate/{date}")
    public ResponseEntity getPostAfterDate(@PathVariable LocalDate date) {
        List<Post> lp = postService.afterDate(date);
        return ResponseEntity.status(200).body(lp);
    }




}
