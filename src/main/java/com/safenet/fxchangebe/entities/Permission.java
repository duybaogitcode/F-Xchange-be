package com.safenet.fxchangebe.entities;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "permissions")
public class Permission {
    @Id
    private int id;

    @Field("resource_url")
    private String resourceUrl;

    private List<String> read;

    private List<String> write;

    public Permission() {
    }

    public Permission(int id, String resourceUrl, List<String> read, List<String> write) {
        this.id = id;
        this.resourceUrl = resourceUrl;
        this.read = read;
        this.write = write;
    }
}
