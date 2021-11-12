package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.dto.VerificationDocumentDTO;
import com.oldmutual.omjavainsights.model.mapper.IVerificationDocumentMapper;
import com.oldmutual.omjavainsights.repositories.IVerificationDocumentRepository;
import com.oldmutual.omjavainsights.services.interfaces.IVerificationDocumentService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class VerificationDocumentService implements IVerificationDocumentService {

    private final IVerificationDocumentMapper verificationDocumentMapper;
    private final IVerificationDocumentRepository verificationDocumentRepository;

    public VerificationDocumentService(IVerificationDocumentMapper verificationDocumentMapper, IVerificationDocumentRepository verificationDocumentRepository) {
        this.verificationDocumentMapper = verificationDocumentMapper;
        this.verificationDocumentRepository = verificationDocumentRepository;
    }

    @Override
    public VerificationDocumentDTO getVerDocById(Long id) {
        return verificationDocumentRepository.findById(id).stream()
                .map(verificationDocument -> verificationDocumentMapper.verDocToVerDocDTO(verificationDocument))
                .collect(Collectors.toList()).get(0);
    }
}
