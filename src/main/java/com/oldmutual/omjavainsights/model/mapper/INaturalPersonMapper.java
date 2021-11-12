package com.oldmutual.omjavainsights.model.mapper;

import com.oldmutual.omjavainsights.model.NaturalPerson;
import com.oldmutual.omjavainsights.model.dto.NaturalPersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {
        IDHAVerificationMapper.class,
        IAddressMapper.class,
        IContactDetailMapper.class,
        IContractMapper.class,
        ICountryMapper.class,
        IIdentificationDetailMapper.class,
        IRoleMapper.class,
        IScreeningMapper.class,
        ITaxResidencyMapper.class,
        IVerificationDocumentMapper.class,
        IRequirementMapper.class,
        IPartyMapper.class
})
public interface INaturalPersonMapper {

    INaturalPersonMapper INSTANCE = Mappers.getMapper(INaturalPersonMapper.class);

    //Todo add actual mappings, as there is no difference for now between NaturalPerson and its DTO
    //@Mappings()
    NaturalPersonDTO natPerToNatPerDTO(NaturalPerson naturalPerson);
    NaturalPerson natPerDTOToNatPer(NaturalPersonDTO naturalPersonDTO);

    //List Conversions
    List<NaturalPersonDTO> natPerListToNatPerDTOList(List<NaturalPerson> naturalPersons);
    List<NaturalPerson> natPerDTOListToNatPerList(List<NaturalPersonDTO> naturalPersonsDTO);
}
