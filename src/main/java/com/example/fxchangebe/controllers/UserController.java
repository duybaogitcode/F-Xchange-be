package com.example.fxchangebe.controllers;


import com.example.fxchangebe.entities.Information;
import com.example.fxchangebe.entities.Role;
import com.example.fxchangebe.entities.User;
import com.example.fxchangebe.exceptions.UserException;
import com.example.fxchangebe.services.UserSerives;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserSerives userSerives;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userSerives.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return userSerives.getUser(id);
    }

    @GetMapping
    public List<User> getUsers() {
        return userSerives.getUsers();
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        return userSerives.updateUserInfo(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable ObjectId id) {
        userSerives.deleteUser(id);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleUserNotFound(UserException e) {
        return ResponseEntity.notFound().build();
    }

    @QueryMapping
    public User getUserById(@Argument String id){
        return getUser(id);
    }
    @SchemaMapping
    public Information information(User user){
        return user.getInformations();
    }
    @SchemaMapping
    public Role role(User user){
        return user.getRole();
    }
}
