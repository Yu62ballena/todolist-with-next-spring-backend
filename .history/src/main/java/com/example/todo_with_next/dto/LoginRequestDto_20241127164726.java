package com.example.todo_with_next.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
  private String email;
  private String password;
  private String username;
  private String token;
}
