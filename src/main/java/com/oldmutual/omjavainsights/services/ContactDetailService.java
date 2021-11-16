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

        try{

            var contDetail = contactDetailRepository.findById(id).get();
            return contactDetailMapper.contactDetailToContactDetailDTO(contDetail);
        }
        catch (Exception e){

            //todo implement logging
            return new ContactDetailDTO();
        }
    }
}
