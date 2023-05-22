package com.safenet.fxchangebe.entities;


import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import java.lang.reflect.Array;
import java.util.List;

@Data
public class Information {

    private String email;

    private String fullname;

    private List<String> phone;

    private List<String> address;

    @Field("avatar_url")
    private String avatarUrl;

    public Information() {
    }

    public Information(String email, String fullname, List<String> phone, List<String> address, String avatarUrl) {
        this.email = email;
        this.fullname = fullname;
        this.phone = phone;
        this.address = address;
        this.avatarUrl = avatarUrl;
    }
}
