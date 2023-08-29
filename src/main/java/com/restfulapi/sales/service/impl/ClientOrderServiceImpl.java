package com.restfulapi.sales.service.impl;

import com.restfulapi.sales.domain.entity.Client;
import com.restfulapi.sales.domain.entity.ClientOrder;
import com.restfulapi.sales.domain.entity.ClientOrderItem;
import com.restfulapi.sales.domain.entity.Product;
import com.restfulapi.sales.domain.repository.ClientOrderItems;
import com.restfulapi.sales.domain.repository.ClientOrders;
import com.restfulapi.sales.domain.repository.Clients;
import com.restfulapi.sales.domain.repository.Products;
import com.restfulapi.sales.exception.invalidCode;
import com.restfulapi.sales.rest.dto.ClientOrderDTO;
import com.restfulapi.sales.rest.dto.ClientOrderItemDTO;
import com.restfulapi.sales.service.ClientOrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientOrderServiceImpl implements ClientOrderService {

    private final ClientOrders repository;
    private final Clients clientsRepository;
    private final Products productsRepository;
    private final ClientOrderItems orderItemsRepository;

    @Override
    @Transactional
    public ClientOrder save(ClientOrderDTO dto){
        Integer clientId = dto.getClient();
        Client client = clientsRepository
                .findById(clientId)
                .orElseThrow(() -> new invalidCode("Client ID not found"));

        ClientOrder clientorder = new ClientOrder();
        clientorder.setTotal(dto.getTotal());
        clientorder.setOrderDate(LocalDate.now());
        clientorder.setClient(client);

        List<ClientOrderItem> orderItems = saveItems(clientorder, dto.getItems());
        repository.save(clientorder);
        orderItemsRepository.saveAll(orderItems);
        clientorder.setClientOrderItems(orderItems);
        return clientorder;
    }

    public List<ClientOrderItem> saveItems(ClientOrder order, List<ClientOrderItemDTO> items) {
        if (items.isEmpty()) {
            throw new invalidCode("The order doesn't have any items");
        }

        return items
                .stream()
                .map(dto -> {
                    Integer productId = dto.getProduct();
                    Product product = productsRepository
                            .findById(productId)
                            .orElseThrow(() -> new invalidCode("Product ID not found: " + productId));

                    ClientOrderItem orderItem = new ClientOrderItem();
                    orderItem.setQuantity(dto.getQuantity());
                    orderItem.setClientOrder(order);
                    orderItem.setProduct(product);
                    return orderItem;
                }).collect(Collectors.toList());
    }

    @Override
    public Optional<ClientOrder> getFullOrder (Integer id){
        return repository.findByIdFetchClientOrderItems(id);
    }
}
