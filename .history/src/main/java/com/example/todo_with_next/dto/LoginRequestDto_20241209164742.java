package com.example.todo_with_next.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LoginRequestDto {
  private String email;
  private String password;
  private String username;
  private String token;
}