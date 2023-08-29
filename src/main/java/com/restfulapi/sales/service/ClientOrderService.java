package com.restfulapi.sales.service;

import com.restfulapi.sales.domain.entity.ClientOrder;
import com.restfulapi.sales.rest.dto.ClientOrderDTO;

import java.util.Optional;

public interface ClientOrderService {
    ClientOrder save(ClientOrderDTO dto);

    Optional<ClientOrder> getFullOrder(Integer id);
}
