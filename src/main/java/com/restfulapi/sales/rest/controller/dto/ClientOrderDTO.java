package com.restfulapi.sales.rest.controller.dto;

import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientOrderDTO {
    private Integer client;
    private BigDecimal total;
    private List<ClientOrderItemDTO> items;
}
