package com.example.lap11_blog.Service;


import com.example.lap11_blog.Api.ApiException;
import com.example.lap11_blog.Model.Post;
import com.example.lap11_blog.Model.User;
import com.example.lap11_blog.Repository.PostRepository;
import com.example.lap11_blog.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public void addPost(Post post){
        User u = userRepository.findById(post.getUser_id());

        if(u == null){
            throw new ApiException("user not found");
        }


        postRepository.save(post);
    }

    public void updatePost( int id , Post post ){

        User u = userRepository.findById(post.getUser_id());

        if(u == null){
            throw new ApiException("user not found");
        }

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
