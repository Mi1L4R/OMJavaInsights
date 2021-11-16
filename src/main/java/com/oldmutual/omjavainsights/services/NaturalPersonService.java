package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.dto.ContractDTO;
import com.oldmutual.omjavainsights.model.dto.NaturalPersonDTO;
import com.oldmutual.omjavainsights.model.mapper.INaturalPersonMapper;
import com.oldmutual.omjavainsights.repositories.INaturalPersonRepository;
import com.oldmutual.omjavainsights.services.interfaces.INaturalPersonService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class NaturalPersonService implements INaturalPersonService {

    private final INaturalPersonMapper naturalPersonMapper;
    private final INaturalPersonRepository naturalPersonRepository;

    public NaturalPersonService(INaturalPersonMapper naturalPersonMapper, INaturalPersonRepository naturalPersonRepository) {
        this.naturalPersonMapper = naturalPersonMapper;
        this.naturalPersonRepository = naturalPersonRepository;
    }

    @Override
    public NaturalPersonDTO getNaturalPersonById(Long id) {

        try {

            var natPerson = naturalPersonRepository.findById(id).get();
            return naturalPersonMapper.natPerToNatPerDTO(natPerson);
        } catch (Exception e) {

            //todo implement logging
            return new NaturalPersonDTO();
        }
    }
}
