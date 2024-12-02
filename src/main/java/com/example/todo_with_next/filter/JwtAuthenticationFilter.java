package com.example.todo_with_next.filter;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.todo_with_next.util.JwtUtil;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{

  private final JwtUtil jwtUtil;
  
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    String authHeader = request.getHeader("Authorization");

    if(authHeader != null && authHeader.startsWith("Bearer ")) {
      String token = authHeader.substring(7);

      try {

        Claims claims = jwtUtil.validateTokenAndGetClaims(token);
        String email = claims.getSubject();

        if ( email != null) {
          UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, null, new ArrayList<>());
          SecurityContextHolder.getContext().setAuthentication(authentication);
        }

      } catch (Exception e) {
        SecurityContextHolder.clearContext();
      }
    }filterChain.doFilter(request, response);


  }
}
