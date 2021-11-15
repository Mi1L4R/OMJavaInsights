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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequirementsWrapperDTO)) return false;

        RequirementsWrapperDTO that = (RequirementsWrapperDTO) o;

        if (getRequirementsWrapperId() != null ? !getRequirementsWrapperId().equals(that.getRequirementsWrapperId()) : that.getRequirementsWrapperId() != null)
            return false;
        if (getRoleInTransaction() != null ? !getRoleInTransaction().equals(that.getRoleInTransaction()) : that.getRoleInTransaction() != null)
            return false;
        if (getFullRequirements() != null ? !getFullRequirements().equals(that.getFullRequirements()) : that.getFullRequirements() != null)
            return false;
        if (getPartyCategorization() != null ? !getPartyCategorization().equals(that.getPartyCategorization()) : that.getPartyCategorization() != null)
            return false;
        if (getRequirementsOutput() != null ? !getRequirementsOutput().equals(that.getRequirementsOutput()) : that.getRequirementsOutput() != null)
            return false;
        if (getRiskRatingDoneForActiveTransactions() != null ? !getRiskRatingDoneForActiveTransactions().equals(that.getRiskRatingDoneForActiveTransactions()) : that.getRiskRatingDoneForActiveTransactions() != null)
            return false;
        if (getScreeningDoneForActiveTransactions() != null ? !getScreeningDoneForActiveTransactions().equals(that.getScreeningDoneForActiveTransactions()) : that.getScreeningDoneForActiveTransactions() != null)
            return false;
        return getHadMarkers() != null ? getHadMarkers().equals(that.getHadMarkers()) : that.getHadMarkers() == null;
    }

    @Override
    public int hashCode() {
        int result = getRequirementsWrapperId() != null ? getRequirementsWrapperId().hashCode() : 0;
        result = 31 * result + (getRoleInTransaction() != null ? getRoleInTransaction().hashCode() : 0);
        result = 31 * result + (getFullRequirements() != null ? getFullRequirements().hashCode() : 0);
        result = 31 * result + (getPartyCategorization() != null ? getPartyCategorization().hashCode() : 0);
        result = 31 * result + (getRequirementsOutput() != null ? getRequirementsOutput().hashCode() : 0);
        result = 31 * result + (getRiskRatingDoneForActiveTransactions() != null ? getRiskRatingDoneForActiveTransactions().hashCode() : 0);
        result = 31 * result + (getScreeningDoneForActiveTransactions() != null ? getScreeningDoneForActiveTransactions().hashCode() : 0);
        result = 31 * result + (getHadMarkers() != null ? getHadMarkers().hashCode() : 0);
        return result;
    }
}
