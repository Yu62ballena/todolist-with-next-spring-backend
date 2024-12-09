// package com.example.todo_with_next.entity;

// import java.util.UUID;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import lombok.Data;

// @Entity
// @Table(name = "users")
// @Data
// public class User {
//   @Id
//   @GeneratedValue(strategy = GenerationType.AUTO)
//   @Column(name = "user_id", columnDefinition = "UUID")
//   private UUID userId;

//   @Column(name = "username", nullable = false)
//   private String userName;

//   @Column(name = "email", nullable = false, unique = true)
//   private String email;

//   @Column(name = "hashed_password", nullable = false)
//   private String hashedPassword;

//   @Column(name = "thumbnail_path")
//   private String thumbnailPath;
// }



package com.example.todo_with_next.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id", columnDefinition = "UUID")
  private UUID userId;

  @Column(name = "username", nullable = false)
  private String userName;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "hashed_password", nullable = false)
  private String hashedPassword;

  @Column(name = "thumbnail_path")
  private String thumbnailPath;

  // Getters
  public UUID getUserId() {
    return userId;
  }

  public String getUserName() {
    return userName;
  }

  public String getEmail() {
    return email;
  }

  public String getHashedPassword() {
    return hashedPassword;
  }

  public String getThumbnailPath() {
    return thumbnailPath;
  }

  // Setters
  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setHashedPassword(String hashedPassword) {
    this.hashedPassword = hashedPassword;
  }

  public void setThumbnailPath(String thumbnailPath) {
    this.thumbnailPath = thumbnailPath;
  }
}