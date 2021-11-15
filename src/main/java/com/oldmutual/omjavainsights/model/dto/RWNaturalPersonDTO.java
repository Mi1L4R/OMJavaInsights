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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RWNaturalPersonDTO)) return false;

        RWNaturalPersonDTO that = (RWNaturalPersonDTO) o;

        if (getRwNaturalPersonId() != null ? !getRwNaturalPersonId().equals(that.getRwNaturalPersonId()) : that.getRwNaturalPersonId() != null)
            return false;
        if (getRequirementsWrapper() != null ? !getRequirementsWrapper().equals(that.getRequirementsWrapper()) : that.getRequirementsWrapper() != null)
            return false;
        return getDecisionId() != null ? getDecisionId().equals(that.getDecisionId()) : that.getDecisionId() == null;
    }

    @Override
    public int hashCode() {
        int result = getRwNaturalPersonId() != null ? getRwNaturalPersonId().hashCode() : 0;
        result = 31 * result + (getRequirementsWrapper() != null ? getRequirementsWrapper().hashCode() : 0);
        result = 31 * result + (getDecisionId() != null ? getDecisionId().hashCode() : 0);
        return result;
    }
}
