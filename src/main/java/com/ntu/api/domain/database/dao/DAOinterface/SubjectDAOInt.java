package com.ntu.api.domain.database.dao.DAOinterface;

import com.ntu.api.domain.database.entity.Subject;

import java.util.List;

public interface SubjectDAOInt {
    Long create(Subject subject);

    Subject get (Long id);

    void update(Subject subject);

    void delete(Long id);

    List<Subject> findAll();
}
