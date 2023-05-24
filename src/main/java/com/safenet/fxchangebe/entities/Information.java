package com.safenet.fxchangebe.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
public class Information {

    private String email;

    private String fullname;

    private List<String> phone;

    private List<String> address;

    @Field("avatar_url")
    private String avatarUrl;

}
