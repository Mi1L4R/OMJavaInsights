package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.dto.PartyDTO;
import com.oldmutual.omjavainsights.model.mapper.IPartyMapper;
import com.oldmutual.omjavainsights.repositories.IPartyRepository;
import com.oldmutual.omjavainsights.services.interfaces.IPartyService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PartyService implements IPartyService {

    private final IPartyMapper partyMapper;
    private final IPartyRepository partyRepository;

    public PartyService(IPartyMapper partyMapper, IPartyRepository partyRepository) {
        this.partyMapper = partyMapper;
        this.partyRepository = partyRepository;
    }



    @Override
    public PartyDTO getPartyById(String id) {
        return partyRepository.findById(id).stream()
                .map(party -> partyMapper.partyToPartyDto(party))
                .collect(Collectors.toList()).get(0);
    }
}
