package com.oldmutual.omjavainsights.model.mapper;

import com.oldmutual.omjavainsights.model.ContractRole;
import com.oldmutual.omjavainsights.model.dto.ContractRoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",uses = IPartyMapper.class)
public interface IContractRoleMapper {

    // todo add mapping needed for contractRole and contractRole dto
    ContractRoleDTO contractRoleToContractRoleDTO(ContractRole contractRole);

    // todo add mapping needed for contractRole and contractRole dto
    ContractRole contractRoleDTOToContractRole(ContractRoleDTO contractRoleDTO);

    //List Conversions
    List<ContractRoleDTO> contractRoleListToContractRoleDTOList(List<ContractRole> contractRoles);
    List<ContractRole> contractRoleListDTOToContractRoleList(List<ContractRoleDTO> contractRoleDTOS);


}
