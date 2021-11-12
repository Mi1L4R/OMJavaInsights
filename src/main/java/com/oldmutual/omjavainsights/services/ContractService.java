package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.dto.ContractDTO;
import com.oldmutual.omjavainsights.model.mapper.IContractMapper;
import com.oldmutual.omjavainsights.repositories.IContractRepository;
import com.oldmutual.omjavainsights.services.interfaces.IContractService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ContractService implements IContractService {

    private final IContractMapper contractMapper;
    private final IContractRepository contractRepository;


    public ContractService(IContractMapper contractMapper,  IContractRepository contractRepository) {
        this.contractMapper = contractMapper;
        this.contractRepository = contractRepository;
    }

    @Override
    public ContractDTO getContractById(Long id) {

        return contractRepository.findById(id).stream()
                .map(contract -> contractMapper.contractToContractDTO(contract))
                .collect(Collectors.toList()).get(0);
    }
}
