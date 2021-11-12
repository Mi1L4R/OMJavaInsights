package com.oldmutual.omjavainsights.model.dto;

import com.oldmutual.omjavainsights.model.NaturalPerson;
import com.oldmutual.omjavainsights.model.RequirementsWrapper;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
public class RoleDTO {

    private Long roleId;
    private String roleDescription;
    private String roleCategory;
    private String screeningRole;
    private String determinedNationality;
}
