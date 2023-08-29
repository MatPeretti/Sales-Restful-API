package com.restfulapi.sales.rest.controller;

import com.restfulapi.sales.domain.entity.ClientOrder;
import com.restfulapi.sales.domain.entity.ClientOrderItem;
import com.restfulapi.sales.rest.dto.ClientOrderDTO;
import com.restfulapi.sales.rest.dto.ClientOrderInformationsDTO;
import com.restfulapi.sales.rest.dto.ClientOrderItemInformationDTO;
import com.restfulapi.sales.service.ClientOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientorder")
public class ClientOrderController {

    private ClientOrderService service;

    public ClientOrderController(ClientOrderService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody ClientOrderDTO dto){
        ClientOrder clientorder = service.save(dto);
        return clientorder.getId();
    }
    @GetMapping("{id}")
    public ClientOrderInformationsDTO getById(@PathVariable Integer id){
        return service
                .getFullOrder(id)
                .map(p -> convert(p))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    }

    public ClientOrderInformationsDTO convert(ClientOrder order){
        return ClientOrderInformationsDTO
                .builder()
                .orderId(order.getId())
                .clientName(order.getClient().getName())
                .total(order.getTotal())
                .orderDate(order.getOrderDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")))
                .items(convert(order.getClientOrderItems()))
                .build();
    }

    public List<ClientOrderItemInformationDTO> convert(List<ClientOrderItem> items) {
        if (CollectionUtils.isEmpty(items)) {
            return Collections.emptyList();
        }

        return items.stream().map(item -> ClientOrderItemInformationDTO
                .builder()
                .productDescription(item.getProduct().getDescription())
                .unitPrice(item.getProduct().getPrice())
                .quantity(item.getQuantity())
                .build()
        ).collect(Collectors.toList());
    }
}
