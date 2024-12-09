package com.example.todo_with_next.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo_with_next.dto.UserRequestDto;
import com.example.todo_with_next.dto.UserResponseDto;
import com.example.todo_with_next.entity.User;
import com.example.todo_with_next.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  @Transactional
  public UserResponseDto createUser(UserRequestDto requestDto) {

        // Nullチェック
      if (requestDto == null) {
          throw new IllegalArgumentException("リクエストデータがnullです。");
      }
      if (requestDto.getEmail() == null || requestDto.getEmail().trim().isEmpty()) {
          throw new IllegalArgumentException("メールアドレスは必須です。");
      }

    // メールアドレスの重複チェック
    if ( userRepository.findByEmail(requestDto.getEmail()) != null) {
      throw new RuntimeException("このメールアドレスはすでに登録されています。");
    }

    // エンティティの作成
    User user = new User();
    user.setUserName(requestDto.getUsername());
    user.setEmail(requestDto.getEmail());
    user.setHashedPassword(passwordEncoder.encode(requestDto.getPassword()));
    user.setThumbnailPath(requestDto.getThumbnailPath());

    // 保存
    User savedUser = userRepository.save(user);

    return convertToResponseDto(savedUser);
  }


  @Override
  @Transactional
  public UserResponseDto updateUser(UUID userId, UserRequestDto requestDto) {
    User user = userRepository.findById(userId)
      .orElseThrow(() -> new RuntimeException("ユーザーが見つかりません。"));

      // メールアドレスの重複チェック（自分以外）
      User existingUser = userRepository.findByEmail(requestDto.getEmail());
      if(existingUser != null && !existingUser.getUserId().equals(userId)) {
        throw new RuntimeException("このメールアドレスはすでに使用されています。");
      }

      // 更新
      user.setUserName(requestDto.getUsername());
      user.setEmail(requestDto.getEmail());
      if(requestDto.getPassword() != null && !requestDto.getPassword().isEmpty()) {
        user.setHashedPassword(passwordEncoder.encode(requestDto.getPassword()));
      }
      if(requestDto.getThumbnailPath() != null) {
        user.setThumbnailPath(requestDto.getThumbnailPath());
      }

      User updatedUser = userRepository.save(user);
      return convertToResponseDto(updatedUser);
  }

  private UserResponseDto convertToResponseDto(User user) {
    UserResponseDto responseDto = new UserResponseDto();
    responseDto.setUserId(user.getUserId());
    responseDto.setUsername(user.getUserName());
    responseDto.setEmail(user.getEmail());
    responseDto.setThumbnailPath(user.getThumbnailPath());

    return responseDto;
  }


  @Override
  @Transactional
  public void deleteUser(UUID userId) {
    User user = userRepository.findById(userId)
      .orElseThrow(() -> new RuntimeException("ユーザーが見つかりません。"))
  }

}
