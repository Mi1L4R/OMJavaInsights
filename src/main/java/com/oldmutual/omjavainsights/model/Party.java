package com.oldmutual.omjavainsights.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "Party")
public class Party {  //Doesn't exist in Rules Model on ODM, Added for convenience

    @Id
    @Column(name = "LisId")
    private String lisId;

    @Column(name = "PartyType")
    private String partyType;

    @OneToMany(mappedBy = "party")//todo figure out cascade type and orphanRemoval
    private List<ContractRole> contractRoles = new ArrayList<>();

    @OneToOne(mappedBy = "party")
    private NaturalPerson naturalPerson;

    @OneToMany(mappedBy = "party")
    private List<AssociatedParty> associatedParties;

    @ManyToMany(mappedBy = "parties")
    private List<BusinessTransaction> businessTransactions = new ArrayList<>();


    public Party() {
    }

    public void addContractRole(ContractRole contractRole){
        contractRoles.add(contractRole);
        contractRole.setParty(this);
    }

    public void removeContractRole(ContractRole contractRole){
        contractRoles.remove(contractRole);
        contractRole.setParty(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Party)) return false;

        Party party = (Party) o;

        if (getLisId() != null ? !getLisId().equals(party.getLisId()) : party.getLisId() != null) return false;
        if (getPartyType() != null ? !getPartyType().equals(party.getPartyType()) : party.getPartyType() != null)
            return false;
        if (getContractRoles() != null ? !getContractRoles().equals(party.getContractRoles()) : party.getContractRoles() != null)
            return false;
        if (getNaturalPerson() != null ? !getNaturalPerson().equals(party.getNaturalPerson()) : party.getNaturalPerson() != null)
            return false;
        if (getAssociatedParties() != null ? !getAssociatedParties().equals(party.getAssociatedParties()) : party.getAssociatedParties() != null)
            return false;
        return getBusinessTransactions() != null ? getBusinessTransactions().equals(party.getBusinessTransactions()) : party.getBusinessTransactions() == null;
    }

    @Override
    public int hashCode() {
        int result = getLisId() != null ? getLisId().hashCode() : 0;
        result = 31 * result + (getPartyType() != null ? getPartyType().hashCode() : 0);
        result = 31 * result + (getContractRoles() != null ? getContractRoles().hashCode() : 0);
        result = 31 * result + (getNaturalPerson() != null ? getNaturalPerson().hashCode() : 0);
        result = 31 * result + (getAssociatedParties() != null ? getAssociatedParties().hashCode() : 0);
        result = 31 * result + (getBusinessTransactions() != null ? getBusinessTransactions().hashCode() : 0);
        return result;
    }
}
