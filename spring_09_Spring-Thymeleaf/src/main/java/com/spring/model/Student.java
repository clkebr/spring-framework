package com.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Student {

    private String firstname;
    private String lastname;
    private String state;
    private int age;
}
