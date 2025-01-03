package com.example.todo_with_next.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor  
@AllArgsConstructor
public class UserRequestDto {
  private String username;
  private String email;
  private String password;

  @JsonProperty("thumbnail_path")
  private String thumbnailPath;
}
