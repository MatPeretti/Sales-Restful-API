package com.restfulapi.sales.rest.controller;

import com.restfulapi.sales.rest.dto.AuthenticationRequestDTO;
import com.restfulapi.sales.rest.dto.AuthenticationResponseDTO;
import com.restfulapi.sales.rest.dto.RegisterRequestDTO;
import com.restfulapi.sales.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register (@RequestBody RegisterRequestDTO registerRequest){
        return ResponseEntity.ok(authService.register(registerRequest));

    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> register (@RequestBody AuthenticationRequestDTO authenticationRequest){
        return ResponseEntity.ok(authService.authenticate(authenticationRequest));


    }
}
