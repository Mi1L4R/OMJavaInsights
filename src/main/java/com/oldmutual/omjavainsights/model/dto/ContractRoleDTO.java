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
    private PartyDTO party;
    private ContractDTO contract;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContractRoleDTO)) return false;

        ContractRoleDTO that = (ContractRoleDTO) o;

        if (getContractRoleId() != null ? !getContractRoleId().equals(that.getContractRoleId()) : that.getContractRoleId() != null)
            return false;
        if (getRoleDescription() != null ? !getRoleDescription().equals(that.getRoleDescription()) : that.getRoleDescription() != null)
            return false;
        if (getParty() != null ? !getParty().equals(that.getParty()) : that.getParty() != null) return false;
        return getContract() != null ? getContract().equals(that.getContract()) : that.getContract() == null;
    }

    @Override
    public int hashCode() {
        int result = getContractRoleId() != null ? getContractRoleId().hashCode() : 0;
        result = 31 * result + (getRoleDescription() != null ? getRoleDescription().hashCode() : 0);
        result = 31 * result + (getParty() != null ? getParty().hashCode() : 0);
        result = 31 * result + (getContract() != null ? getContract().hashCode() : 0);
        return result;
    }
}
