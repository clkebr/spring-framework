package com.spring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payment_details")
@Data @NoArgsConstructor
public class PaymentDetail extends BaseEntity{

    private BigDecimal commissionAmount;
    private BigDecimal merchantPayoutAmount;
    private LocalDate payoutDate;
    @OneToOne(mappedBy = "paymentDetail", cascade = CascadeType.ALL)
    private Payment payment;

    public PaymentDetail(BigDecimal commissionAmount, BigDecimal merchantPayoutAmount, LocalDate payoutDate) {
        this.commissionAmount = commissionAmount;
        this.merchantPayoutAmount = merchantPayoutAmount;
        this.payoutDate = payoutDate;
    }
}
