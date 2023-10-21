package com.restfulapi.sales.domain.repository;

import com.restfulapi.sales.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Clients extends JpaRepository<Client, Integer> {
    Optional<Client> findByUsername(String username);
}
