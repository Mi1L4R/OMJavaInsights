package com.oldmutual.omjavainsights.model.dto;

import lombok.Data;

@Data
public class AssociatedPartyDTO {

    private Long associatedPartyId;
    private PartyDTO party;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssociatedPartyDTO)) return false;

        AssociatedPartyDTO that = (AssociatedPartyDTO) o;

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
