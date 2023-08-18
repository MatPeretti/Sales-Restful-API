package com.restfulapi.sales.rest.controller;

import com.restfulapi.sales.service.ClientOrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clientorder")
public class ClientOrderController {

    private ClientOrderService service;

    public ClientOrderController(ClientOrderService service) {
        this.service = service;
    }

}
