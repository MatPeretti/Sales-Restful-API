package com.restfulapi.sales.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientOrderInformationsDTO {
    private Integer orderId;
    private String clientName;
    private BigDecimal total;
    private String orderDate;
    private List<ClientOrderItemInformationDTO> items;
}
