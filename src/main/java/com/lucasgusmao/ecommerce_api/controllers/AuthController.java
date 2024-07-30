package com.lucasgusmao.ecommerce_api.controllers;

import com.lucasgusmao.ecommerce_api.config.TokenService;
import com.lucasgusmao.ecommerce_api.models.user.AuthDTO;
import com.lucasgusmao.ecommerce_api.models.user.LoginResponseDTO;
import com.lucasgusmao.ecommerce_api.models.user.RegisterDTO;
import com.lucasgusmao.ecommerce_api.models.user.User;
import com.lucasgusmao.ecommerce_api.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepository repository;
    private TokenService service;

    public AuthController(AuthenticationManager authenticationManager, UserRepository repository, TokenService service) {
        this.authenticationManager = authenticationManager;
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = this.authenticationManager.authenticate(usernamePassword);

        var token = service.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated RegisterDTO data) {
        if(this.repository.findByLogin(data.login()) != null){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User user = new User(data.login(), encryptedPassword, data.role());

        this.repository.save(user);

        return ResponseEntity.ok().build();
    }
}
