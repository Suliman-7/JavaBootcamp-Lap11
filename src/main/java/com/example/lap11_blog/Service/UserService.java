package com.example.lap11_blog.Service;

import com.example.lap11_blog.Api.ApiException;
import com.example.lap11_blog.Model.User;
import com.example.lap11_blog.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(int id , User user) {
        User u = userRepository.findById(id);

        if (u == null) {
            throw new ApiException("User not found");
        }
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());
        u.setRegistration_date(user.getRegistration_date());
        userRepository.save(u);

    }

    public void deleteUser(int id) {
        User u = userRepository.findById(id);
        if (u == null) {
            throw new ApiException("User not found");
        }
        userRepository.delete(u);
    }



    public User getByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new ApiException("User not found");
        }
        return user;
    }

    public User getByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new ApiException("User not found");
        }
        return user;
    }













}
