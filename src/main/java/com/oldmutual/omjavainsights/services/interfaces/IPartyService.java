package com.oldmutual.omjavainsights.services.interfaces;

import com.oldmutual.omjavainsights.model.dto.BusinessTransactionDTO;
import com.oldmutual.omjavainsights.model.dto.PartyDTO;

import java.util.List;

public interface IPartyService {

    PartyDTO getPartyById(String id);

    List<PartyDTO> getPartyByTransaction(BusinessTransactionDTO businessTransactionDTO);
}
