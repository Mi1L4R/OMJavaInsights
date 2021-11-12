package com.oldmutual.omjavainsights.model.dto;

import com.oldmutual.omjavainsights.model.Country;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
public class TaxResidencyDTO {

    private Long taxResidencyId;
    private CountryDTO countryOfTaxResidency;
    private String countryOfTaxReferenceNumber;
    private String taxIdentificationNumber;
    private String selfCertificationDeclarationReason;
    private Date selfCertificationDeclarationDate;
}
