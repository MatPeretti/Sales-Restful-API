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
    @Bean
    public CommandLineRunner init(@Autowired Clients clients, @Autowired ClientOrders clientOrders){
        return args -> {
            Client firstClient = new Client("John");
            clients.save(firstClient);

            ClientOrder cltorder = new ClientOrder();
            cltorder.setClient(firstClient);
            cltorder.setOrderDate(LocalDate.now());
            cltorder.setTotal(BigDecimal.valueOf(100));
            clientOrders.save(cltorder);

            clientOrders.findByClient(firstClient).forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }

}
