package com.restfulapi.sales.domain.repository;

import com.restfulapi.sales.domain.entity.Client;
import com.restfulapi.sales.domain.entity.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientOrders extends JpaRepository<ClientOrder, Integer> {
    List<ClientOrder> findByClient(Client client);

    @Query("select x from ClientOrder x left join fetch x.clientOrderItems where x.id = :id")
    Optional<ClientOrder> findByIdFetchClientOrderItems(@Param("id") Integer id);

}
