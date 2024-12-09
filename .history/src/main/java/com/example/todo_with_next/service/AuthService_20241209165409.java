package com.example.todo_with_next.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.todo_with_next.dto.LoginRequestDto;
import com.example.todo_with_next.dto.LoginResponseDto;
import com.example.todo_with_next.entity.User;
import com.example.todo_with_next.repository.UserRepository;


@Service
public class AuthService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtUtil jwtUtil;

  public LoginResponseDto authenticate(LoginRequestDto request) {
    System.out.println("AuthService.authenticate called with email: " + request.getEmail());
    User user = userRepository.findByEmail(request.getEmail());
    System.out.println("Found user: " + user);

    if(user != null) {

      if(passwordEncoder.matches(request.getPassword(), user.getHashedPassword())) {
        String token = jwtUtil.generateToken(user.getEmail(), user.getUserName());
        System.out.println("Token in AuthService: " + token);

        LoginResponseDto response = LoginResponseDto.builder()
        .success(true)
        .message("ログイン成功")
        .username(user.getUserName())
        .token(token)
        .userId(user.getUserId())
        .email(user.getEmail())
        .thumbnailPath(user.getThumbnailPath())
        .build();

        System.out.println("Response in AuthService: " + response);
        return response;
      }
    } 

      return LoginResponseDto.builder()
        .success(false)
        .message("メールアドレスまたはパスワードが間違っています")
        .username("")
        .token("")
        .userId(null)
        .email("")
        .thumbnailPath("")
        .build();
    }
  }
