package org.caselab.dao;

import org.caselab.hibernate.HibernateUtil;
import org.caselab.model.User;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class UserRepositoryHibernate extends AbstractHibernateRepository<User> {



    @Override
    public Optional<User> findById(Long id){
        try (Session session = HibernateUtil.getSession()) {
            User user = session.get(User.class, id);
            return Optional.ofNullable(user);
        }
    }


    @Override
    public List<User> getAll(){
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("from User", User.class).list();
        }
    }

    @Override
    public List<User> getAll(int limit, int offset){
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("from User", User.class)
                    .setMaxResults(limit)
                    .setFirstResult(offset)
                    .list();
        }

    }

    @Override
    public List<User> getAllByNameLike(String name){
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("from User where name like :name", User.class)
                    .setParameter("name", "%" + name + "%")
                    .list();
        }
    }

    @Override
    public List<User> getAllByRegistrationDateBetween(LocalDate from, LocalDate to){
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("from User where registrationDate between :from and :to", User.class)
                    .setParameter("from", from)
                    .setParameter("to", to)
                    .list();
        }
    }

}