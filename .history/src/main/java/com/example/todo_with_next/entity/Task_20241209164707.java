package com.example.todo_with_next.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tasks")
@Data
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "task_id")
  private Integer taskId;

  @Column(name = "user_id", nullable = false)
  private UUID userId;

  @Column(name = "task_name", nullable = false)
  private String taskName;

  @Column(name = "is_complete", nullable = false)
  @JsonProperty("isComplete") 
  private boolean isComplete;

  @Column(name = "due_date")
  private LocalDateTime dueDate;
}
