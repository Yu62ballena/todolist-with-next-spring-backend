package com.example.todo_with_next.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo_with_next.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  User findByEmail(String email);
}
