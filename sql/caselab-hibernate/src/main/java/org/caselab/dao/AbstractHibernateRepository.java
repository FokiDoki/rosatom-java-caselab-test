package org.caselab.dao;

import org.caselab.hibernate.HibernateUtil;
import org.hibernate.Session;

public abstract class AbstractHibernateRepository<T> implements Repository<T>{


    @Override
    public void save(T entity){
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(T entity){
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.remove(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(T entity){
        save(entity);
    }

}
