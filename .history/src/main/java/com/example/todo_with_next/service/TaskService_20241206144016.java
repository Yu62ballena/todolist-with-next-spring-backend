package com.example.todo_with_next.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo_with_next.entity.Task;
import com.example.todo_with_next.repository.TaskRepository;
import java.util.UUID;

@Service
public class TaskService {
  private final TaskRepository taskRepository;

  // 依存性の注入
  public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  // タスク登録メソッド
  public Task createTask(Integer userId, String taskName) {
    // タスク未入力チェック
    if (taskName == null || taskName.isEmpty()) {
      throw new IllegalArgumentException("タスクを入力してください。");
    }

    // データ登録用Entityの作成
    Task task = new Task();
    task.setUserId(userId);
    task.setTaskName(taskName);
    task.setComplete(false);
    task.setDueDate(null);

    // タスクの登録
    Task savedTask = taskRepository.save(task);
    System.out.println("Created new task with ID: " + savedTask.getTaskId()); 

    return taskRepository.save(task);
    
  }

  
  // ユーザーに紐付くタスク一括取得メソッド
  public List<Task> getTasksByUserId (UUID userId) {
    return taskRepository.findByUserId(userId);
  }


  // タスクの削除
  public void deleteTask(Integer taskId) {
    taskRepository.deleteById(taskId);  
  }

  // isCompleteの切り替え
  public Task toggleTaskComplete(Integer taskId) {
    Task task = taskRepository.findById(taskId).orElseThrow(() -> new IllegalArgumentException("指定されたタスクがみつかりません"));

    task.setComplete(!task.isComplete());

    return taskRepository.save(task);
  }

}
