package com.oldmutual.omjavainsights.repositories;

import com.oldmutual.omjavainsights.model.BusinessTransaction;
import com.oldmutual.omjavainsights.repositories.custom.repository.ICustomBusinessTransactionRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBusinessTransactionRepository extends JpaRepository<BusinessTransaction, Long>, ICustomBusinessTransactionRepository {
}
