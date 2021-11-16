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

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long id) {


        var addDto = addressService.getAddressById(id);

        if(addDto == null || addDto.equals(new AddressDTO())){
            return new ResponseEntity<>(new AddressDTO(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(addDto, HttpStatus.OK);
    }
}
