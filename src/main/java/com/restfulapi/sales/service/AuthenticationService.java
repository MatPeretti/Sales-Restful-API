package com.restfulapi.sales.service;


import com.restfulapi.sales.rest.dto.AuthenticationRequestDTO;
import com.restfulapi.sales.rest.dto.AuthenticationResponseDTO;
import com.restfulapi.sales.rest.dto.RegisterRequestDTO;

public interface AuthenticationService {

    AuthenticationResponseDTO register(RegisterRequestDTO registerDTO);

    AuthenticationResponseDTO authenticate(AuthenticationRequestDTO authDTO);
}
