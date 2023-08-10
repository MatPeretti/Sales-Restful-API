package com.restfulapi.sales.domain.repository;

import com.restfulapi.sales.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Clients extends JpaRepository<Client, Integer> {
    @Query(value = " select * from client c where c.name like '%:name' ", nativeQuery = true)
    List<Client> findByName(@Param("name") String name);
}
