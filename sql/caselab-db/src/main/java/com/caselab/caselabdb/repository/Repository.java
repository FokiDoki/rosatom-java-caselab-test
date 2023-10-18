package com.caselab.caselabdb.repository;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    Optional<T> findById(Long id) throws SQLException, UnknownHostException;

    List<T> getAll() throws SQLException, UnknownHostException;
    void save(T entity) throws SQLException;
    void delete(T entity) throws SQLException;
    void update(T oldEntity, T newEntity) throws SQLException;

}
