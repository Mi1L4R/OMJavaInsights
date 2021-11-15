package com.oldmutual.omjavainsights.model.dto;

import com.oldmutual.omjavainsights.generics.GenericsForDTO;
import com.oldmutual.omjavainsights.model.ContractRole;
import com.oldmutual.omjavainsights.model.NaturalPerson;
import com.oldmutual.omjavainsights.model.Product;
import lombok.*;

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
    private NaturalPersonDTO naturalPerson;
    private List<BusinessTransactionDTO> businessTransactions;
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

    public void addBusinessTransaction(BusinessTransactionDTO businessTransactionDTO){
        GenericsForDTO.addDTOObjectToList(businessTransactionDTO, businessTransactions);
    }

    public void removeBusinessTransaction(BusinessTransactionDTO businessTransactionDTO){
        GenericsForDTO.removeDTOObjectFromList(businessTransactionDTO, businessTransactions);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContractDTO)) return false;

        ContractDTO that = (ContractDTO) o;

        if (getContractId() != null ? !getContractId().equals(that.getContractId()) : that.getContractId() != null)
            return false;
        if (getBusinessUnit() != null ? !getBusinessUnit().equals(that.getBusinessUnit()) : that.getBusinessUnit() != null)
            return false;
        if (getContractSource() != null ? !getContractSource().equals(that.getContractSource()) : that.getContractSource() != null)
            return false;
        if (getPremium() != null ? !getPremium().equals(that.getPremium()) : that.getPremium() != null) return false;
        if (getPremiumFrequency() != null ? !getPremiumFrequency().equals(that.getPremiumFrequency()) : that.getPremiumFrequency() != null)
            return false;
        if (getStartDate() != null ? !getStartDate().equals(that.getStartDate()) : that.getStartDate() != null)
            return false;
        if (getEndDate() != null ? !getEndDate().equals(that.getEndDate()) : that.getEndDate() != null) return false;
        if (getProducts() != null ? !getProducts().equals(that.getProducts()) : that.getProducts() != null)
            return false;
        if (getContractRoles() != null ? !getContractRoles().equals(that.getContractRoles()) : that.getContractRoles() != null)
            return false;
        if (getNaturalPerson() != null ? !getNaturalPerson().equals(that.getNaturalPerson()) : that.getNaturalPerson() != null)
            return false;
        if (getBusinessTransactions() != null ? !getBusinessTransactions().equals(that.getBusinessTransactions()) : that.getBusinessTransactions() != null)
            return false;
        return getModifiedOn() != null ? getModifiedOn().equals(that.getModifiedOn()) : that.getModifiedOn() == null;
    }

    @Override
    public int hashCode() {
        int result = getContractId() != null ? getContractId().hashCode() : 0;
        result = 31 * result + (getBusinessUnit() != null ? getBusinessUnit().hashCode() : 0);
        result = 31 * result + (getContractSource() != null ? getContractSource().hashCode() : 0);
        result = 31 * result + (getPremium() != null ? getPremium().hashCode() : 0);
        result = 31 * result + (getPremiumFrequency() != null ? getPremiumFrequency().hashCode() : 0);
        result = 31 * result + (getStartDate() != null ? getStartDate().hashCode() : 0);
        result = 31 * result + (getEndDate() != null ? getEndDate().hashCode() : 0);
        result = 31 * result + (getProducts() != null ? getProducts().hashCode() : 0);
        result = 31 * result + (getContractRoles() != null ? getContractRoles().hashCode() : 0);
        result = 31 * result + (getNaturalPerson() != null ? getNaturalPerson().hashCode() : 0);
        result = 31 * result + (getBusinessTransactions() != null ? getBusinessTransactions().hashCode() : 0);
        result = 31 * result + (getModifiedOn() != null ? getModifiedOn().hashCode() : 0);
        return result;
    }
}
