package com.oldmutual.omjavainsights.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "ContractRole")
public class ContractRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ContractRoleId")
    private Long contractRoleId;

    @Column(name = "RoleDescription")
    private String roleDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    private Party party;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Contract contract;



    public ContractRole() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContractRole)) return false;

        ContractRole that = (ContractRole) o;

        if (getContractRoleId() != null ? !getContractRoleId().equals(that.getContractRoleId()) : that.getContractRoleId() != null)
            return false;
        if (getRoleDescription() != null ? !getRoleDescription().equals(that.getRoleDescription()) : that.getRoleDescription() != null)
            return false;
        if (getParty() != null ? !getParty().equals(that.getParty()) : that.getParty() != null) return false;
        return getContract() != null ? getContract().equals(that.getContract()) : that.getContract() == null;
    }

    @Override
    public int hashCode() {
        int result = getContractRoleId() != null ? getContractRoleId().hashCode() : 0;
        result = 31 * result + (getRoleDescription() != null ? getRoleDescription().hashCode() : 0);
        result = 31 * result + (getParty() != null ? getParty().hashCode() : 0);
        result = 31 * result + (getContract() != null ? getContract().hashCode() : 0);
        return result;
    }
}
