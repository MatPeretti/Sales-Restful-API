package com.restfulapi.sales.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "client_order")
public class ClientOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Client client;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "total", precision = 20, scale = 2)
    private BigDecimal total;

    @OneToMany(mappedBy = "clientOrder")
    private List<ClientOrderItem> clientOrderItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<ClientOrderItem> getClientOrderItems() {
        return clientOrderItems;
    }

    public void setClientOrderItems(List<ClientOrderItem> clientOrderItems) {
        this.clientOrderItems = clientOrderItems;
    }

    @Override
    public String toString() {
        return "ClientOrder{" +
                "id=" + id +
                ", client=" + client +
                ", orderDate=" + orderDate +
                ", total=" + total +
                '}';
    }
}