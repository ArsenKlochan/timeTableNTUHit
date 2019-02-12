package com.ntu.api.domain.database.service.serviceInterface;

import com.ntu.api.domain.database.entity.*;

import java.util.List;

public interface CurriculumServiceInt {
    Long addCurriculum(Curriculum curriculum);
    Curriculum getCurriculum(Long id);
    void updateCurriculum (Curriculum curriculum);
    void deleteCurriculum(Long id);
    List<Curriculum> getCurriculums();
}
