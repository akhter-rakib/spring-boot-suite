package com.rakib.jwtsecurity.util;

import com.rakib.jwtsecurity.dto.UserPrinciple;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.Objects;

public final class AuthUtils {
    private AuthUtils() {

    }

    private static UserPrinciple getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null ? (UserPrinciple) authentication.getPrincipal() : null;
    }

    public String loggedInUser() {
        UserPrinciple principle = getPrincipal();
        return Objects.nonNull(principle) ? principle.getEmail() : null;

    }

    public Collection<? extends GrantedAuthority> getLoggedInAuthorities() {
        UserPrinciple principle = getPrincipal();
        return Objects.nonNull(principle) ? principle.getAuthorities() : null;
    }
}
