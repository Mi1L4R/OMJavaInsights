package com.oldmutual.omjavainsights.repositories;

import com.oldmutual.omjavainsights.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
}
