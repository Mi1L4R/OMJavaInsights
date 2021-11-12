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

    @Column(name = "ModifiedOn")
    private Date modifiedOn;

    @ManyToMany(mappedBy = "contracts")
    private List<BusinessTransaction> businessTransactions;


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
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Contract contract = (Contract) o;
        return contractId != null && Objects.equals(contractId, contract.contractId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
