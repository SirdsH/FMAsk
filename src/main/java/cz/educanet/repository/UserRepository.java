package cz.educanet.repository;

import cz.educanet.modes.QuestionModel;
import cz.educanet.modes.UserModel;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserRepository {
    private String salt = "&T2@5s";

    public void register(UserModel userModel) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/askfm?user=root&password=");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO askfm.user (email, hashedPassword, fullName, bio, createdAt, updatedAt) VALUES (?, ?, ?, ?, NOW(), NOW())"
                );

        ) {
            System.out.println(userModel.getFullName());
            preparedStatement.setString(1, userModel.getEmail());
            preparedStatement.setString(2, DigestUtils.sha256Hex(userModel.getHashedPassword() + salt));
            preparedStatement.setString(3, userModel.getFullName());
            preparedStatement.setString(4, userModel.getBio());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UserModel login(UserModel userModel) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/askfm?user=root&password=");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT u.userId, u.email, u.fullName, u.hashedPassword FROM askfm.user AS u WHERE u.email = ? AND u.hashedPassword = ?"
                )) {
            UserModel userDatabase = null;
            preparedStatement.setString(1, userModel.getEmail());
            preparedStatement.setString(2, DigestUtils.sha256Hex(userModel.getHashedPassword() + salt));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    userDatabase = (new UserModel(
                            resultSet.getString("email"),
                            resultSet.getString("fullName"),
                            resultSet.getString("hashedPassword")
                    ));
                }
            }
            return userDatabase;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<UserModel> getUsers() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/askfm?user=root&password=");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM askfm.user");
        ) {
            ArrayList<UserModel> usersArrayList = new ArrayList<>();

            while (resultSet.next()) {
                usersArrayList.add(new UserModel(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getTimestamp(7).toLocalDateTime(), resultSet.getTimestamp(8).toLocalDateTime()));
            }

            return usersArrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UserModel specificUser(int userId) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/askfm?user=root&password=");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM askfm.user WHERE user.userId = ?"
                )) {
            preparedStatement.setInt(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                return new UserModel(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getTimestamp(7).toLocalDateTime(),
                        resultSet.getTimestamp(8).toLocalDateTime()
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
