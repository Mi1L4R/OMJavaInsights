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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusinessTransactionDTO)) return false;

        BusinessTransactionDTO that = (BusinessTransactionDTO) o;

        if (getBusinessTransactionId() != null ? !getBusinessTransactionId().equals(that.getBusinessTransactionId()) : that.getBusinessTransactionId() != null)
            return false;
        if (getParties() != null ? !getParties().equals(that.getParties()) : that.getParties() != null) return false;
        return getContracts() != null ? getContracts().equals(that.getContracts()) : that.getContracts() == null;
    }

    @Override
    public int hashCode() {
        int result = getBusinessTransactionId() != null ? getBusinessTransactionId().hashCode() : 0;
        result = 31 * result + (getParties() != null ? getParties().hashCode() : 0);
        result = 31 * result + (getContracts() != null ? getContracts().hashCode() : 0);
        return result;
    }
}
