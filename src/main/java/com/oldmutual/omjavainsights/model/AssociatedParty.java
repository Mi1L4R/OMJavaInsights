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
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AssociatedParty that = (AssociatedParty) o;
        return associatedPartyId != null && Objects.equals(associatedPartyId, that.associatedPartyId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
