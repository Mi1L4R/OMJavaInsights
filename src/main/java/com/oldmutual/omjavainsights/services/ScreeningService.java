package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.dto.ScreeningDTO;
import com.oldmutual.omjavainsights.model.mapper.IScreeningMapper;
import com.oldmutual.omjavainsights.repositories.IScreeningRepository;
import com.oldmutual.omjavainsights.services.interfaces.IScreeningService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ScreeningService implements IScreeningService {

    private final IScreeningMapper screeningMapper;
    private final IScreeningRepository screeningRepository;

    public ScreeningService(IScreeningMapper screeningMapper, IScreeningRepository screeningRepository) {
        this.screeningMapper = screeningMapper;
        this.screeningRepository = screeningRepository;
    }

    @Override
    public ScreeningDTO getScreeningById(Long id) {
        return screeningRepository.findById(id).stream()
                .map(screening -> screeningMapper.screeningToScreeningDTO(screening))
                .collect(Collectors.toList()).get(0);
    }
}
