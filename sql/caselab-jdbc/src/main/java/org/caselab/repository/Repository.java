package org.caselab.repository;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    Optional<T> findById(Long id) throws SQLException, UnknownHostException;

    List<T> getAll() throws SQLException, UnknownHostException;

    List<T> getAll(int limit, int offset) throws SQLException, UnknownHostException;

    List<T> getAllByNameLike(String name) throws SQLException, UnknownHostException;

    List<T> getAllByRegistrationDateBetween(LocalDate from, LocalDate to) throws SQLException, UnknownHostException;
    void save(T entity) throws SQLException;
    void delete(T entity) throws SQLException;
    void update(T user) throws SQLException;

}
