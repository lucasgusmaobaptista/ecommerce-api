package com.lucasgusmao.ecommerce_api.repositories;

import com.lucasgusmao.ecommerce_api.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
