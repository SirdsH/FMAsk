package cz.educanet.modes;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.time.LocalDateTime;

@Named
@RequestScoped
public class UserModel {
    private int userId;
    private String email;
    private String hashedPassword;
    private String fullName;
    private String bio;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserModel() {
    }

    public UserModel(String email, String hashedPassword, String fullName, String bio) {
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.fullName = fullName;
        this.bio = bio;
    }

    public UserModel(String email, String fullName, String hashedPassword) {
        this.email = email;
        this.fullName = fullName;
        this.hashedPassword = hashedPassword;
    }

    public UserModel(int userId, String email, String hashedPassword, String fullName, String bio, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.userId = userId;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.fullName = fullName;
        this.bio = bio;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}


