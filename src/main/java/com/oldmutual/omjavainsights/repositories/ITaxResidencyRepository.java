package com.oldmutual.omjavainsights.repositories;

import com.oldmutual.omjavainsights.model.TaxResidency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaxResidencyRepository extends JpaRepository<TaxResidency, Long> {
}
