package com.restfulapi.sales.domain.repository;

import com.restfulapi.sales.domain.entity.Client;
import com.restfulapi.sales.domain.entity.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientOrders extends JpaRepository<ClientOrder, Integer> {
    List<ClientOrder> findByClient(Client client);
}
