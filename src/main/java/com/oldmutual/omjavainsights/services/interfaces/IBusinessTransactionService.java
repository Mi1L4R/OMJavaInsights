package com.oldmutual.omjavainsights.services.interfaces;

import com.oldmutual.omjavainsights.model.dto.AssociatedPartyDTO;
import com.oldmutual.omjavainsights.model.dto.BusinessTransactionDTO;
import com.oldmutual.omjavainsights.model.dto.ContractDTO;
import com.oldmutual.omjavainsights.model.dto.PartyDTO;

import java.util.List;

public interface IBusinessTransactionService {

    BusinessTransactionDTO getBusinessTransactionById(Long id);

    List<BusinessTransactionDTO> getBusinessTransactionsByParty(PartyDTO partyDTO);

    List<BusinessTransactionDTO> getBusinessTransactionsByContract(ContractDTO contractDTO);
}
