package com.oldmutual.omjavainsights.repositories;

import com.oldmutual.omjavainsights.model.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRequirementRepository extends JpaRepository<Requirement, Long> {
}
