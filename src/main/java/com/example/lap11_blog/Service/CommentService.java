package com.example.lap11_blog.Service;

import com.example.lap11_blog.Api.ApiException;
import com.example.lap11_blog.Model.Comment;
import com.example.lap11_blog.Model.Post;
import com.example.lap11_blog.Model.User;
import com.example.lap11_blog.Repository.CommentRepository;
import com.example.lap11_blog.Repository.PostRepository;
import com.example.lap11_blog.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;


    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    public void addComment(Comment comment){

        User u = userRepository.findById(comment.getUser_id());
        Post p = postRepository.findById(comment.getPost_id());

        if(u==null){
            throw new ApiException("user not exist");
        }

        if(p==null){
            throw new ApiException("post not exist");
        }


        commentRepository.save(comment);
    }

    public void updateComment( int id , Comment comment){

        User u = userRepository.findById(comment.getUser_id());
        Post p = postRepository.findById(comment.getPost_id());

        if(u==null){
            throw new ApiException("user not exist");
        }

        if(p==null){
            throw new ApiException("post not exist");
        }


        Comment c = commentRepository.findById(id);
        if(c == null){
            throw new ApiException("comment not exist");
        }
        c.setComment_date(comment.getComment_date());
        c.setContent(comment.getContent());
        c.setPost_id(comment.getPost_id());
        c.setUser_id(comment.getUser_id());
        commentRepository.save(c);
    }

    public void deleteComment(int id){
        Comment c = commentRepository.findById(id);
        if(c == null){
            throw new ApiException("comment not exist");
        }

        commentRepository.delete(c);
    }

    public List<Comment> getBeforeDate(LocalDate date){
        List<Comment> ls = commentRepository.findCommentByDate(date);
        if(ls.isEmpty()){
            throw new ApiException("comment not exist");
        }
        return ls;
    }

    public List<Comment> getByUserId(int userId){
        List<Comment> ls = commentRepository.getByUserId(userId);
        if(ls.isEmpty()){
            throw new ApiException("comment not exist");
        }
        return ls;
    }

    public List<Comment> getByPostId(int post_id){
        List<Comment> ls = commentRepository.getByPostId(post_id);
        if(ls.isEmpty()){
            throw new ApiException("comment not exist");
        }
        return ls;
    }
}
