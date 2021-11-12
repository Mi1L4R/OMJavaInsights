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
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Party party = (Party) o;
        return lisId != null && Objects.equals(lisId, party.lisId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
