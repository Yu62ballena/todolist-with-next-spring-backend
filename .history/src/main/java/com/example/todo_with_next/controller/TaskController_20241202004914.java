package com.example.todo_with_next.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_with_next.dto.CreateTaskRequest;
import com.example.todo_with_next.entity.Task;
import com.example.todo_with_next.service.TaskService;




@RestController
@RequestMapping("/api/tasks")
public class TaskController {
  private final TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  // ユーザーごとのタスクの一覧を取得
  @GetMapping
  public List<Task> getTasks(@RequestParam Integer userId) {
    List<Task> tasks = taskService.getTasksByUserId(userId);
    return tasks;
  }

  // タスクの登録
  @PostMapping
  public Task createTask(@RequestParam Integer userId, @RequestBody CreateTaskRequest request) {
      return taskService.createTask(userId, request.getTaskName());
  }


  // isCompleteの切り替え
  @PatchMapping("/{taskId}/toggle")
  public Task toggleTaskComplete(@PathVariable Integer taskId) {
    return taskService.toggleTaskComplete(taskId);
  }
  
  // タスクの削除
  @DeleteMapping("/{taskId}")
  public ResponseEntity<Void> deleteTask(@PathVariable Integer taskId) {
    taskService.deleteTask(taskId);
    return ResponseEntity.ok().build();
  }
  
}
