package com.spring.model;

import com.spring.Enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Mentor {

    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
}
