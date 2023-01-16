package com.rakib.jwtsecurity.controller;

import com.rakib.jwtsecurity.dto.AuthenticationRequest;
import com.rakib.jwtsecurity.dto.AuthenticationResponse;
import com.rakib.jwtsecurity.dto.RegisterRequest;
import com.rakib.jwtsecurity.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request,
                                                           HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok(authenticationService.register(request, httpServletRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request, HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok(authenticationService.login(request, httpServletRequest));
    }
}
