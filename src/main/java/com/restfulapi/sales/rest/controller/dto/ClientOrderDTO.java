package com.restfulapi.sales.rest.controller.dto;

import java.math.BigDecimal;
import java.util.List;

public class ClientOrderDTO {

    private Integer client;
    private BigDecimal total;
    private List<ClientOrderItemDTO> items;
}
