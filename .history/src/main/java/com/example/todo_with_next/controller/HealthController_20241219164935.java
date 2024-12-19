package com.example.todo_with_next.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthController {
  @GetMapping("/health")
  public ResponseEntity<Map<String, String>> healthCheck(){
      Map<String, String> response = new HashMap<>();
      response.put("status", "UP");
      response.put("timestamp", LocalDateTime.now().toString())
  }
  
}
