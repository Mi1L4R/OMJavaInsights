package com.oldmutual.omjavainsights.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressId")
    private Long addressId;

    @Column(name = "AddressLineOne")
    private String addressLineOne;

    @Column(name = "AddressLineTwo")
    private String addressLineTwo;

    @Column(name = "AddressLineThree")
    private String addressLineThree;

    @Column(name = "AddressLineFour")
    private String addressLineFour;

    @Column(name = "City")
    private String city;

    @Column(name = "PostalCode")
    private String postalCode;

    @OneToOne //todo find out cascading type
    @JoinColumn(name = "countryId", referencedColumnName = "countryId")
    private Country country;

    @Column(name = "CareOfIndicator")
    private String careOfIndicator;

    @Column(name = "CareOfName")
    private String careOfName;

    @Column(name = "ModifiedOn")
    private Date modifiedOn;

    @ManyToOne(fetch = FetchType.LAZY)
    private NaturalPerson naturalPerson;

    public Address(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Address address = (Address) o;
        return addressId != null && Objects.equals(addressId, address.addressId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
