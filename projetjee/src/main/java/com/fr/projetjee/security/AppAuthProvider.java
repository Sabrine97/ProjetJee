package com.fr.projetjee.security;

import com.fr.projetjee.service.impl.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public class AppAuthProvider extends DaoAuthenticationProvider {
    
    @Autowired
    private UserService userDetailsService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationCredentialsNotFoundException {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        String name = auth.getName();
        String password = auth.getCredentials()
                .toString();
        UserDetails user = userDetailsService.loadUserByUsername(name);
        if (user == null) {
            throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
        }
        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }   
}
