package com.oldmutual.omjavainsights.repositories;

import com.oldmutual.omjavainsights.model.DHAVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDHAVerificationRepository extends JpaRepository<DHAVerification, Long> {
}
