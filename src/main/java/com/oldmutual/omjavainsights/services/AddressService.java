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
            return addressRepository.findById(id).stream()
                    .map(address -> addressMapper.addressToAddressDTO(address))
                    .collect(Collectors.toList()).get(0);

        }catch (Exception e){
            System.out.println(e);
            return new AddressDTO();
        }

    }
}
