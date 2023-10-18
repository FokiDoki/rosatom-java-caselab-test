package org.caselab.repository;

import org.caselab.model.User;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements Repository<User>{

    private final PreparedStatement getAllStatement;
    private final PreparedStatement findByIdStatement;
    private final PreparedStatement saveStatement;
    private final PreparedStatement deleteStatement;
    private final PreparedStatement updateStatement;
    private final PreparedStatement getAllByNameLikeStatement;

    private final PreparedStatement getAllByRegistrationDateBetweenStatement;
    private final PreparedStatement getAllOffsetLimitStatement;

    public UserRepository(Connection connection) throws SQLException {
        getAllStatement = connection.prepareStatement("SELECT * FROM users");
        findByIdStatement = connection.prepareStatement("SELECT * FROM users WHERE user_id = ?");
        saveStatement = connection.prepareStatement("INSERT INTO users (username, password, reg_date, is_banned, ip) VALUES (?, ?, ?, ?, ?)");
        deleteStatement = connection.prepareStatement("DELETE FROM users WHERE user_id = ?");
        updateStatement = connection.prepareStatement("UPDATE users SET username = ?, password = ?, reg_date = ?, is_banned = ?, ip = ? WHERE user_id = ?");
        getAllByNameLikeStatement = connection.prepareStatement("SELECT * FROM users WHERE username LIKE ?");
        getAllByRegistrationDateBetweenStatement = connection.prepareStatement("SELECT * FROM users WHERE reg_date BETWEEN ? AND ?");
        getAllOffsetLimitStatement = connection.prepareStatement("SELECT * FROM users LIMIT ? OFFSET ?");


    }

    @Override
    public Optional<User> findById(Long id) throws SQLException, UnknownHostException {
        ResultSet resultSet;
        try {
            findByIdStatement.setLong(1, id);
            resultSet = executeStatement(findByIdStatement);
        } finally {
            findByIdStatement.clearParameters();
        }
        List<User> users = getUsersFromResultSet(resultSet);
        if (!users.isEmpty()) {
            return Optional.of(users.get(0));
        }
        return Optional.empty();
    }

    @Override
    public List<User> getAll() throws SQLException, UnknownHostException {
        ResultSet allUsersResultSet = executeStatement(getAllStatement);
        return getUsersFromResultSet(allUsersResultSet);
    }

    private List<User> getUsersFromResultSet(ResultSet resultSet) throws SQLException, UnknownHostException {
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            Long id = resultSet.getLong("user_id");
            String name = resultSet.getString("username");
            String password = resultSet.getString("password");
            Date registrationDate = resultSet.getDate("reg_date");
            boolean isBanned = resultSet.getBoolean("is_banned");
            Inet4Address ip = (Inet4Address) Inet4Address.getByName(resultSet.getString("ip"));
            users.add(new User(id, name, password, registrationDate.toLocalDate(), isBanned, ip));
        }
        return users;
    }

    @Override
    public List<User> getAll(int limit, int offset) throws SQLException, UnknownHostException {
        ResultSet resultSet;
        try {
            getAllOffsetLimitStatement.setInt(1, limit);
            getAllOffsetLimitStatement.setInt(2, offset);
            resultSet = executeStatement(getAllOffsetLimitStatement);
        } finally {
            getAllOffsetLimitStatement.clearParameters();
        }
        return getUsersFromResultSet(resultSet);
    }

    @Override
    public List<User> getAllByNameLike(String name) throws SQLException, UnknownHostException {
        ResultSet resultSet;
        try {
            getAllByNameLikeStatement.setString(1, name);
            resultSet = executeStatement(getAllByNameLikeStatement);
        } finally {
            getAllByNameLikeStatement.clearParameters();
        }
        return getUsersFromResultSet(resultSet);
    }

    @Override
    public List<User> getAllByRegistrationDateBetween(LocalDate from, LocalDate to) throws SQLException, UnknownHostException {
        ResultSet resultSet;
        try {
            getAllByRegistrationDateBetweenStatement.setDate(1, Date.valueOf(from));
            getAllByRegistrationDateBetweenStatement.setDate(2, Date.valueOf(to));
            resultSet = executeStatement(getAllByRegistrationDateBetweenStatement);
        } finally {
            getAllByRegistrationDateBetweenStatement.clearParameters();
        }
        return getUsersFromResultSet(resultSet);
    }


    @Override
    public void save(User entity) throws SQLException {
        try {
            SetUserToStatement(entity, saveStatement);
            executeStatement(saveStatement);
        } finally {
            saveStatement.clearParameters();
        }
    }

    @Override
    public void delete(User entity) throws SQLException {
        try {
            deleteStatement.setLong(1, entity.getId());
            executeStatement(deleteStatement);
            deleteStatement.clearParameters();
        } finally {
            deleteStatement.clearParameters();
        }
    }


    @Override
    public void update(User user) throws SQLException{
        try {
            SetUserToStatement(user, updateStatement);
            updateStatement.setLong(6, user.getId());
            executeStatement(updateStatement);
        } finally {
            updateStatement.clearParameters();
        }
    }

    private void SetUserToStatement(User newEntity, PreparedStatement statement) throws SQLException {
        statement.setString(1, newEntity.getName());
        statement.setString(2, newEntity.getPassword());
        statement.setDate(3, Date.valueOf(newEntity.getRegistrationDate()));
        statement.setBoolean(4, newEntity.isBanned());
        statement.setString(5, newEntity.getIp().getHostAddress());
    }

    private ResultSet executeStatement(PreparedStatement statement) throws SQLException {
        statement.execute();
        return statement.getResultSet();
    }
}
