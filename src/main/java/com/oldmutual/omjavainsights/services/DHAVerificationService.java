package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.dto.DHAVerificationDTO;
import com.oldmutual.omjavainsights.model.mapper.IDHAVerificationMapper;
import com.oldmutual.omjavainsights.repositories.IDHAVerificationRepository;
import com.oldmutual.omjavainsights.services.interfaces.IDHAVerificationService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class DHAVerificationService implements IDHAVerificationService {

    private final IDHAVerificationMapper verificationMapper;
    private final IDHAVerificationRepository verificationRepository;

    public DHAVerificationService(IDHAVerificationMapper verificationMapper, IDHAVerificationRepository verificationRepository) {
        this.verificationMapper = verificationMapper;
        this.verificationRepository = verificationRepository;
    }

    @Override
    public DHAVerificationDTO getDHAVerificationById(Long id) {
        return verificationRepository.findById(id).stream()
                .map(dhaVerification -> verificationMapper.dhaVerificationTodhaVerificationDTO(dhaVerification))
                .collect(Collectors.toList()).get(0);
    }
}
