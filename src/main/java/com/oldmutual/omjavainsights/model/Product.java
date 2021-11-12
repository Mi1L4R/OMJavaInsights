package com.oldmutual.omjavainsights.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private Long productId;

    @Column(name = "ProductCode")
    private String productCode;

    @Column(name = "ProductType")
    private String productType;

    @Column(name = "PolicyNumber")
    private String policyNumber;

    @Column(name = "PolicyFee")
    private String policyFee;

    @Column(name = "PaymentMode")
    private String paymentMode;

    @Column(name = "AMLProductCategoryBelowThreshold")
    private String amlProductCategoryBelowThreshold;

    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "EndDate")
    private Date endDate;

    @Column(name = "Premium")
    private String premium;

    @Column(name = "PremiumFrequency")
    private String premiumFrequency;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Contract contract;

    public Product(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return productId != null && Objects.equals(productId, product.productId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
