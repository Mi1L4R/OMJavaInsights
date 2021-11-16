package com.oldmutual.omjavainsights.repositories.custom.implementation;

import com.oldmutual.omjavainsights.model.BusinessTransaction;
import com.oldmutual.omjavainsights.model.Party;
import com.oldmutual.omjavainsights.repositories.IBusinessTransactionRepository;
import com.oldmutual.omjavainsights.repositories.IPartyRepository;
import com.oldmutual.omjavainsights.repositories.custom.repository.ICustomPartyRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomPartyRepository implements ICustomPartyRepository {

    private final IBusinessTransactionRepository businessTransactionRepository;

    public CustomPartyRepository(IBusinessTransactionRepository businessTransactionRepository) {
        this.businessTransactionRepository = businessTransactionRepository;
    }


    @Override
    public List<Party> findByBusinessTransactions(BusinessTransaction businessTransaction) {
        var busTrans = businessTransactionRepository.findById(businessTransaction.getBusinessTransactionId()).orElse(null);

        if(businessTransaction == null){
            return new ArrayList<>();
        }

        var parties = busTrans.getParties();

        return parties;
    }
}
