package com.oldmutual.omjavainsights.repositories.custom.repository;

import com.oldmutual.omjavainsights.model.BusinessTransaction;
import com.oldmutual.omjavainsights.model.Contract;
import com.oldmutual.omjavainsights.model.Party;

import java.util.List;

public interface ICustomBusinessTransactionRepository {

    List<BusinessTransaction> findByContracts(Contract contract);
    List<BusinessTransaction> findByParties(Party party);
}
