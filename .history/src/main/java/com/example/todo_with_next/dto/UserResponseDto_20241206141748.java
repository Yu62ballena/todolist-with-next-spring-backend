package com.example.todo_with_next.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserResponseDto {
  private String userId;
  private String username;
  private String email;

  @JsonProperty("thumbnail_path")
  private String thumbnailPath;
}

