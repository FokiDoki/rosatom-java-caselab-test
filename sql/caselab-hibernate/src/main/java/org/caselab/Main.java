package org.caselab;

import org.caselab.dao.Repository;
import org.caselab.dao.UserRepositoryHibernate;
import org.caselab.model.User;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Repository<User> userRepository = new UserRepositoryCriteria();
        Repository<User> userRepository = new UserRepositoryHibernate();
        userRepository.getAll().forEach(System.out::println);
        userRepository.getAllByNameLike("a").forEach(System.out::println);
        userRepository.getAllByRegistrationDateBetween(
                LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 12, 31)
        ).forEach(System.out::println);
        userRepository.save(new User("a", "b", LocalDate.now(), false, "10.10.10.10"));
        userRepository.getAll().forEach(System.out::println);
    }
}