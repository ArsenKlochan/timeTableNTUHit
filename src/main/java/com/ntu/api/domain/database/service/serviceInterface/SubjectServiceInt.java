package com.ntu.api.domain.database.service.serviceInterface;

import com.ntu.api.domain.database.entity.Subject;

import java.util.List;

public interface SubjectServiceInt {
    Long addSubject(Subject subject);
    Subject getSubject(Long id);
    void updateSubject(Subject subject);
    void deleteSubject(Long id);
    List<Subject> getSubjectList();

}
