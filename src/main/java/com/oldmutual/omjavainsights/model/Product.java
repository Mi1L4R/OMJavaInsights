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
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getProductId() != null ? !getProductId().equals(product.getProductId()) : product.getProductId() != null)
            return false;
        if (getProductCode() != null ? !getProductCode().equals(product.getProductCode()) : product.getProductCode() != null)
            return false;
        if (getProductType() != null ? !getProductType().equals(product.getProductType()) : product.getProductType() != null)
            return false;
        if (getPolicyNumber() != null ? !getPolicyNumber().equals(product.getPolicyNumber()) : product.getPolicyNumber() != null)
            return false;
        if (getPolicyFee() != null ? !getPolicyFee().equals(product.getPolicyFee()) : product.getPolicyFee() != null)
            return false;
        if (getPaymentMode() != null ? !getPaymentMode().equals(product.getPaymentMode()) : product.getPaymentMode() != null)
            return false;
        if (getAmlProductCategoryBelowThreshold() != null ? !getAmlProductCategoryBelowThreshold().equals(product.getAmlProductCategoryBelowThreshold()) : product.getAmlProductCategoryBelowThreshold() != null)
            return false;
        if (getStartDate() != null ? !getStartDate().equals(product.getStartDate()) : product.getStartDate() != null)
            return false;
        if (getEndDate() != null ? !getEndDate().equals(product.getEndDate()) : product.getEndDate() != null)
            return false;
        if (getPremium() != null ? !getPremium().equals(product.getPremium()) : product.getPremium() != null)
            return false;
        if (getPremiumFrequency() != null ? !getPremiumFrequency().equals(product.getPremiumFrequency()) : product.getPremiumFrequency() != null)
            return false;
        return getContract() != null ? getContract().equals(product.getContract()) : product.getContract() == null;
    }

    @Override
    public int hashCode() {
        int result = getProductId() != null ? getProductId().hashCode() : 0;
        result = 31 * result + (getProductCode() != null ? getProductCode().hashCode() : 0);
        result = 31 * result + (getProductType() != null ? getProductType().hashCode() : 0);
        result = 31 * result + (getPolicyNumber() != null ? getPolicyNumber().hashCode() : 0);
        result = 31 * result + (getPolicyFee() != null ? getPolicyFee().hashCode() : 0);
        result = 31 * result + (getPaymentMode() != null ? getPaymentMode().hashCode() : 0);
        result = 31 * result + (getAmlProductCategoryBelowThreshold() != null ? getAmlProductCategoryBelowThreshold().hashCode() : 0);
        result = 31 * result + (getStartDate() != null ? getStartDate().hashCode() : 0);
        result = 31 * result + (getEndDate() != null ? getEndDate().hashCode() : 0);
        result = 31 * result + (getPremium() != null ? getPremium().hashCode() : 0);
        result = 31 * result + (getPremiumFrequency() != null ? getPremiumFrequency().hashCode() : 0);
        result = 31 * result + (getContract() != null ? getContract().hashCode() : 0);
        return result;
    }
}
