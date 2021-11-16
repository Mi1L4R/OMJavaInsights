package com.oldmutual.omjavainsights.services.interfaces;

import com.oldmutual.omjavainsights.model.Contract;
import com.oldmutual.omjavainsights.model.Party;
import com.oldmutual.omjavainsights.model.dto.BusinessTransactionDTO;
import com.oldmutual.omjavainsights.model.dto.ContractDTO;
import com.oldmutual.omjavainsights.model.dto.PartyDTO;

import java.util.List;

public interface IPartyService {

    PartyDTO getPartyById(String id);

    List<PartyDTO> getPartiesByTransaction(BusinessTransactionDTO businessTransactionDTO);

    List<PartyDTO> getPartiesByContract(ContractDTO contractDTO);
}
