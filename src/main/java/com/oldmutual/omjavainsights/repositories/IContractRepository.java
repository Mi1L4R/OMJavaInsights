package com.oldmutual.omjavainsights.repositories;

import com.oldmutual.omjavainsights.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Long> {
}
