package com.spring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity @Table(name = "costumers")
@Data @NoArgsConstructor
public class Customer extends BaseEntity{

    private String userName;
    private String name;
    private String surName;

    public Customer(String userName, String name, String surName, String email, String address) {
        this.userName = userName;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.address = address;
    }

    private String email;
    private String address;


    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private List<Payment> paymentList;

}
