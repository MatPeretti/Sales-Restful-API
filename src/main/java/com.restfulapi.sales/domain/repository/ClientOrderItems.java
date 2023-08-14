package com.restfulapi.sales.domain.repository;

import ch.qos.logback.core.net.server.Client;
import com.restfulapi.sales.domain.entity.ClientOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientOrderItems extends JpaRepository<ClientOrderItem, Integer> {
}
