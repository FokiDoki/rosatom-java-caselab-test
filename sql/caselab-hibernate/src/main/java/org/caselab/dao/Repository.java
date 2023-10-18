package org.caselab.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    Optional<T> findById(Long id);

    List<T> getAll();

    List<T> getAll(int limit, int offset);

    List<T> getAllByNameLike(String name);

    List<T> getAllByRegistrationDateBetween(LocalDate from, LocalDate to);
    void save(T entity);
    void delete(T entity);
    void update(T user);

}
