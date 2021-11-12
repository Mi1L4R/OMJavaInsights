package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.dto.RequirementDTO;
import com.oldmutual.omjavainsights.model.mapper.IRequirementMapper;
import com.oldmutual.omjavainsights.repositories.IRequirementRepository;
import com.oldmutual.omjavainsights.services.interfaces.IRequirementService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RequirementService implements IRequirementService {

    private final IRequirementMapper requirementMapper;
    private final IRequirementRepository requirementRepository;

    public RequirementService(IRequirementMapper requirementMapper, IRequirementRepository requirementRepository) {
        this.requirementMapper = requirementMapper;
        this.requirementRepository = requirementRepository;
    }


    @Override
    public RequirementDTO getRequirementById(Long id) {
        return requirementRepository.findById(id).stream()
                .map(requirement -> requirementMapper.requirementToRequirementDTO(requirement))
                .collect(Collectors.toList()).get(0);
    }
}
