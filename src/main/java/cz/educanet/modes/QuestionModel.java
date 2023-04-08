package cz.educanet.modes;

import cz.educanet.services.SpecificUser;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.time.LocalDateTime;

@Named
@RequestScoped
public class QuestionModel {
    private int questionId;
    private String question;
    private String answer;
    private UserModel userID;
    private UserModel targetID;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public QuestionModel() {

    }

    public QuestionModel(String question, UserModel targetID) {
        this.question = question;
        this.targetID = targetID;
    }

    public QuestionModel(int questionId, String question, String answer, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public QuestionModel(int questionId, String question, String answer, UserModel userID, UserModel targetID, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
        this.userID = userID;
        this.targetID = targetID;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public UserModel getUserID() {
        return userID;
    }

    public void setUserID(UserModel userID) {
        this.userID = userID;
    }

    public UserModel getTargetID() {
        return targetID;
    }

    public void setTargetID(UserModel targetID) {
        this.targetID = targetID;
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

