package com.oldmutual.omjavainsights.model.mapper;

import com.oldmutual.omjavainsights.model.Contract;
import com.oldmutual.omjavainsights.model.dto.ContractDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {
        IContractRoleMapper.class,
        IProductMapper.class
})
public interface IContractMapper {

    IContractMapper INSTANCE = Mappers.getMapper(IContractMapper.class);

    // todo add mapping needed for contract and contract dto
    ContractDTO contractToContractDTO(Contract contract);

    // todo add mapping needed for contract and contract dto
    Contract contractToContract(ContractDTO contractDTO);

    //List Conversions
    List<ContractDTO> contractListToContractListDTO(List<Contract> contracts);
    List<Contract> contractListDTOToContractList(List<ContractDTO> contractsDTO);
}
