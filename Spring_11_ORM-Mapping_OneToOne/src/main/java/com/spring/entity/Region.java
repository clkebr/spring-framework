package com.spring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
@Data
@NoArgsConstructor
public class Region extends BaseEntity{
    @OneToOne(mappedBy = "region")
    private Employee employee;
    private String region;
    private String country;

    public Region(String region, String country) {
        this.region = region;
        this.country = country;
    }
}
