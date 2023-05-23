package com.safenet.fxchangebe.services;

import com.safenet.fxchangebe.config.JwtTokenProperties;
import com.safenet.fxchangebe.exceptions.TokenException;
import io.jsonwebtoken.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthenticationService {

    @Autowired
    private JwtTokenProperties properties;

    public AuthenticationService(JwtTokenProperties properties) {
        this.properties = properties;
    }

    public String generateToken(String googleId, String fullname, String role) {
        JwtBuilder builder = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(googleId)
                .claim("name", fullname)
                .claim("role", role)
                .setExpiration(new Date(System.currentTimeMillis() + properties.getExpiration()))
                .signWith(SignatureAlgorithm.HS512, properties.getSecret());

        return builder.compact();
    }

    public String generateRefreshToken() {
        JwtBuilder builder = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setExpiration(new Date(System.currentTimeMillis() + properties.getExpiration() * 48))
                .signWith(SignatureAlgorithm.HS512, properties.getSecret());

        return builder.compact();
    }

    public String refreshToken(String refreshToken) {
        Claims claims = validateToken(refreshToken);

        String googleId = claims.getSubject();
        String fullname = (String) claims.get("name");
        String role = (String) claims.get("role");

        return generateToken(googleId, fullname, role);
    }

    public Claims validateToken(String token) {
        Jws<Claims> claims = Jwts.parser()
                .setSigningKey(properties.getSecret())
                .parseClaimsJws(token);

        // Check signature
        boolean isSignatureValid = !claims.getSignature().isEmpty();
        if (isSignatureValid) {
            throw new TokenException("Token is not valid");
        }

        // Check expiration
        boolean isExpired = claims.getBody().getExpiration().before(new Date());
        if (isExpired) {
            throw new TokenException("Token has expired");
        }

        return claims.getBody();
    }
}
