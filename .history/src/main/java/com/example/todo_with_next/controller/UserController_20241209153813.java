package com.example.todo_with_next.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_with_next.dto.UserRequestDto;
import com.example.todo_with_next.dto.UserResponseDto;
import com.example.todo_with_next.service.UserService;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
  
  @Autowired
  private UserService userService;

  // ユーザーの登録
  @PostMapping
  public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto) {
    System.out.println(requestDto);

    UserResponseDto createdUser = userService.createUser(requestDto);
    return ResponseEntity.ok(createdUser);
  }

  // ユーザー情報の更新
  @PutMapping("/{userId}")
  public ResponseEntity<UserResponseDto> updateUser(
    @PathVariable UUID userId,
    @RequestBody UserRequestDto requestDto
  ) {
    UserResponseDto updatedUser = userService.updateUser(userId, requestDto);
    return ResponseEntity.ok(updatedUser);
  }


  // ユーザー情報の削除
  @DeleteMapping("/{userId}")
  public ResponseEntity<void> deleteUser(@PathVariable UUID userId) {
    userService.deleteUser(userId)
  }

}
