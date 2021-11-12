package com.oldmutual.omjavainsights.model.dto;

import com.oldmutual.omjavainsights.generics.GenericsForDTO;
import com.oldmutual.omjavainsights.model.Requirement;
import com.oldmutual.omjavainsights.model.Role;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Data
public class RequirementsWrapperDTO {

    private Long requirementsWrapperId;
    private RoleDTO roleInTransaction;
    private Boolean fullRequirements;
    private String partyCategorization;
    private List<RequirementDTO> requirementsOutput;
    private String riskRatingDoneForActiveTransactions;
    private String screeningDoneForActiveTransactions;
    private String hadMarkers;

    //Generic methods for adding.removing dto from dto List
    public void addRequirement(RequirementDTO requirementDTO){
        GenericsForDTO.addDTOObjectToList(requirementDTO,requirementsOutput);
    }

    public void removeRequirement(RequirementDTO requirementDTO){
        GenericsForDTO.removeDTOObjectFromList(requirementDTO,requirementsOutput);
    }
}
