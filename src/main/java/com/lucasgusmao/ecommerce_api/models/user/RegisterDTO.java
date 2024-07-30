package com.lucasgusmao.ecommerce_api.models.user;

public record RegisterDTO (String login, String password, UserRole role) {
}
