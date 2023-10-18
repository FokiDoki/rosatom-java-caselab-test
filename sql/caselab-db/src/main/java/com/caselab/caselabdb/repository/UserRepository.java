package com.caselab.caselabdb.repository;

import com.caselab.caselabdb.model.User;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements Repository<User>{

    private final PreparedStatement getAllStatement;
    private final PreparedStatement findByIdStatement;
    private final PreparedStatement saveStatement;
    private final PreparedStatement deleteStatement;
    private final PreparedStatement updateStatement;

    public UserRepository(Connection connection) throws SQLException {
        getAllStatement = connection.prepareStatement("SELECT * FROM users");
        findByIdStatement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
        saveStatement = connection.prepareStatement("INSERT INTO users (name, password, registration_date, is_banned, ip) VALUES (?, ?, ?, ?, ?)");
        deleteStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
        updateStatement = connection.prepareStatement("UPDATE users SET name = ?, password = ?, registration_date = ?, is_banned = ?, ip = ? WHERE id = ?");
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
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            Date registrationDate = resultSet.getDate("registration_date");
            boolean isBanned = resultSet.getBoolean("is_banned");
            Inet4Address ip = (Inet4Address) Inet4Address.getByName(resultSet.getString("ip"));
            return Optional.of(new User(id, name, password, registrationDate.toLocalDate(), isBanned, ip));
        }
        return Optional.empty();
    }

    @Override
    public List<User> getAll() throws SQLException, UnknownHostException {
        ResultSet allUsersResultSet = executeStatement(getAllStatement);
        List<User> users = new ArrayList<>();
        while (allUsersResultSet.next()) {
            Long id = allUsersResultSet.getLong("id");
            String name = allUsersResultSet.getString("name");
            String password = allUsersResultSet.getString("password");
            Date registrationDate = allUsersResultSet.getDate("registration_date");
            boolean isBanned = allUsersResultSet.getBoolean("is_banned");
            Inet4Address ip = (Inet4Address) Inet4Address.getByName(allUsersResultSet.getString("ip"));
            users.add(new User(id, name, password, registrationDate.toLocalDate(), isBanned, ip));
        }
        return users;
    }

    @Override
    public void save(User entity) throws SQLException {
        try {
            saveStatement.setString(1, entity.getName());
            saveStatement.setString(2, entity.getPassword());
            saveStatement.setDate(3, Date.valueOf(entity.getRegistrationDate()));
            saveStatement.setBoolean(4, entity.isBanned());
            saveStatement.setString(5, entity.getIp().getHostAddress());
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
    public void update(User oldEntity, User newEntity) throws SQLException{
        try {
            updateStatement.setString(1, newEntity.getName());
            updateStatement.setString(2, newEntity.getPassword());
            updateStatement.setDate(3, Date.valueOf(newEntity.getRegistrationDate()));
            updateStatement.setBoolean(4, newEntity.isBanned());
            updateStatement.setString(5, newEntity.getIp().getHostAddress());
            updateStatement.setLong(6, oldEntity.getId());
            executeStatement(updateStatement);
        } finally {
            updateStatement.clearParameters();
        }
    }

    private ResultSet executeStatement(PreparedStatement statement) throws SQLException {
        statement.execute();
        return statement.getResultSet();
    }
}
