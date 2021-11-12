package com.oldmutual.omjavainsights.repositories;

import com.oldmutual.omjavainsights.model.ContractRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRoleRepository extends JpaRepository<ContractRole, Long> {
}
