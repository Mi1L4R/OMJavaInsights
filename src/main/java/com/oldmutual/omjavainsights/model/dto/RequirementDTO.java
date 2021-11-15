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
    private RequirementsWrapperDTO requirementsWrapper;
    private NaturalPersonDTO naturalPerson;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequirementDTO)) return false;

        RequirementDTO that = (RequirementDTO) o;

        if (getRequirementId() != null ? !getRequirementId().equals(that.getRequirementId()) : that.getRequirementId() != null)
            return false;
        if (getStatus() != null ? !getStatus().equals(that.getStatus()) : that.getStatus() != null) return false;
        if (getCountry() != null ? !getCountry().equals(that.getCountry()) : that.getCountry() != null) return false;
        if (getRequirementsCategory() != null ? !getRequirementsCategory().equals(that.getRequirementsCategory()) : that.getRequirementsCategory() != null)
            return false;
        if (getRequirementsType() != null ? !getRequirementsType().equals(that.getRequirementsType()) : that.getRequirementsType() != null)
            return false;
        if (getRequirementsSubType() != null ? !getRequirementsSubType().equals(that.getRequirementsSubType()) : that.getRequirementsSubType() != null)
            return false;
        if (getRegulation() != null ? !getRegulation().equals(that.getRegulation()) : that.getRegulation() != null)
            return false;
        if (getAdjacency() != null ? !getAdjacency().equals(that.getAdjacency()) : that.getAdjacency() != null)
            return false;
        if (getCreatedDate() != null ? !getCreatedDate().equals(that.getCreatedDate()) : that.getCreatedDate() != null)
            return false;
        if (getNewRequirement() != null ? !getNewRequirement().equals(that.getNewRequirement()) : that.getNewRequirement() != null)
            return false;
        if (getRequirementsWrapper() != null ? !getRequirementsWrapper().equals(that.getRequirementsWrapper()) : that.getRequirementsWrapper() != null)
            return false;
        return getNaturalPerson() != null ? getNaturalPerson().equals(that.getNaturalPerson()) : that.getNaturalPerson() == null;
    }

    @Override
    public int hashCode() {
        int result = getRequirementId() != null ? getRequirementId().hashCode() : 0;
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getRequirementsCategory() != null ? getRequirementsCategory().hashCode() : 0);
        result = 31 * result + (getRequirementsType() != null ? getRequirementsType().hashCode() : 0);
        result = 31 * result + (getRequirementsSubType() != null ? getRequirementsSubType().hashCode() : 0);
        result = 31 * result + (getRegulation() != null ? getRegulation().hashCode() : 0);
        result = 31 * result + (getAdjacency() != null ? getAdjacency().hashCode() : 0);
        result = 31 * result + (getCreatedDate() != null ? getCreatedDate().hashCode() : 0);
        result = 31 * result + (getNewRequirement() != null ? getNewRequirement().hashCode() : 0);
        result = 31 * result + (getRequirementsWrapper() != null ? getRequirementsWrapper().hashCode() : 0);
        result = 31 * result + (getNaturalPerson() != null ? getNaturalPerson().hashCode() : 0);
        return result;
    }
}
