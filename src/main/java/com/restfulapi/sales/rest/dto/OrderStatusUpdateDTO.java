package com.restfulapi.sales.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderStatusUpdateDTO {
    private String newStatus;
}
