package com.example.todo_with_next.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

  // JWT署名用の秘密鍵
  private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

  // トークンの有効期限（ミリ秒）
  private static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000;

  // JWTトークンの生成
  public String generateToken(String email, String userName) {

    try {

      System.out.println("Generating token for email: " + email);
      String token =  Jwts.builder()
        .setSubject(email)
        .claim("userName", userName)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .signWith(key)
        .compact();
  
        System.out.println("Generated token:" + token);
        return token;

    } catch (Exception e) {
      System.out.println("Error generating token: " + e.getMessage());
      throw e;
    }

  }

  // トークンの検証とクレーム（データ）の取得
  public Claims validateTokenAndGetClaims(String token) {
    return Jwts.parserBuilder()
      .setSigningKey(key)
      .build()
      .parseClaimsJws(token)
      .getBody();
  }

}
