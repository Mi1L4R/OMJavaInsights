package com.oldmutual.omjavainsights.model.dto;

import com.oldmutual.omjavainsights.generics.GenericsForDTO;
import com.oldmutual.omjavainsights.model.ContractRole;
import com.oldmutual.omjavainsights.model.NaturalPerson;
import com.oldmutual.omjavainsights.model.Product;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
public class ContractDTO {

    private Long contractId;
    private String businessUnit;
    private String contractSource;
    private String premium;
    private String premiumFrequency;
    private Date startDate;
    private Date endDate;
    private List<ProductDTO> products;
    private List<ContractRoleDTO> contractRoles;
    private Date modifiedOn;


    //Generic methods for adding and removing dto from dtoList
    public void addContractRole(ContractRoleDTO contractRoleDTO){
        GenericsForDTO.addDTOObjectToList(contractRoleDTO,contractRoles);
    }

    public void removeContractRole(ContractRoleDTO contractRoleDTO){
        GenericsForDTO.removeDTOObjectFromList(contractRoleDTO,contractRoles);
    }

    public void addProduct(ProductDTO productDTO){
        GenericsForDTO.addDTOObjectToList(productDTO,products);
    }

    public void removeProduct(ProductDTO productDTO){
        GenericsForDTO.removeDTOObjectFromList(productDTO,products);
    }

}
