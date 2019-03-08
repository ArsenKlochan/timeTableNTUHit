package com.ntu.api.domain.database.service.serviceImplementation;

import com.ntu.api.domain.database.dao.DAOinterface.SubjectDAOInt;
import com.ntu.api.domain.database.entity.Subject;
import com.ntu.api.domain.database.service.serviceInterface.SubjectServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectService implements SubjectServiceInt {
    @Autowired
    private SubjectDAOInt subjectDAO;

    @Override
    public Long addSubject(Subject subject) {
        return subjectDAO.create(subject);
    }

    @Override
    public Subject getSubject(Long id) {
        return subjectDAO.get(id);
    }

    @Override
    public void updateSubject(Subject subject) {
        subjectDAO.update(subject);
    }

    @Override
    public void deleteSubject(Long id) {
        subjectDAO.delete(id);
    }

    @Override
    public List<Subject> getSubjectList() {
        return subjectDAO.findAll();
    }
}
