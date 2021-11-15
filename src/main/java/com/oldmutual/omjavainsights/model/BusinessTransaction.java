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
        if (!(o instanceof BusinessTransaction)) return false;

        BusinessTransaction that = (BusinessTransaction) o;

        if (getBusinessTransactionId() != null ? !getBusinessTransactionId().equals(that.getBusinessTransactionId()) : that.getBusinessTransactionId() != null)
            return false;
        if (getParties() != null ? !getParties().equals(that.getParties()) : that.getParties() != null) return false;
        return getContracts() != null ? getContracts().equals(that.getContracts()) : that.getContracts() == null;
    }

    @Override
    public int hashCode() {
        int result = getBusinessTransactionId() != null ? getBusinessTransactionId().hashCode() : 0;
        result = 31 * result + (getParties() != null ? getParties().hashCode() : 0);
        result = 31 * result + (getContracts() != null ? getContracts().hashCode() : 0);
        return result;
    }
}
