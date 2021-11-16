package com.oldmutual.omjavainsights.controllers;

import com.oldmutual.omjavainsights.model.BusinessTransaction;
import com.oldmutual.omjavainsights.model.dto.BusinessTransactionDTO;
import com.oldmutual.omjavainsights.model.dto.PartyDTO;
import com.oldmutual.omjavainsights.model.mapper.IBusinessTransactionMapper;
import com.oldmutual.omjavainsights.services.PartyService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/party")
public class PartyController {

    private final PartyService partyService;

    private final IBusinessTransactionMapper businessTransactionMapper;

    public PartyController(PartyService partyService, IBusinessTransactionMapper businessTransactionMapper) {
        this.partyService = partyService;
        this.businessTransactionMapper = businessTransactionMapper;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<PartyDTO> getPartyById(@PathVariable String id){

        var partyDTO = partyService.getPartyById(id);

        if(partyDTO == null || partyDTO.equals(new PartyDTO())){
            return new ResponseEntity<>(new PartyDTO(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(partyDTO, HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<PartyDTO>> getPartyByBusinessTransaction(@RequestBody Object object){//using object as request could come through as normal or DTO

        BusinessTransactionDTO businessTransactionDTO = null;

        if(object instanceof BusinessTransaction){
            var tempObj = (BusinessTransaction) object;
            businessTransactionDTO = businessTransactionMapper.busTransToBusTransDTO(tempObj);

        }else if(object instanceof BusinessTransactionDTO){
            businessTransactionDTO = (BusinessTransactionDTO) object;
        }

        return getDTOListForParty(businessTransactionDTO);
    }


    @NotNull
    private ResponseEntity<List<PartyDTO>> getDTOListForParty(@RequestBody BusinessTransactionDTO businessTransactionDTO) {
        var partiesDTO = partyService.getPartyByTransaction(businessTransactionDTO);

        if(partiesDTO == null || partiesDTO.size() == 0){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(partiesDTO, HttpStatus.OK);
    }
}
