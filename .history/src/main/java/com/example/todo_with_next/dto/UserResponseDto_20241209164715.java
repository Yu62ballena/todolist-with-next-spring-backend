package com.example.todo_with_next.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
public class UserResponseDto {
  private UUID userId;
  private String username;
  private String email;

  @JsonProperty("thumbnail_path")
  private String thumbnailPath;
}

