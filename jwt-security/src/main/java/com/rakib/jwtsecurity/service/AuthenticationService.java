package com.rakib.jwtsecurity.service;

import com.rakib.jwtsecurity.config.JwtService;
import com.rakib.jwtsecurity.dto.AuthenticationRequest;
import com.rakib.jwtsecurity.dto.AuthenticationResponse;
import com.rakib.jwtsecurity.dto.RegisterRequest;
import com.rakib.jwtsecurity.user.User;
import com.rakib.jwtsecurity.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request, HttpServletRequest httpServletRequest) {

        Optional<User> use = userRepository.findByEmail(request.email());
        if (use.isPresent()) {
            throw new UsernameNotFoundException("User already in used");
        }
        User user = User
                .builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .build();
        userRepository.save(user);
        var token = jwtService.generateToken(request.email(), httpServletRequest);
        return AuthenticationResponse.builder().token(token).build();
    }

    public AuthenticationResponse login(AuthenticationRequest request, HttpServletRequest httpServletRequest) {
        userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail()
                , request.getPassword()));
        if (authentication.isAuthenticated()) {
            var token = jwtService.generateToken(request.getEmail(), httpServletRequest);
            return AuthenticationResponse.builder().token(token).build();
        }
        return null;
    }
}
