package com.oldmutual.omjavainsights.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "BusinessTransaction")
public class BusinessTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BusinessTransactionId")
    private Long businessTransactionId;

    @ManyToMany//todo cascade types
    @JoinTable(name = "busTrans_party",
            joinColumns = @JoinColumn(name = "businessTransactionId"),
            inverseJoinColumns = @JoinColumn(name = "partyId")
    )
    @ToString.Exclude
    private List<Party> parties;

    @ManyToMany//todo cascade types
    @JoinTable(name = "busTrans_contract",
            joinColumns = @JoinColumn(name = "businessTransactionId"),
            inverseJoinColumns = @JoinColumn(name = "contractId")
    )
    @ToString.Exclude
    private List<Contract> contracts;



    public BusinessTransaction(){

    }

    public void addParty(Party party){
        parties.add(party);
        party.getBusinessTransactions().add(this);
    }

    public void removeParty(Party party){
        parties.remove(party);
        party.getBusinessTransactions().remove(this);
    }

    public void addContract(Contract contract){
        contracts.add(contract);
        contract.getBusinessTransactions().add(this);
    }

    public void removeContract(Contract contract){
        contracts.remove(contract);
        contract.getBusinessTransactions().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BusinessTransaction that = (BusinessTransaction) o;
        return businessTransactionId != null && Objects.equals(businessTransactionId, that.businessTransactionId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
