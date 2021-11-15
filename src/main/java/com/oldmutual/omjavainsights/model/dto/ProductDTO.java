package com.oldmutual.omjavainsights.model.dto;

import com.oldmutual.omjavainsights.model.dto.ContractDTO;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class ProductDTO {

    private Long productId;
    private String productCode;
    private String productType;
    private String policyNumber;
    private String policyFee;
    private String paymentMode;
    private String amlProductCategoryBelowThreshold;
    private Date startDate;
    private Date endDate;
    private String premium;
    private String premiumFrequency;
    private ContractDTO contract;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDTO)) return false;

        ProductDTO that = (ProductDTO) o;

        if (getProductId() != null ? !getProductId().equals(that.getProductId()) : that.getProductId() != null)
            return false;
        if (getProductCode() != null ? !getProductCode().equals(that.getProductCode()) : that.getProductCode() != null)
            return false;
        if (getProductType() != null ? !getProductType().equals(that.getProductType()) : that.getProductType() != null)
            return false;
        if (getPolicyNumber() != null ? !getPolicyNumber().equals(that.getPolicyNumber()) : that.getPolicyNumber() != null)
            return false;
        if (getPolicyFee() != null ? !getPolicyFee().equals(that.getPolicyFee()) : that.getPolicyFee() != null)
            return false;
        if (getPaymentMode() != null ? !getPaymentMode().equals(that.getPaymentMode()) : that.getPaymentMode() != null)
            return false;
        if (getAmlProductCategoryBelowThreshold() != null ? !getAmlProductCategoryBelowThreshold().equals(that.getAmlProductCategoryBelowThreshold()) : that.getAmlProductCategoryBelowThreshold() != null)
            return false;
        if (getStartDate() != null ? !getStartDate().equals(that.getStartDate()) : that.getStartDate() != null)
            return false;
        if (getEndDate() != null ? !getEndDate().equals(that.getEndDate()) : that.getEndDate() != null) return false;
        if (getPremium() != null ? !getPremium().equals(that.getPremium()) : that.getPremium() != null) return false;
        if (getPremiumFrequency() != null ? !getPremiumFrequency().equals(that.getPremiumFrequency()) : that.getPremiumFrequency() != null)
            return false;
        return getContract() != null ? getContract().equals(that.getContract()) : that.getContract() == null;
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
