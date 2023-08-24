package com.restfulapi.sales.service;

import com.restfulapi.sales.domain.entity.ClientOrder;
import com.restfulapi.sales.rest.controller.dto.ClientOrderDTO;

public interface ClientOrderService {
    ClientOrder save(ClientOrderDTO dto);
}
