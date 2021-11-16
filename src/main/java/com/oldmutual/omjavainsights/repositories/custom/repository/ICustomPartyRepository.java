package com.oldmutual.omjavainsights.repositories.custom.repository;

import com.oldmutual.omjavainsights.model.BusinessTransaction;
import com.oldmutual.omjavainsights.model.Party;
import com.oldmutual.omjavainsights.model.dto.PartyDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ICustomPartyRepository {

    List<Party> findByBusinessTransactions(BusinessTransaction businessTransaction);
}
