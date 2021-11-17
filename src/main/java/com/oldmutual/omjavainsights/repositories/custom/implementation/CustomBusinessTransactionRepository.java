package com.oldmutual.omjavainsights.repositories.custom.implementation;

import com.oldmutual.omjavainsights.model.BusinessTransaction;
import com.oldmutual.omjavainsights.model.Contract;
import com.oldmutual.omjavainsights.model.Party;
import com.oldmutual.omjavainsights.repositories.IContractRepository;
import com.oldmutual.omjavainsights.repositories.IPartyRepository;
import com.oldmutual.omjavainsights.repositories.custom.repository.ICustomBusinessTransactionRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomBusinessTransactionRepository implements ICustomBusinessTransactionRepository {

    private final IContractRepository contractRepository;
    private final IPartyRepository partyRepository;

    public CustomBusinessTransactionRepository(IContractRepository contractRepository, IPartyRepository partyRepository) {
        this.contractRepository = contractRepository;
        this.partyRepository = partyRepository;
    }

    @Override
    public List<BusinessTransaction> findByContracts(Contract contract) {

        if(contract == null){
            return new ArrayList<>();
        }

        var contractObj = contractRepository.findById(contract.getContractId()).orElse(null);

        return contractObj != null ? contractObj.getBusinessTransactions() : new ArrayList<>();
    }

    @Override
    public List<BusinessTransaction> findByParties(Party party) {

        if(party == null){
            return new ArrayList<>();
        }

        var partyObj = partyRepository.findById(party.getLisId()).orElse(null);

        return partyObj != null ? partyObj.getBusinessTransactions() : new ArrayList<>();

    }
}
