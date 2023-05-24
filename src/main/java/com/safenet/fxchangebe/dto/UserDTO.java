package com.safenet.fxchangebe.dto;

import com.safenet.fxchangebe.entities.Information;
import com.safenet.fxchangebe.entities.Role;
import com.safenet.fxchangebe.entities.Status;
import com.safenet.fxchangebe.entities.User;
import lombok.Data;

@Data
public class UserDTO {

    private Information informations;

    private String googleId;

    private Role role;

    private int point;

    private Status status;

    public UserDTO() {
    }

    public UserDTO(Information informations, String googleId, Role role, int point, Status status) {
        this.informations = informations;
        this.googleId = googleId;
        this.role = role;
        this.point = point;
        this.status = status;
    }

    public User toEntity() {
        User user = new User();
        user.setInformations(this.informations);
        user.setGoogleId(this.googleId);
        user.setRole(this.role);
        user.setPoint(this.point);
        user.setStatus(this.status);
        return user;
    }
}
