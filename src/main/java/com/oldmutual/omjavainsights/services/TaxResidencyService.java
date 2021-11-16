package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.dto.ContractDTO;
import com.oldmutual.omjavainsights.model.dto.TaxResidencyDTO;
import com.oldmutual.omjavainsights.model.mapper.ITaxResidencyMapper;
import com.oldmutual.omjavainsights.repositories.ITaxResidencyRepository;
import com.oldmutual.omjavainsights.services.interfaces.ITaxResidencyService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class TaxResidencyService implements ITaxResidencyService {

    private final ITaxResidencyMapper taxResidencyMapper;
    private final ITaxResidencyRepository taxResidencyRepository;

    public TaxResidencyService(ITaxResidencyMapper taxResidencyMapper, ITaxResidencyRepository taxResidencyRepository) {
        this.taxResidencyMapper = taxResidencyMapper;
        this.taxResidencyRepository = taxResidencyRepository;
    }


    @Override
    public TaxResidencyDTO getTaxResidencyById(Long id) {
        try {

            var taxResidency = taxResidencyRepository.findById(id).get();
            return taxResidencyMapper.taxResidencyToTaxResidencyDTO(taxResidency);
        } catch (Exception e) {

            //todo implement logging
            return new TaxResidencyDTO();
        }
    }
}
