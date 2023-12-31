package com.restfulapi.sales.service.impl;

import com.restfulapi.sales.config.JwtService;
import com.restfulapi.sales.domain.entity.Client;
import com.restfulapi.sales.domain.enums.UserRole;
import com.restfulapi.sales.domain.repository.Clients;
import com.restfulapi.sales.rest.dto.AuthenticationRequestDTO;
import com.restfulapi.sales.rest.dto.AuthenticationResponseDTO;
import com.restfulapi.sales.rest.dto.RegisterRequestDTO;
import com.restfulapi.sales.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final Clients repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponseDTO register(RegisterRequestDTO registerDTO) {
        var client = Client.builder()
                .firstname(registerDTO.getFirstname())
                .lastname(registerDTO.getLastname())
                .cpf(registerDTO.getCpf())
                .username(registerDTO.getUsername())
                .password(passwordEncoder.encode(registerDTO.getPassword()))
                .role(UserRole.USER)
                .build();
        repository.save(client);
        var jwtToken = jwtService.generateToken(client);
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO authDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authDTO.getUsername(), authDTO.getPassword())
        );
        var user = repository.findByUsername(authDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("Auth error"));
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }
}
