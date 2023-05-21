package com.example.fxchangebe.entities;


import lombok.Data;

import java.util.List;
@Data
public class TagValue {

    private String tag_name;

    private String value;

    public TagValue() {
    }

    public TagValue(String tag_name, String value) {
        this.tag_name = tag_name;
        this.value = value;
    }
}
