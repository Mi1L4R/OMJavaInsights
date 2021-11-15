package com.oldmutual.omjavainsights.controllers;

import com.oldmutual.omjavainsights.model.dto.AddressDTO;
import com.oldmutual.omjavainsights.services.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<AddressDTO> getAddressById() {

        System.out.println("#################################Printing");
        return new ResponseEntity<>(new AddressDTO(), HttpStatus.OK);
//        var addDto = addressService.getAddressById(id);
//
//        if(addDto == null){
//            return new AddressDTO();
//        }
//
//        return addDto;
    }
}
