package com.oldmutual.omjavainsights.controllers;

import com.oldmutual.omjavainsights.model.BusinessTransaction;
import com.oldmutual.omjavainsights.model.Party;
import com.oldmutual.omjavainsights.model.dto.BusinessTransactionDTO;
import com.oldmutual.omjavainsights.model.dto.PartyDTO;
import com.oldmutual.omjavainsights.model.mapper.IPartyMapper;
import com.oldmutual.omjavainsights.services.interfaces.IBusinessTransactionService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class BusinessTransactionController {

    private final IBusinessTransactionService businessTransactionService;

    private final IPartyMapper partyMapper;

    public BusinessTransactionController(IBusinessTransactionService businessTransactionService, IPartyMapper partyMapper) {
        this.businessTransactionService = businessTransactionService;
        this.partyMapper = partyMapper;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<BusinessTransactionDTO> getTransactionById(@PathVariable Long id){

        var transactionDTO = businessTransactionService.getBusinessTransactionById(id);

        if(transactionDTO == null || transactionDTO.equals(new BusinessTransactionDTO())){
            return new ResponseEntity<>(new BusinessTransactionDTO(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(transactionDTO, HttpStatus.OK);
    }

    @GetMapping("/party")
    @ResponseBody
    public ResponseEntity<List<BusinessTransactionDTO>> getTransactionsByParty(@RequestBody Object object){

        PartyDTO partyDTO = null;

        if(object instanceof Party){
            var tempObj = (Party) object;
            partyDTO = partyMapper.partyToPartyDTO(tempObj);
        } else if(object instanceof PartyDTO){
            partyDTO = (PartyDTO) object;
        }

        return getDTOListForTransaction(partyDTO);
    }

    @NotNull
    private ResponseEntity<List<BusinessTransactionDTO>> getDTOListForTransaction(PartyDTO partyDTO){

        var transactionsDTO = businessTransactionService.getBusinessTransactionsByParty(partyDTO);

        if(transactionsDTO == null || transactionsDTO.size() == 0){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(transactionsDTO, HttpStatus.OK);
    }
}
