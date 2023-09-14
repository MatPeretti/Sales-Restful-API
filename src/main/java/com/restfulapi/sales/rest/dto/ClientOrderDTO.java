package com.restfulapi.sales.rest.dto;

import com.restfulapi.sales.rest.validation.NotEmptyList;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientOrderDTO {
    @NotNull(message = "{requiredfield.client-id}")
    private Integer client;
    @NotNull(message = "{requiredfield.totalorder}")
    private BigDecimal total;
    @NotEmptyList(message = "{requiredfield.orderitems}")
    private List<ClientOrderItemDTO> items;
}
