package com.oldmutual.omjavainsights.repositories;

import com.oldmutual.omjavainsights.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScreeningRepository extends JpaRepository<Screening, Long> {
}
