package com.oldmutual.omjavainsights.repositories;

import com.oldmutual.omjavainsights.model.BusinessTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBusinessTransactionRepository extends JpaRepository<BusinessTransaction, Long> {
}
