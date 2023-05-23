package com.safenet.fxchangebe.config;

import com.safenet.fxchangebe.services.AuthenticationService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@WebFilter
public class AuthenticationFilter extends GenericFilter {

    @Autowired
    private AuthenticationService authService;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String accessToken = authHeader.substring(7);
            try {
                Claims claims = authService.validateToken(accessToken);
                String googleId = claims.getSubject();
                if (googleId != null) {
                    chain.doFilter(req, res);
                }
            } catch (JwtException e) {
                ((HttpServletResponse) res).sendError(401, e.getMessage());
            }
        }
    }

}
