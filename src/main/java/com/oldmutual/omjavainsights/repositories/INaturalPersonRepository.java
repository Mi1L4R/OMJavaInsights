package com.oldmutual.omjavainsights.repositories;

import com.oldmutual.omjavainsights.model.NaturalPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INaturalPersonRepository extends JpaRepository<NaturalPerson, Long> {
}
