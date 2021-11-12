package com.oldmutual.omjavainsights.repositories;

import com.oldmutual.omjavainsights.model.IdentificationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIdentificationDetailRepository extends JpaRepository<IdentificationDetail, Long> {
}
