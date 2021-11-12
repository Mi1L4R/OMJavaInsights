package com.oldmutual.omjavainsights.repositories;

import com.oldmutual.omjavainsights.model.ContactDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactDetailRepository extends JpaRepository<ContactDetail, Long> {
}
