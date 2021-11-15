package com.oldmutual.omjavainsights.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "Contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ContractId")
    private Long contractId;

    @Column(name = "BusinessUnit")
    private String businessUnit;

    @Column(name = "ContractSource")
    private String contractSource;

    @Column(name = "Premium")
    private String premium;

    @Column(name = "PremiumFrequency")
    private String premiumFrequency;

    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "EndDate")
    private Date endDate;

    @OneToMany(mappedBy = "contract")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "contract")
    //todo: figure out cascade type, as well as, figure out if child objects should be removed if orphaned (i.e. cannot be accessed by parent)
    private List<ContractRole> contractRoles = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private NaturalPerson naturalPerson;

    @ManyToMany(mappedBy = "contracts")
    private List<BusinessTransaction> businessTransactions;

    @Column(name = "ModifiedOn")
    private Date modifiedOn;




    public Contract() {
    }

    public void addContractRole(ContractRole contractRole){
        contractRoles.add(contractRole);
        contractRole.setContract(this);
    }

    public void removeContractRole(ContractRole contractRole){
        contractRoles.remove(contractRole);
        contractRole.setContract(null);
    }

    public void removeProduct(Product product){
        products.remove(product);
        product.setContract(null);
    }

    public void addProduct(Product product){
        products.add(product);
        product.setContract(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contract)) return false;

        Contract contract = (Contract) o;

        if (getContractId() != null ? !getContractId().equals(contract.getContractId()) : contract.getContractId() != null)
            return false;
        if (getBusinessUnit() != null ? !getBusinessUnit().equals(contract.getBusinessUnit()) : contract.getBusinessUnit() != null)
            return false;
        if (getContractSource() != null ? !getContractSource().equals(contract.getContractSource()) : contract.getContractSource() != null)
            return false;
        if (getPremium() != null ? !getPremium().equals(contract.getPremium()) : contract.getPremium() != null)
            return false;
        if (getPremiumFrequency() != null ? !getPremiumFrequency().equals(contract.getPremiumFrequency()) : contract.getPremiumFrequency() != null)
            return false;
        if (getStartDate() != null ? !getStartDate().equals(contract.getStartDate()) : contract.getStartDate() != null)
            return false;
        if (getEndDate() != null ? !getEndDate().equals(contract.getEndDate()) : contract.getEndDate() != null)
            return false;
        if (getProducts() != null ? !getProducts().equals(contract.getProducts()) : contract.getProducts() != null)
            return false;
        if (getContractRoles() != null ? !getContractRoles().equals(contract.getContractRoles()) : contract.getContractRoles() != null)
            return false;
        if (getNaturalPerson() != null ? !getNaturalPerson().equals(contract.getNaturalPerson()) : contract.getNaturalPerson() != null)
            return false;
        if (getBusinessTransactions() != null ? !getBusinessTransactions().equals(contract.getBusinessTransactions()) : contract.getBusinessTransactions() != null)
            return false;
        return getModifiedOn() != null ? getModifiedOn().equals(contract.getModifiedOn()) : contract.getModifiedOn() == null;
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
