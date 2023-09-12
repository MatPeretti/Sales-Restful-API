package com.restfulapi.sales.rest.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientOrderDTO {
    @NotNull(message = "Client must have an ID")
    private Integer client;
    @NotNull(message = "Total cannot be empty")
    private BigDecimal total;
    private List<ClientOrderItemDTO> items;
}
