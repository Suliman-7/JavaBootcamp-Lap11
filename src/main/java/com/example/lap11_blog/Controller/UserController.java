package com.example.lap11_blog.Controller;


import com.example.lap11_blog.Model.User;
import com.example.lap11_blog.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUsers() {
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping("/post")
    public ResponseEntity addUser(@Valid @RequestBody User user , Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("user added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @Valid @RequestBody User user , Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.updateUser(id, user);
        return ResponseEntity.status(200).body("user updated successfully");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body("user deleted successfully");

    }



    @GetMapping("byemail/{email}")
    public ResponseEntity findByEmail(@PathVariable String email) {
        User user = userService.getByEmail(email);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("byusername/{username}")
    public ResponseEntity findByUsername(@PathVariable String username) {
        User user = userService.getByUsername(username);
        return ResponseEntity.status(200).body(user);
    }






}
