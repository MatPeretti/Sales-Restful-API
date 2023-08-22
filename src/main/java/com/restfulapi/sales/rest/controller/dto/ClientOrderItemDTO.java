package com.restfulapi.sales.rest.controller.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientOrderItemDTO {
    private Integer product;
    private Integer quantity;
}
