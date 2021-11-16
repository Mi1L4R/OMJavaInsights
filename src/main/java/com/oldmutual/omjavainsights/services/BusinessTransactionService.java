package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.dto.BusinessTransactionDTO;
import com.oldmutual.omjavainsights.model.dto.ContactDetailDTO;
import com.oldmutual.omjavainsights.model.mapper.IBusinessTransactionMapper;
import com.oldmutual.omjavainsights.repositories.IBusinessTransactionRepository;
import com.oldmutual.omjavainsights.services.interfaces.IBusinessTransactionService;
import org.springframework.stereotype.Service;

@Service
public class BusinessTransactionService implements IBusinessTransactionService {

    private final IBusinessTransactionMapper businessTransactionMapper;
    private final IBusinessTransactionRepository businessTransactionRepository;

    public BusinessTransactionService(IBusinessTransactionMapper businessTransactionMapper, IBusinessTransactionRepository businessTransactionRepository) {
        this.businessTransactionMapper = businessTransactionMapper;
        this.businessTransactionRepository = businessTransactionRepository;
    }


    @Override
    public BusinessTransactionDTO getBusinessTransactionById(Long id) {
        try{

            var busTrans = businessTransactionRepository.findById(id).get();
            return businessTransactionMapper.busTransToBusTransDTO(busTrans);
        }
        catch (Exception e){

            //todo implement logging
            return new BusinessTransactionDTO();
        }
    }
}
