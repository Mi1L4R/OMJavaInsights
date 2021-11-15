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
@Table(name = "AssociatedParty")
public class AssociatedParty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AssociatedPartyId")
    private Long associatedPartyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Party party;

    //Todo find out if we need role in here

    public AssociatedParty(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssociatedParty)) return false;

        AssociatedParty that = (AssociatedParty) o;

        if (getAssociatedPartyId() != null ? !getAssociatedPartyId().equals(that.getAssociatedPartyId()) : that.getAssociatedPartyId() != null)
            return false;
        return getParty() != null ? getParty().equals(that.getParty()) : that.getParty() == null;
    }

    @Override
    public int hashCode() {
        int result = getAssociatedPartyId() != null ? getAssociatedPartyId().hashCode() : 0;
        result = 31 * result + (getParty() != null ? getParty().hashCode() : 0);
        return result;
    }
}
