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

}
