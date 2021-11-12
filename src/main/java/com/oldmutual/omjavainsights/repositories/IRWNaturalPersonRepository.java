package com.oldmutual.omjavainsights.repositories;

import com.oldmutual.omjavainsights.model.RWNaturalPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRWNaturalPersonRepository extends JpaRepository<RWNaturalPerson, Long> {
}
