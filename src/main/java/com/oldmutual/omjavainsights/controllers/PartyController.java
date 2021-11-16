package com.oldmutual.omjavainsights.controllers;

import com.oldmutual.omjavainsights.model.BusinessTransaction;
import com.oldmutual.omjavainsights.model.Contract;
import com.oldmutual.omjavainsights.model.dto.BusinessTransactionDTO;
import com.oldmutual.omjavainsights.model.dto.ContractDTO;
import com.oldmutual.omjavainsights.model.dto.PartyDTO;
import com.oldmutual.omjavainsights.model.mapper.IBusinessTransactionMapper;
import com.oldmutual.omjavainsights.model.mapper.IContractMapper;
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
    private final IContractMapper contractMapper;

    public PartyController(PartyService partyService, IBusinessTransactionMapper businessTransactionMapper, IContractMapper contractMapper) {
        this.partyService = partyService;
        this.businessTransactionMapper = businessTransactionMapper;
        this.contractMapper = contractMapper;
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

    @GetMapping("/transaction")
    @ResponseBody
    public ResponseEntity<List<PartyDTO>> getPartiesByBusinessTransaction(@RequestBody Object object){//using object as request could come through as normal or DTO

        BusinessTransactionDTO businessTransactionDTO = null;

        if(object instanceof BusinessTransaction){
            var tempObj = (BusinessTransaction) object;
            businessTransactionDTO = businessTransactionMapper.busTransToBusTransDTO(tempObj);

        }else if(object instanceof BusinessTransactionDTO){
            businessTransactionDTO = (BusinessTransactionDTO) object;
        }

        return getDTOListForParty(businessTransactionDTO);
    }


    @GetMapping("/contract")
    @ResponseBody
    public  ResponseEntity<List<PartyDTO>> getPartiesByContract(@RequestBody Object object){

        ContractDTO contractDTO = null;

        if(object instanceof Contract){
            var tempObj = (Contract) object;
            contractDTO = contractMapper.contractToContractDTO(tempObj);
        }else if(object instanceof ContractDTO){
            contractDTO = (ContractDTO) object;
        }
        return getDTOListForParty(contractDTO);
    }


    @NotNull
    private ResponseEntity<List<PartyDTO>> getDTOListForParty(BusinessTransactionDTO businessTransactionDTO) {
        var partiesDTO = partyService.getPartiesByTransaction(businessTransactionDTO);

        if(partiesDTO == null || partiesDTO.size() == 0){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(partiesDTO, HttpStatus.OK);
    }

    @NotNull
    private ResponseEntity<List<PartyDTO>> getDTOListForParty(ContractDTO contractDTO){

        var partiesDTO = partyService.getPartiesByContract(contractDTO);

        if(partiesDTO == null || partiesDTO.size() == 0){
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(partiesDTO, HttpStatus.OK);
    }
}
