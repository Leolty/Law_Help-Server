package tech.linjuliwhu.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface TokenService {
    UserDetails authenticateToken(String token, String id);
}
