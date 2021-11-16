package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.BusinessTransaction;
import com.oldmutual.omjavainsights.model.dto.BusinessTransactionDTO;
import com.oldmutual.omjavainsights.model.dto.ContractDTO;
import com.oldmutual.omjavainsights.model.dto.PartyDTO;
import com.oldmutual.omjavainsights.model.mapper.IBusinessTransactionMapper;
import com.oldmutual.omjavainsights.model.mapper.IPartyMapper;
import com.oldmutual.omjavainsights.repositories.IBusinessTransactionRepository;
import com.oldmutual.omjavainsights.repositories.IPartyRepository;
import com.oldmutual.omjavainsights.services.interfaces.IPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartyService implements IPartyService {

    private final IPartyMapper partyMapper;
    private final IPartyRepository partyRepository;

    @Autowired
    private IBusinessTransactionMapper businessTransactionMapper;

    public PartyService(IPartyMapper partyMapper, IPartyRepository partyRepository) {
        this.partyMapper = partyMapper;
        this.partyRepository = partyRepository;
    }




    @Override
    public PartyDTO getPartyById(String id) {

        try {

            var party = partyRepository.findById(id).get();
            return partyMapper.partyToPartyDTO(party);
        } catch (Exception e) {

            //todo implement logging
            return new PartyDTO();
        }

    }

    @Override
    public List<PartyDTO> getPartyByTransaction(BusinessTransactionDTO businessTransactionDTO) {

        var busTrans = businessTransactionMapper.busTransDTOToBusTrans(businessTransactionDTO);
        var parties =  partyRepository.findByBusinessTransactions(busTrans);

        if(parties.size() == 0){
            return null;
        }

        return partyMapper.partyListToPartyDTOList(parties);
    }



}
