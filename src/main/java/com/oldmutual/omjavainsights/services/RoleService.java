package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.dto.ContractDTO;
import com.oldmutual.omjavainsights.model.dto.RoleDTO;
import com.oldmutual.omjavainsights.model.mapper.IRoleMapper;
import com.oldmutual.omjavainsights.repositories.IRoleRepository;
import com.oldmutual.omjavainsights.services.interfaces.IRoleService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RoleService implements IRoleService {

    private final IRoleMapper roleMapper;
    private final IRoleRepository roleRepository;

    public RoleService(IRoleMapper roleMapper, IRoleRepository roleRepository) {
        this.roleMapper = roleMapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleDTO getRoleById(Long id) {
        try {

            var role = roleRepository.findById(id).get();
            return roleMapper.roleToRoleDTO(role);
        } catch (Exception e) {

            //todo implement logging
            return new RoleDTO();
        }
    }
}
