package com.rakib.jwtsecurity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rakib.jwtsecurity.user.User;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@Builder
@Data
public class UserPrinciple implements UserDetails {
    private Long id;
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public static UserPrinciple createPrinciple(User user) {
        return UserPrinciple
                .builder()
                .id(user.getId())
                .username(user.getFirstname())
                .email(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getRoles().stream().map(role ->
                                new SimpleGrantedAuthority(role.getRoleName()))
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
