package com.restfulapi.sales.domain.repository;

import com.restfulapi.sales.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Products extends JpaRepository<Product, Integer> {
}
