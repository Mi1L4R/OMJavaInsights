package com.oldmutual.omjavainsights.model.mapper;

import com.oldmutual.omjavainsights.model.Role;
import com.oldmutual.omjavainsights.model.dto.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRoleMapper {

    // todo add mapping needed for Role and Role dto differences
    RoleDTO roleToRoleDTO(Role role);

    // todo add mapping needed for Role and Role dto differences
    Role roleDTOToRole(RoleDTO roleDTO);

    //List Conversions
    List<RoleDTO> roleListToRoleDTOList(List<Role> roles);
    List<Role> roleDTOListToRoleList(List<RoleDTO> rolesDTO);
}
