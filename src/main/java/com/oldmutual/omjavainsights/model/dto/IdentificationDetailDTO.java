package com.oldmutual.omjavainsights.model.dto;

import com.oldmutual.omjavainsights.model.Country;
import com.oldmutual.omjavainsights.model.NaturalPerson;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class IdentificationDetailDTO {

    private Long identificationDetailId;
    private String idNumber;
    private String idType;
    private CountryDTO countryOfIssue;
    private String visaPermitType;
    private Date dateOfExpiry;
    private Date modifiedOn;
}
