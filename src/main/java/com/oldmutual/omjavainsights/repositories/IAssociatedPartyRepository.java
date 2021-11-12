package com.oldmutual.omjavainsights.repositories;

import com.oldmutual.omjavainsights.model.AssociatedParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAssociatedPartyRepository extends JpaRepository<AssociatedParty, Long> {
}
