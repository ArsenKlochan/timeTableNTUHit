package com.ntu.api.domain.database.dao.DAOImplementation;

import com.ntu.api.domain.database.dao.DAOinterface.SubjectDAOInt;
import com.ntu.api.domain.database.entity.Subject;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SubjectDAO implements SubjectDAOInt {
    @Autowired
    private SessionFactory factory;
    @Override
    public Long create(Subject subject) {
        return (Long)factory.getCurrentSession().save(subject);
    }

    @Override
    public Subject get(Long id) {
        return factory.getCurrentSession().get(Subject.class, id);
    }

    @Override
    public void update(Subject subject) {
        factory.getCurrentSession().saveOrUpdate(subject);
    }

    @Override
    public void delete(Long id) {
        factory.getCurrentSession().delete(id);
    }

    @Override
    public List<Subject> findAll() {
        return factory.getCurrentSession().createQuery("from Subject").list();
    }
}
