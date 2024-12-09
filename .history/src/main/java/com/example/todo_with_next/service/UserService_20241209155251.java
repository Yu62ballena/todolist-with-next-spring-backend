package com.example.todo_with_next.service;

import java.util.UUID;

import com.example.todo_with_next.dto.UserRequestDto;
import com.example.todo_with_next.dto.UserResponseDto;

public interface UserService {
  UserResponseDto createUser(UserRequestDto requestDto);
  UserResponseDto updateUser(UUID userId, UserRequestDto requestDto);
  void deleteUser(UUID userId);
}