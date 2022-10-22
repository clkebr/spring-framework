package com.spring.entity;

import com.spring.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
public class Employee extends BaseEntity{
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    @Column(length = 50)
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department")
    private Department department;
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
    private  int salary;
    @OneToOne(cascade = CascadeType.ALL)
//    @OneToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    @JoinColumn(name = "region_id")
    private  Region region;


    public Employee(String firstName, String lastName, String email, LocalDate hireDate, int salary,Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.gender = gender;
        this.salary = salary;
    }
}
