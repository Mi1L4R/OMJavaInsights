package com.oldmutual.omjavainsights.repositories;

import com.oldmutual.omjavainsights.model.Party;
import com.oldmutual.omjavainsights.repositories.custom.repository.ICustomPartyRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPartyRepository extends JpaRepository<Party, String>, ICustomPartyRepository {
}
