package com.oldmutual.omjavainsights.model.dto;

import com.oldmutual.omjavainsights.generics.GenericsForDTO;
import com.oldmutual.omjavainsights.model.AssociatedParty;
import com.oldmutual.omjavainsights.model.ContractRole;
import com.oldmutual.omjavainsights.model.NaturalPerson;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Data
public class PartyDTO {

    private String lisId;
    private String partyType;
    private List<ContractRoleDTO> contractRoles;
    private List<AssociatedPartyDTO> associatedParties;
    private List<BusinessTransactionDTO> businessTransactions;

    //Generic methods used for Adding/Removing dto from dtoList
    public void addContractRole(ContractRoleDTO contractRoleDTO){
        GenericsForDTO.addDTOObjectToList(contractRoleDTO,contractRoles);
    }

    public void removeContractRole(ContractRoleDTO contractRoleDTO){
        GenericsForDTO.removeDTOObjectFromList(contractRoleDTO,contractRoles);
    }

    public void addAssociatedParty(AssociatedPartyDTO associatedPartyDTO){
        GenericsForDTO.addDTOObjectToList(associatedPartyDTO,associatedParties);
    }

    public void removeAssociatedParty(AssociatedPartyDTO associatedPartyDTO){
        GenericsForDTO.removeDTOObjectFromList(associatedPartyDTO,associatedParties);
    }

    public void addBusinessTransaction(BusinessTransactionDTO businessTransactionDTO){
        GenericsForDTO.addDTOObjectToList(businessTransactionDTO, businessTransactions);
    }

    public void removeBusinessTransaction(BusinessTransactionDTO businessTransactionDTO){
        GenericsForDTO.removeDTOObjectFromList(businessTransactionDTO, businessTransactions);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PartyDTO)) return false;

        PartyDTO partyDTO = (PartyDTO) o;

        if (getLisId() != null ? !getLisId().equals(partyDTO.getLisId()) : partyDTO.getLisId() != null) return false;
        if (getPartyType() != null ? !getPartyType().equals(partyDTO.getPartyType()) : partyDTO.getPartyType() != null)
            return false;
        if (getContractRoles() != null ? !getContractRoles().equals(partyDTO.getContractRoles()) : partyDTO.getContractRoles() != null)
            return false;
        if (getAssociatedParties() != null ? !getAssociatedParties().equals(partyDTO.getAssociatedParties()) : partyDTO.getAssociatedParties() != null)
            return false;
        return getBusinessTransactions() != null ? getBusinessTransactions().equals(partyDTO.getBusinessTransactions()) : partyDTO.getBusinessTransactions() == null;
    }

    @Override
    public int hashCode() {
        int result = getLisId() != null ? getLisId().hashCode() : 0;
        result = 31 * result + (getPartyType() != null ? getPartyType().hashCode() : 0);
        result = 31 * result + (getContractRoles() != null ? getContractRoles().hashCode() : 0);
        result = 31 * result + (getAssociatedParties() != null ? getAssociatedParties().hashCode() : 0);
        result = 31 * result + (getBusinessTransactions() != null ? getBusinessTransactions().hashCode() : 0);
        return result;
    }
}
