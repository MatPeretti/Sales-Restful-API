package com.restfulapi.sales.rest.controller;

import com.restfulapi.sales.domain.entity.ClientOrder;
import com.restfulapi.sales.rest.controller.dto.ClientOrderDTO;
import com.restfulapi.sales.service.ClientOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
