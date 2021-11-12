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
}
