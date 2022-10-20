package com.spring.entity;

import com.spring.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student firstname")
    private String firstname;
    private String lastname;
    private String email;

    @Transient // will not persist in the db
    private String city;

    @Column(columnDefinition = "DATE")
    private LocalDate birthday;
    @Column(columnDefinition = "TIME")
    private LocalDate birthTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate birthDateTime;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
