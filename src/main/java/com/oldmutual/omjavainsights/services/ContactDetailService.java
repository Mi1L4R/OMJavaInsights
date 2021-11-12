package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.dto.ContactDetailDTO;
import com.oldmutual.omjavainsights.model.mapper.IContactDetailMapper;
import com.oldmutual.omjavainsights.repositories.IContactDetailRepository;
import com.oldmutual.omjavainsights.services.interfaces.IContactDetailService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ContactDetailService implements IContactDetailService {

    private final IContactDetailMapper contactDetailMapper;
    private final IContactDetailRepository contactDetailRepository;

    public ContactDetailService(IContactDetailMapper contactDetailMapper, IContactDetailRepository contactDetailRepository) {
        this.contactDetailMapper = contactDetailMapper;
        this.contactDetailRepository = contactDetailRepository;
    }

    @Override
    public ContactDetailDTO getContactDetailById(Long id) {
        return contactDetailRepository.findById(id).stream()
                .map(contactDetail -> contactDetailMapper.contactDetailToContactDetailDTO(contactDetail))
                .collect(Collectors.toList()).get(0);
    }
}
