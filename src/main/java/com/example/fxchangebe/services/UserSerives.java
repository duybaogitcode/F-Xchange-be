package com.example.fxchangebe.services;

import com.example.fxchangebe.entities.User;
import com.example.fxchangebe.exceptions.UserException;
import com.example.fxchangebe.repositories.UserRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class UserSerives {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(String id) {
        return userRepository.findById(new ObjectId(id)).orElseThrow(() -> new UserException("User not found!"));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User updateUserInfo(String id, User user) {
        User existingUser = getUser(id);
        existingUser.setInformations(user.getInformations());
        existingUser.setRole(user.getRole());
        existingUser.setStatus(user.getStatus());
        existingUser.setCreateAt(user.getCreateAt());
        existingUser.setUpdateAt(user.getUpdateAt());
        existingUser.setPoint(user.getPoint());
        existingUser.setStuff(user.getStuff());
        existingUser.setAttendanceDates(user.getAttendanceDates());
        existingUser.setTransactions(user.getTransactions());
        return userRepository.save(existingUser);
    }

    public void deleteUser(ObjectId id) {
        userRepository.findById(id).orElseThrow(() -> new UserException("User not found!"));
        userRepository.deleteById(id);
    }
}
