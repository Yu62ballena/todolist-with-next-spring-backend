package com.example.todo_with_next.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserRequestDto {
  private String username;
  private String email;
  private String password;

  @JsonProperty("thumbnail_path")
  private String thumbnailPath;
}
