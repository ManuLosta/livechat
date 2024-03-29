package com.livechat.server.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    public String extractUsername(String jwt) {
        return null;
    }

    private Claims extractAllClaims(String jwt) {
       return Jwts.parser()
               .verifyWith(getSignInKey())
               .build()
               .parseSignedClaims(jwt)
               .getPayload();
    }
}
