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
    private String username;
    private String cpf;
    private String clientFirstName;
    private String clientLastName;
    private BigDecimal total;
    private String orderDate;
    private String orderStatus;
    private List<ClientOrderItemInformationDTO> items;
}
