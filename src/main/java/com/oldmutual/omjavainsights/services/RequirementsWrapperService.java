package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.dto.ContractDTO;
import com.oldmutual.omjavainsights.model.dto.RequirementsWrapperDTO;
import com.oldmutual.omjavainsights.model.mapper.IRequirementsWrapperMapper;
import com.oldmutual.omjavainsights.repositories.IRequirementsWrapperRepository;
import com.oldmutual.omjavainsights.services.interfaces.IRequirementsWrapperService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RequirementsWrapperService implements IRequirementsWrapperService {

    private final IRequirementsWrapperMapper requirementsWrapperMapper;
    private final IRequirementsWrapperRepository requirementsWrapperRepository;

    public RequirementsWrapperService(IRequirementsWrapperMapper requirementsWrapperMapper,
                                      IRequirementsWrapperRepository requirementsWrapperRepository) {

        this.requirementsWrapperMapper = requirementsWrapperMapper;
        this.requirementsWrapperRepository = requirementsWrapperRepository;
    }

    @Override
    public RequirementsWrapperDTO getRWById(Long id) {
        try {

            var reqWrapper = requirementsWrapperRepository.findById(id).get();
            return requirementsWrapperMapper.rwTorwDTO(reqWrapper);
        } catch (Exception e) {

            //todo implement logging
            return new RequirementsWrapperDTO();
        }
    }
}
