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
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ContractRole that = (ContractRole) o;
        return contractRoleId != null && Objects.equals(contractRoleId, that.contractRoleId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
