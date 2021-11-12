package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.dto.AssociatedPartyDTO;
import com.oldmutual.omjavainsights.model.mapper.IAssociatedPartyMapper;
import com.oldmutual.omjavainsights.repositories.IAssociatedPartyRepository;
import com.oldmutual.omjavainsights.services.interfaces.IAssociatedPartyService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AssociatedPartyService implements IAssociatedPartyService {

    private final IAssociatedPartyMapper associatedPartyMapper;
    private final IAssociatedPartyRepository associatedPartyRepository;

    public AssociatedPartyService(IAssociatedPartyMapper associatedPartyMapper, IAssociatedPartyRepository associatedPartyRepository) {
        this.associatedPartyMapper = associatedPartyMapper;
        this.associatedPartyRepository = associatedPartyRepository;
    }

    @Override
    public AssociatedPartyDTO getAssociatedPartyById(Long id) {
        return associatedPartyRepository.findById(id).stream()
                .map(associatedParty -> associatedPartyMapper.assPartyToAssPartyDTO(associatedParty))
                .collect(Collectors.toList()).get(0);
    }
}
