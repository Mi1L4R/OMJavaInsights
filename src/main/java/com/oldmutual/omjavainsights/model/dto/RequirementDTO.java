package com.oldmutual.omjavainsights.model.dto;

import com.oldmutual.omjavainsights.model.Country;
import com.oldmutual.omjavainsights.model.NaturalPerson;
import com.oldmutual.omjavainsights.model.RequirementsWrapper;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class RequirementDTO {

    private Long requirementId;
    private String status;
    private CountryDTO country;
    private String requirementsCategory;
    private String requirementsType;
    private String requirementsSubType;
    private String regulation;
    private String adjacency;
    private Date createdDate;
    private Boolean newRequirement;
}
