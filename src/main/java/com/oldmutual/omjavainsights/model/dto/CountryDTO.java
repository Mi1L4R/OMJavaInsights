package com.oldmutual.omjavainsights.model.dto;

import com.oldmutual.omjavainsights.model.*;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToOne;

@Data
public class CountryDTO {

    private Long countryId;
    private String countryCode;
    private String countryClassification;



}
