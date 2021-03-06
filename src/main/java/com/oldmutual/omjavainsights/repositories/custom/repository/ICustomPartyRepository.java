package com.oldmutual.omjavainsights.repositories.custom.repository;

import com.oldmutual.omjavainsights.model.BusinessTransaction;
import com.oldmutual.omjavainsights.model.Contract;
import com.oldmutual.omjavainsights.model.Party;

import java.util.List;

public interface ICustomPartyRepository {

    List<Party> findByBusinessTransactions(BusinessTransaction businessTransaction);
    List<Party> findByBusinessTransactions_Contracts(Contract contract);


}
