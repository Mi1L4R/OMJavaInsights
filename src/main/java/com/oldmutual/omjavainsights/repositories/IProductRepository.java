package com.oldmutual.omjavainsights.repositories;

import com.oldmutual.omjavainsights.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}
