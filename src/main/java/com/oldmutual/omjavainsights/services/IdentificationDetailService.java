package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.dto.IdentificationDetailDTO;
import com.oldmutual.omjavainsights.model.mapper.IIdentificationDetailMapper;
import com.oldmutual.omjavainsights.repositories.IIdentificationDetailRepository;
import com.oldmutual.omjavainsights.services.interfaces.IIdentificationDetailService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class IdentificationDetailService implements IIdentificationDetailService {

    private final IIdentificationDetailMapper identificationDetailMapper;
    private final IIdentificationDetailRepository identificationDetailRepository;

    public IdentificationDetailService(IIdentificationDetailMapper identificationDetailMapper, IIdentificationDetailRepository identificationDetailRepository) {
        this.identificationDetailMapper = identificationDetailMapper;
        this.identificationDetailRepository = identificationDetailRepository;
    }

    @Override
    public IdentificationDetailDTO getIdDetailById(Long id) {
        return identificationDetailRepository.findById(id).stream()
                .map(identificationDetail -> identificationDetailMapper.idDetailToIdDetailDTO(identificationDetail))
                .collect(Collectors.toList()).get(0);
    }
}
