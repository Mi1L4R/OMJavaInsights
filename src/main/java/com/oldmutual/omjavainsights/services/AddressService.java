package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.dto.AddressDTO;
import com.oldmutual.omjavainsights.model.mapper.IAddressMapper;
import com.oldmutual.omjavainsights.repositories.IAddressRepository;
import com.oldmutual.omjavainsights.services.interfaces.IAddressService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AddressService implements IAddressService {

    private final IAddressMapper addressMapper;
    private final IAddressRepository addressRepository;


    public AddressService(IAddressMapper addressMapper,IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public AddressDTO getAddressById(Long id) {
        return addressRepository.findById(id).stream()
                .map(address -> addressMapper.addressToAddressDTO(address))
                .collect(Collectors.toList()).get(0);
    }
}
