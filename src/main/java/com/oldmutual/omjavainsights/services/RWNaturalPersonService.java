package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.dto.ContractDTO;
import com.oldmutual.omjavainsights.model.dto.RWNaturalPersonDTO;
import com.oldmutual.omjavainsights.model.mapper.IRWNaturalPersonMapper;
import com.oldmutual.omjavainsights.repositories.IRWNaturalPersonRepository;
import com.oldmutual.omjavainsights.services.interfaces.IRWNaturalPersonService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RWNaturalPersonService implements IRWNaturalPersonService {

    private final IRWNaturalPersonMapper rwNaturalPersonMapper;
    private final IRWNaturalPersonRepository rwNaturalPersonRepository;

    public RWNaturalPersonService(IRWNaturalPersonMapper rwNaturalPersonMapper,
                                  IRWNaturalPersonRepository rwNaturalPersonRepository) {

        this.rwNaturalPersonMapper = rwNaturalPersonMapper;
        this.rwNaturalPersonRepository = rwNaturalPersonRepository;
    }

    @Override
    public RWNaturalPersonDTO getRWNaturalPersonById(Long id) {
        try {

            var rwNatPerson = rwNaturalPersonRepository.findById(id).get();
            return rwNaturalPersonMapper.rwNatPerTorwNatPerDTO(rwNatPerson);
        } catch (Exception e) {

            //todo implement logging
            return new RWNaturalPersonDTO();
        }
    }
}
