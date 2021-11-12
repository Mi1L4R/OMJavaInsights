package com.oldmutual.omjavainsights.model.mapper;

import com.oldmutual.omjavainsights.model.ContactDetail;
import com.oldmutual.omjavainsights.model.dto.ContactDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IContactDetailMapper {

    IContactDetailMapper INSTANCE = Mappers.getMapper(IContactDetailMapper.class);

    // todo add mapping needed for contactDetail and contactDetail dto
    ContactDetailDTO contactDetailToContactDetailDTO(ContactDetail contactDetail);

    // todo add mapping needed for contactDetail and contactDetail dto
    ContactDetail contactDetailDTOToContactDetail(ContactDetailDTO contactDetailDTO);

    //List conversions
    List<ContactDetailDTO> cDetailListToCDetailDTOList(List<ContactDetail> contactDetails);
    List<ContactDetail> cDetailListDTOToCDetailList(List<ContactDetailDTO> contactDetailsDTO);
}
