package com.safenet.fxchangebe.entities;


import com.safenet.fxchangebe.dto.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private ObjectId id;

    private Information informations;

    @Field("google_id")
    @Indexed(unique = true)
    private String googleId;

    @DBRef
    private Role role;

    private int point;

    @Field("invitation_code")
    private String invitationCode;

    private Status status;

    @CreatedDate
    @Field("create_at")
    private Date createAt;

    @LastModifiedDate
    @Field("update_at")
    private Date updateAt;

    @Field("attendance_dates")
    private List<Date> attendanceDates;

    public UserDTO toDTO() {
        UserDTO dto = new UserDTO();
        dto.setInformations(this.informations);
        dto.setGoogleId(this.googleId);
        dto.setRole(this.role);
        dto.setPoint(this.point);
        dto.setStatus(this.status);
        return dto;
    }
}
