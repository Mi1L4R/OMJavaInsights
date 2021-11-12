package com.oldmutual.omjavainsights.model.dto;

import com.oldmutual.omjavainsights.model.Contract;
import com.oldmutual.omjavainsights.model.Party;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Data
public class ContractRoleDTO {

    private Long contractRoleId;
    private String roleDescription;
}
