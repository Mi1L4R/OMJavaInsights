package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.dto.ContractDTO;
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
        try {

            var requirement = requirementRepository.findById(id).get();
            return requirementMapper.requirementToRequirementDTO(requirement);
        } catch (Exception e) {

            //todo implement logging
            return new RequirementDTO();
        }
    }
}
