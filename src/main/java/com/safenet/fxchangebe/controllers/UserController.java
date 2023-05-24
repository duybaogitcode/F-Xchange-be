package com.safenet.fxchangebe.controllers;


import com.safenet.fxchangebe.dto.UserDTO;
import com.safenet.fxchangebe.entities.Information;
import com.safenet.fxchangebe.entities.Role;
import com.safenet.fxchangebe.entities.User;
import com.safenet.fxchangebe.exceptions.UserException;
import com.safenet.fxchangebe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String id, @RequestBody User user) throws Exception {
        return ResponseEntity.ok(userService.updateUserInfo(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler
    public ResponseEntity<String> handleUserNotFound(UserException e) {
        return ResponseEntity.notFound().build();
    }

    @QueryMapping
    public User getUserById(@Argument String id) {
        return userService.getUser(id);
    }

    @SchemaMapping
    public Information information(User user) {
        return user.getInformations();
    }

    @SchemaMapping
    public Role role(User user) {
        return user.getRole();
    }
}
