package tech.alokkr.assignment.security;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.alokkr.assignment.service.JWTService;

import java.io.IOException;

public class JWTAuthenticationFilter extends OncePerRequestFilter {
    private JWTService jwtService;

    public JWTAuthenticationFilter(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (token != null) {
            String username = jwtService.extractUsername(token);
            // Store username in security context here (omitted for brevity)
        }
        filterChain.doFilter(request, response);
    }
}
