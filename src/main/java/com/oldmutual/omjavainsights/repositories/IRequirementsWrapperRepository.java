package com.oldmutual.omjavainsights.repositories;

import com.oldmutual.omjavainsights.model.RequirementsWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRequirementsWrapperRepository extends JpaRepository<RequirementsWrapper, Long> {
}
