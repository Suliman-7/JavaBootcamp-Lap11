package com.example.lap11_blog.Repository;

import com.example.lap11_blog.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface UserRepository extends JpaRepository<User, Integer> {

     User findById(int id);

     User findByEmail(String Email);

     User findByUsername(String username);








}
