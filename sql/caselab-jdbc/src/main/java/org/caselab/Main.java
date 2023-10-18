package org.caselab;

import org.caselab.model.User;
import org.caselab.repository.PostgresConnection;
import org.caselab.repository.UserRepository;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SQLException, UnknownHostException {
        Connection connection = PostgresConnection.getConnection();
        System.out.println("Connection established");
        UserRepository userRepository = new UserRepository(connection);
        System.out.println("\n\nAll users:");
        System.out.println(userRepository.getAll());

        User newUser = new User(null, "test", "test", LocalDate.now(), false, (Inet4Address) Inet4Address.getByName("10.10.10.10"));
        System.out.println("\n\nNew user:");
        userRepository.save(newUser);
        System.out.println(userRepository.getAll());

        System.out.println("\n\nUpdated user:");
        User user = userRepository.getAll().get(0);
        user.setName("test2");
        userRepository.update(user);


        System.out.println(userRepository.getAll());
        userRepository.delete(user);
        System.out.println(userRepository.getAll());

        System.out.println("\n\nAll users paginated:");
        System.out.println(userRepository.getAll(2, 1));

        System.out.println("\n\nAll users with name like 'test':");
        System.out.println(userRepository.getAllByNameLike("test"));

        System.out.println("\n\nAll users registered between 2023-01-01 and 2023-12-31:");
        System.out.println(userRepository.getAllByRegistrationDateBetween(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 31)));


        PostgresConnection.closeConnection();

    }
}