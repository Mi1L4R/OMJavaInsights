package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.Address;
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

    public AddressService(IAddressMapper addressMapper, IAddressRepository addressRepository) {
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressDTO getAddressById(Long id) {
        try{

            var address = addressRepository.findById(id).get();
            return addressMapper.addressToAddressDTO(address);

        }catch (Exception e){

            //todo implement logging
            return new AddressDTO();
        }

    }
}
