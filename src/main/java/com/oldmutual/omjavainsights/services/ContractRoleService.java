package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.dto.ContractRoleDTO;
import com.oldmutual.omjavainsights.model.mapper.IContractRoleMapper;
import com.oldmutual.omjavainsights.repositories.IContractRoleRepository;
import com.oldmutual.omjavainsights.services.interfaces.IContractRoleService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ContractRoleService implements IContractRoleService {

    private final IContractRoleMapper contractRoleMapper;
    private final IContractRoleRepository contractRoleRepository;

    public ContractRoleService(IContractRoleMapper contractRoleMapper, IContractRoleRepository contractRoleRepository) {
        this.contractRoleMapper = contractRoleMapper;
        this.contractRoleRepository = contractRoleRepository;
    }


    @Override
    public ContractRoleDTO getRoleById(Long id) {
        return contractRoleRepository.findById(id).stream()
                .map(contractRole -> contractRoleMapper.contractRoleToContractRoleDTO(contractRole))
                .collect(Collectors.toList()).get(0);
    }
}
