package com.example.todo_with_next.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HealthController {
  @GetMapping("/health")
  public (@RequestParam String param) {
      return new String();
  }
  
}