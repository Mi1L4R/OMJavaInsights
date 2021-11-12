package com.oldmutual.omjavainsights.model.dto;

import com.oldmutual.omjavainsights.model.RequirementsWrapper;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
public class RWNaturalPersonDTO {

    private Long rwNaturalPersonId;
    private RequirementsWrapperDTO requirementsWrapper;
    private String decisionId;
}
