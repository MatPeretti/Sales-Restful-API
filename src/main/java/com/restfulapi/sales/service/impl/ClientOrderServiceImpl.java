package com.restfulapi.sales.service.impl;

import com.restfulapi.sales.domain.entity.ClientOrder;
import com.restfulapi.sales.domain.repository.ClientOrders;
import com.restfulapi.sales.service.ClientOrderService;
import org.springframework.stereotype.Service;

@Service
public class ClientOrderServiceImpl implements ClientOrderService {

    private ClientOrders repository;

    public ClientOrderServiceImpl(ClientOrders repository) {
        this.repository = repository;
    }
}
