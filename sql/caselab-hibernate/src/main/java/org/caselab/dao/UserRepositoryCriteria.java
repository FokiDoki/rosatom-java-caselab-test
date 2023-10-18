package org.caselab.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.caselab.hibernate.HibernateUtil;
import org.caselab.model.User;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class UserRepositoryCriteria extends AbstractHibernateRepository<User>{
    @Override
    public Optional<User> findById(Long id){
        try (Session session = HibernateUtil.getSession()) {
            CriteriaQuery<User> criteriaQuery = getCriteriaQuery(session);
            criteriaQuery.where(session.getCriteriaBuilder().equal(criteriaQuery.from(User.class).get("id"), id));
            return Optional.ofNullable(session.createQuery(criteriaQuery).getSingleResult());
        }
    }

    @Override
    public List<User> getAll(){
        try (Session session = HibernateUtil.getSession()) {
            CriteriaQuery<User> criteriaQuery = getCriteriaQuery(session);
            criteriaQuery.select(criteriaQuery.from(User.class));
            return session.createQuery(criteriaQuery).list();
        }
    }

    @Override
    public List<User> getAll(int limit, int offset){
        try (Session session = HibernateUtil.getSession()) {
            CriteriaQuery<User> criteriaQuery = getCriteriaQuery(session);
            criteriaQuery.select(criteriaQuery.from(User.class));
            return session.createQuery(criteriaQuery).setMaxResults(limit).setFirstResult(offset).list();
        }
    }

    @Override
    public List<User> getAllByNameLike(String name){
        try (Session session = HibernateUtil.getSession()) {
            CriteriaQuery<User> criteriaQuery = getCriteriaQuery(session);
            criteriaQuery.where(session.getCriteriaBuilder().like(criteriaQuery.from(User.class).get("name"), "%" + name + "%"));
            return session.createQuery(criteriaQuery).list();
        }
    }

    @Override
    public List<User> getAllByRegistrationDateBetween(LocalDate from, LocalDate to){
        try (Session session = HibernateUtil.getSession()) {
            CriteriaQuery<User> criteriaQuery = getCriteriaQuery(session);
            criteriaQuery.where(session.getCriteriaBuilder().between(criteriaQuery.from(User.class).get("registrationDate"), from, to));
            return session.createQuery(criteriaQuery).list();
        }
    }


    private CriteriaQuery<User> getCriteriaQuery(Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        return builder.createQuery(User.class);
    }
}
