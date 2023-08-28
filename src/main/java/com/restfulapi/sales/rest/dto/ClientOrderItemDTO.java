package com.restfulapi.sales.rest.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientOrderItemDTO {
    private Integer product;
    private Integer quantity;
}
