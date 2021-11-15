package com.oldmutual.omjavainsights.model.mapper;

import com.oldmutual.omjavainsights.model.BusinessTransaction;
import com.oldmutual.omjavainsights.model.dto.BusinessTransactionDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
        IPartyMapper.class,
        IContractMapper.class
})
public interface IBusinessTransactionMapper {

    BusinessTransactionDTO busTransToBusTransDTO(BusinessTransaction businessTransaction);
    BusinessTransaction busTransDTOToBusTrans(BusinessTransactionDTO businessTransactionDTO);

    //List conversions

    List<BusinessTransactionDTO> busTransListTobusTransDTOList(List<BusinessTransaction> businessTransactions);
    List<BusinessTransaction> busTransDTOListTobusTransList(List<BusinessTransactionDTO> businessTransactionDTOs);
}
