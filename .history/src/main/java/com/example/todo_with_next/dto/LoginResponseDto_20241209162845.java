package com.example.todo_with_next.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.UUID;

@Data
@Builder
@Builder
@NoArgsConstructor  
@AllArgsConstructor
public class LoginResponseDto {
  private boolean success;
  private String message;
  private String username;
  private String token;
  private UUID userId;
  private String email;
  private String thumbnailPath;
}
