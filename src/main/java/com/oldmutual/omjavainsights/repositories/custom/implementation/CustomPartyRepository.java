package com.oldmutual.omjavainsights.repositories.custom.implementation;

import com.oldmutual.omjavainsights.model.BusinessTransaction;
import com.oldmutual.omjavainsights.model.Contract;
import com.oldmutual.omjavainsights.model.Party;
import com.oldmutual.omjavainsights.repositories.IBusinessTransactionRepository;
import com.oldmutual.omjavainsights.repositories.IContractRepository;
import com.oldmutual.omjavainsights.repositories.custom.repository.ICustomPartyRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomPartyRepository implements ICustomPartyRepository {

    private final IBusinessTransactionRepository businessTransactionRepository;

    public CustomPartyRepository(IBusinessTransactionRepository businessTransactionRepository, IContractRepository contractRepository) {
        this.businessTransactionRepository = businessTransactionRepository;
    }



    @Override
    public List<Party> findByBusinessTransactions(BusinessTransaction businessTransaction) {

        if(businessTransaction == null){
            return new ArrayList<>();
        }

        var businessTransactionObject = businessTransactionRepository.findById(businessTransaction.getBusinessTransactionId()).orElse(null);



        return businessTransactionObject != null ? businessTransactionObject.getParties() : new ArrayList<>();
    }

    @Override
    public List<Party> findByBusinessTransactions_Contracts(Contract contract) {
        if(contract == null){
            return new ArrayList<>();
        }

        var businessTransactionList = businessTransactionRepository.findByContracts(contract);

        List<Party> parties = new ArrayList<>();

        businessTransactionList.forEach(businessTransaction -> {
            parties.addAll(businessTransaction.getParties());
        });


        return parties;
    }
}
