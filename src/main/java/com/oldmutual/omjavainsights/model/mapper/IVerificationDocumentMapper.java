package com.oldmutual.omjavainsights.model.mapper;

import com.oldmutual.omjavainsights.model.VerificationDocument;
import com.oldmutual.omjavainsights.model.dto.VerificationDocumentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IVerificationDocumentMapper {

    // todo add mapping needed for VerificationDocument and VerificationDocument dto
    VerificationDocumentDTO verDocToVerDocDTO(VerificationDocument verificationDocument);

    // todo add mapping needed for VerificationDocument and VerificationDocument dto
    VerificationDocument verDocDTOToVerDoc(VerificationDocumentDTO verificationDocumentDTO);

    //List Conversions
    List<VerificationDocumentDTO> verDocListToVerDocDTOList(List<VerificationDocument> verificationDocuments);
    List<VerificationDocument> verDocDTOListToVerDocList(List<VerificationDocumentDTO> verificationDocumentsDTO);
}
