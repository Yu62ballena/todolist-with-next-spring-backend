package com.example.todo_with_next.dto;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class LoginResponseDto {
  private boolean success;
  private String message;
  private String username;
  private String token;
  private UUID userId;
  private String email;
  private String thumbnailPath;
}
