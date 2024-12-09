package com.example.todo_with_next.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.todo_with_next.entity.User;
import com.example.todo_with_next.service.UserServiceImpl.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {
    @Override
      public void deleteUser(UUID userId) {
        User user = userRepository.findById(userId)
          .orElseThrow(() -> new ResourceNotFoundException("User not found with id:" + userId));

          userRepository.delete(user);
      }

  public class ResourceNotFoundException extends RuntimeException {
      public ResourceNotFoundException(String message) {
        super(message);
      }
    }
}
