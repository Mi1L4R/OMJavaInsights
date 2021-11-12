package com.oldmutual.omjavainsights.model.dto;

import com.oldmutual.omjavainsights.generics.GenericsForDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BusinessTransactionDTO {

    private Long businessTransactionId;
    private List<PartyDTO> parties;
    private List<ContractDTO> contracts;

    //generic methods for adding/removing dto from dtoList

    public void addParty(PartyDTO partyDTO){
        GenericsForDTO.addDTOObjectToList(partyDTO, parties);
    }

    public void removeParty(PartyDTO partyDTO){
        GenericsForDTO.removeDTOObjectFromList(partyDTO, parties);
    }

    public void addContract(ContractDTO contractDTO){
        GenericsForDTO.addDTOObjectToList(contractDTO,contracts);
    }

    public void removeContract(ContractDTO contractDTO){
        GenericsForDTO.removeDTOObjectFromList(contractDTO, contracts);
    }
}
