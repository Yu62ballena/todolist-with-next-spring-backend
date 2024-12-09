package com.example.todo_with_next.dto;

import lombok.Data;

@Data
@Builder
@NoArgsConstructor  
@AllArgsConstructor
public class CreateTaskRequest {
  private String taskName;
}
