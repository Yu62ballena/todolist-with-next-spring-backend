package com.example.todo_with_next.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo_with_next.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

  // ユーザーIDに紐付くタスクを取得
  List<Task> findByUserId(UUID userId);

}

