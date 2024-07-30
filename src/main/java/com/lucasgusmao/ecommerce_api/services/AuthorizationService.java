// src/main/java/com/lucasgusmao/ecommerce_api/services/AuthorizationService.java
package com.lucasgusmao.ecommerce_api.services;

import com.lucasgusmao.ecommerce_api.models.user.User;
import com.lucasgusmao.ecommerce_api.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    private final UserRepository repository;

    public AuthorizationService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}