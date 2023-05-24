package com.safenet.fxchangebe.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "permissions")
public class Permission {
    @Id
    private int id;

    @Field("resource_url")
    private String resourceUrl;

    private List<String> read;

    private List<String> write;

}
