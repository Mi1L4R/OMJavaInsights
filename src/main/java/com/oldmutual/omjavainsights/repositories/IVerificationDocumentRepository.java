package com.oldmutual.omjavainsights.repositories;

import com.oldmutual.omjavainsights.model.VerificationDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVerificationDocumentRepository extends JpaRepository<VerificationDocument, Long> {
}
