package com.restfulapi.sales.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @JsonIgnore
    @OneToMany( mappedBy = "client" , fetch = FetchType.LAZY )
    private Set<ClientOrder> clientOrders;

    public Client() {
    }

    public Client(String name) {
        this.name = name;
    }

    public Client(Integer id, String name, Set<ClientOrder> clientOrders) {
        this.id = id;
        this.name = name;
        this.clientOrders = clientOrders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ClientOrder> getClientOrders() {
        return clientOrders;
    }

    public void setClientOrders(Set<ClientOrder> clientOrders) {
        this.clientOrders = clientOrders;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

