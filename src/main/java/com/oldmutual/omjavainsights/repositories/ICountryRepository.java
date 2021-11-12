package com.oldmutual.omjavainsights.repositories;

import com.oldmutual.omjavainsights.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository extends JpaRepository<Country, Long> {
}
