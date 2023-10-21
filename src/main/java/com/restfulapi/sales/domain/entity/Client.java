package com.restfulapi.sales.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restfulapi.sales.domain.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "client")
public class Client implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    @NotEmpty(message = "{requiredfield.username}")
    private String username;

    @Column(name = "first_name", length = 100)
    @NotEmpty(message = "{requiredfield.firstname}")
    private String firstname;

    @Column(name = "last_name", length = 100)
    @NotEmpty(message = "{requiredfield.lastname}")
    private String lastname;

    @Column(name = "cpf", length = 11)
    @CPF(message = "{invalidformat.cpf}")
    @NotNull(message = "{requiredfield.cpf}")
    private String cpf;

    @Column(name = "password")
    @NotEmpty(message = "{requiredfield.password}")
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @JsonIgnore
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<ClientOrder> clientOrders;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

