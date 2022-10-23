package com.spring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity @Table(name = "merchants")
@Data @NoArgsConstructor
public class Merchant extends BaseEntity {

    private String name;
    private String code;
    private BigDecimal transactionFee;
    private BigDecimal commission_rate;
    private int payoutDelayCount;

    @OneToMany(mappedBy = "merchant")
    private List<Payment> paymentList;

    public Merchant(String name, String code, BigDecimal transactionFee, BigDecimal commission_rate, int payoutDelayCount) {
        this.name = name;
        this.code = code;
        this.transactionFee = transactionFee;
        this.commission_rate = commission_rate;
        this.payoutDelayCount = payoutDelayCount;

    }
}
