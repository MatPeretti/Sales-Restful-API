package com.restfulapi.sales;

import com.restfulapi.sales.domain.entity.Client;
import com.restfulapi.sales.domain.entity.ClientOrder;
import com.restfulapi.sales.domain.repository.ClientOrders;
import com.restfulapi.sales.domain.repository.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class SalesApplication {
    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }
}
