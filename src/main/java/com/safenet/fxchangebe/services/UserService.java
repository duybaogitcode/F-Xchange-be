package com.safenet.fxchangebe.services;

import com.safenet.fxchangebe.dto.UserDTO;
import com.safenet.fxchangebe.entities.User;
import com.safenet.fxchangebe.exceptions.UserException;
import com.safenet.fxchangebe.repositories.RoleRepository;
import com.safenet.fxchangebe.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public UserDTO createUser(User user) {
        user.setRole(roleRepository.findByName("MEMBER"));
        return userRepository.save(user).toDTO();
    }

    public User getUser(String googleId) {
        return userRepository.findByGoogleId(googleId).orElseThrow(() -> new UserException("User not found!"));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public UserDTO updateUserInfo(String googleId, User user) throws Exception {
        User existUser = userRepository.findByGoogleId(googleId).orElseThrow(() -> new UserException("User not found!"));
        existUser.setInformations(user.getInformations());
        existUser.setRole(user.getRole());
        existUser.setStatus(user.getStatus());
        existUser.setCreateAt(user.getCreateAt());
        existUser.setUpdateAt(user.getUpdateAt());
        existUser.setPoint(user.getPoint());
        existUser.setAttendanceDates(user.getAttendanceDates());
        return userRepository.save(existUser).toDTO();
    }

    public void deleteUser(String googleId) {
        userRepository.findByGoogleId(googleId).orElseThrow(() -> new UserException("User not found!"));
        userRepository.deleteByGoogleId(googleId);
    }

    public User findUserByGoogleId(String googleId) throws Exception {
        return userRepository.findByGoogleId(googleId).isPresent() ? userRepository.findByGoogleId(googleId).get() : null;
    }
}
