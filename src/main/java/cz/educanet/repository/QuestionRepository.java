package cz.educanet.repository;

import cz.educanet.modes.QuestionModel;
import cz.educanet.modes.UserModel;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class QuestionRepository {
    public void askQuestion(QuestionModel questionModel) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/askfm?user=root&password=");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO askfm.question (question, targetId, createdAt, updatedAt) VALUES (?, ?, NOW(), NOW())"
                );

        ) {
            preparedStatement.setString(1, questionModel.getQuestion());
            preparedStatement.setInt(2, questionModel.getTargetID().getUserId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<QuestionModel> getSpecificQuestion(int id) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/askfm?user=root&password=");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT q.questionId, q.question, q.answer, q.createdAt, q.updatedAt FROM askfm.question AS q WHERE q.targetId = ?"
                )) {
            ArrayList<QuestionModel> questionModelArrayList = new ArrayList<>();
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    questionModelArrayList.add(new QuestionModel(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getTimestamp(4).toLocalDateTime(),
                            resultSet.getTimestamp(5).toLocalDateTime()
                            ));
                }
            }
            return questionModelArrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
