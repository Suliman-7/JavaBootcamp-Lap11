package com.example.lap11_blog.Service;


import com.example.lap11_blog.Api.ApiException;
import com.example.lap11_blog.Model.Post;
import com.example.lap11_blog.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public void addPost(Post post){
        postRepository.save(post);
    }

    public void updatePost( int id , Post post ){

        Post post1 = postRepository.findById(id);

        if(post1 == null){
            throw new ApiException("post not found");
        }

        post1.setTitle(post.getTitle());
        post1.setContent(post.getContent());
        post1.setCategory_id(post.getCategory_id());
        post1.setPublish_date(post.getPublish_date());
        post1.setUser_id(post.getUser_id());
        postRepository.save(post1);

    }


    public void deletePost(int id){
        Post post = postRepository.findById(id);
        if(post == null){
            throw new ApiException("post not found");
        }
        postRepository.delete(post);
    }

    public List<Post> getPostsByUserId(int userId){
        List<Post> postl = postRepository.getByUserId(userId);
        if(postl.isEmpty()){
            throw new ApiException("post not found");
        }
        return postl;
    }

    public List<Post> getPostByCategoryId(int category_id){
        List<Post> postl = postRepository.getByCategoryId(category_id);
        if(postl.isEmpty()){
            throw new ApiException("post not found");
        }
        return postl;
    }

    public List<Post> afterDate(LocalDate date){
        List<Post> postl = postRepository.afterDate(date);
        if(postl.isEmpty()){
            throw new ApiException("post not found");
        }
        return postl;
    }
}
