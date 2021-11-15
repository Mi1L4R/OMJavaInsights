package com.oldmutual.omjavainsights.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
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
    @ToString.Exclude
    private NaturalPerson naturalPerson;

    public Address(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (getAddressId() != null ? !getAddressId().equals(address.getAddressId()) : address.getAddressId() != null)
            return false;
        if (getAddressLineOne() != null ? !getAddressLineOne().equals(address.getAddressLineOne()) : address.getAddressLineOne() != null)
            return false;
        if (getAddressLineTwo() != null ? !getAddressLineTwo().equals(address.getAddressLineTwo()) : address.getAddressLineTwo() != null)
            return false;
        if (getAddressLineThree() != null ? !getAddressLineThree().equals(address.getAddressLineThree()) : address.getAddressLineThree() != null)
            return false;
        if (getAddressLineFour() != null ? !getAddressLineFour().equals(address.getAddressLineFour()) : address.getAddressLineFour() != null)
            return false;
        if (getCity() != null ? !getCity().equals(address.getCity()) : address.getCity() != null) return false;
        if (getPostalCode() != null ? !getPostalCode().equals(address.getPostalCode()) : address.getPostalCode() != null)
            return false;
        if (getCountry() != null ? !getCountry().equals(address.getCountry()) : address.getCountry() != null)
            return false;
        if (getCareOfIndicator() != null ? !getCareOfIndicator().equals(address.getCareOfIndicator()) : address.getCareOfIndicator() != null)
            return false;
        if (getCareOfName() != null ? !getCareOfName().equals(address.getCareOfName()) : address.getCareOfName() != null)
            return false;
        if (getModifiedOn() != null ? !getModifiedOn().equals(address.getModifiedOn()) : address.getModifiedOn() != null)
            return false;
        return getNaturalPerson() != null ? getNaturalPerson().equals(address.getNaturalPerson()) : address.getNaturalPerson() == null;
    }

    @Override
    public int hashCode() {
        int result = getAddressId() != null ? getAddressId().hashCode() : 0;
        result = 31 * result + (getAddressLineOne() != null ? getAddressLineOne().hashCode() : 0);
        result = 31 * result + (getAddressLineTwo() != null ? getAddressLineTwo().hashCode() : 0);
        result = 31 * result + (getAddressLineThree() != null ? getAddressLineThree().hashCode() : 0);
        result = 31 * result + (getAddressLineFour() != null ? getAddressLineFour().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getPostalCode() != null ? getPostalCode().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getCareOfIndicator() != null ? getCareOfIndicator().hashCode() : 0);
        result = 31 * result + (getCareOfName() != null ? getCareOfName().hashCode() : 0);
        result = 31 * result + (getModifiedOn() != null ? getModifiedOn().hashCode() : 0);
        result = 31 * result + (getNaturalPerson() != null ? getNaturalPerson().hashCode() : 0);
        return result;
    }
}
