package com.example.todo_with_next.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_with_next.dto.LoginRequestDto;
import com.example.todo_with_next.dto.LoginResponseDto;
import com.example.todo_with_next.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) {

      System.out.println("Login request received for email: " + request.getEmail());

      try {
          LoginResponseDto response = authService.authenticate(request);
          System.out.println("Auth Response: " + response);

          if(response.isSuccess()) {
            return ResponseEntity.ok(response);
          } else {
            return ResponseEntity.status(401).body(response);
          }

      } catch (Exception e) {
        System.out.println("Error in login: " + e.getMessage());

        LoginResponseDto response = LoginResponseDto.builder()
        .success(false)
        .message("ログイン処理中にエラーが発生しました")
        .username("")
        .token("")
        .userId(null)
        .email("")
        .thumbnailPath("")
        .build();

        return ResponseEntity.status(500).body(response);
      }
    }
}
