package com.oldmutual.omjavainsights.model.mapper;

import com.oldmutual.omjavainsights.model.Address;
import com.oldmutual.omjavainsights.model.dto.AddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = ICountryMapper.class)
public interface IAddressMapper {

    IAddressMapper INSTANCE = Mappers.getMapper(IAddressMapper.class);

    // todo add mapping needed for address and address dto
    AddressDTO addressToAddressDTO(Address address);

    // todo add mapping needed for address and address dto
    Address addressDTOToAddress(AddressDTO addressDTO);

    //List Conversions
    List<AddressDTO> addressListToAddressListDTO(List<Address> addresses);
    List<Address> addressListDTOToAddressList(List<AddressDTO> addressesDTO);
}
