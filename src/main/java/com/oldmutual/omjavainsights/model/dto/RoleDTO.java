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
    private NaturalPersonDTO naturalPerson;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleDTO)) return false;

        RoleDTO roleDTO = (RoleDTO) o;

        if (getRoleId() != null ? !getRoleId().equals(roleDTO.getRoleId()) : roleDTO.getRoleId() != null) return false;
        if (getRoleDescription() != null ? !getRoleDescription().equals(roleDTO.getRoleDescription()) : roleDTO.getRoleDescription() != null)
            return false;
        if (getRoleCategory() != null ? !getRoleCategory().equals(roleDTO.getRoleCategory()) : roleDTO.getRoleCategory() != null)
            return false;
        if (getScreeningRole() != null ? !getScreeningRole().equals(roleDTO.getScreeningRole()) : roleDTO.getScreeningRole() != null)
            return false;
        if (getDeterminedNationality() != null ? !getDeterminedNationality().equals(roleDTO.getDeterminedNationality()) : roleDTO.getDeterminedNationality() != null)
            return false;
        return getNaturalPerson() != null ? getNaturalPerson().equals(roleDTO.getNaturalPerson()) : roleDTO.getNaturalPerson() == null;
    }

    @Override
    public int hashCode() {
        int result = getRoleId() != null ? getRoleId().hashCode() : 0;
        result = 31 * result + (getRoleDescription() != null ? getRoleDescription().hashCode() : 0);
        result = 31 * result + (getRoleCategory() != null ? getRoleCategory().hashCode() : 0);
        result = 31 * result + (getScreeningRole() != null ? getScreeningRole().hashCode() : 0);
        result = 31 * result + (getDeterminedNationality() != null ? getDeterminedNationality().hashCode() : 0);
        result = 31 * result + (getNaturalPerson() != null ? getNaturalPerson().hashCode() : 0);
        return result;
    }
}
