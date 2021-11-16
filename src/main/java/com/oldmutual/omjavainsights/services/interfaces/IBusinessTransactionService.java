package com.oldmutual.omjavainsights.services.interfaces;

import com.oldmutual.omjavainsights.model.dto.AssociatedPartyDTO;
import com.oldmutual.omjavainsights.model.dto.BusinessTransactionDTO;

public interface IBusinessTransactionService {

    BusinessTransactionDTO getBusinessTransactionById(Long id);
}
