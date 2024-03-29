package com.ntu.api.domain.database.service.serviceImplementation;

import com.ntu.api.domain.database.dao.DAOinterface.SpecialityDAOInt;
import com.ntu.api.domain.database.entity.*;
import com.ntu.api.domain.database.service.serviceInterface.SpecialityServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityService implements SpecialityServiceInt {
    @Autowired
    private SpecialityDAOInt specialityDAO;

    @Override
    public Long addSpeciality(Speciality speciality) {
        return specialityDAO.create(speciality);
    }

    @Override
    public Speciality getSpeciality(Long id) {
        return specialityDAO.get(id);
    }

    @Override
    public void updateSpeciality(Speciality speciality) {
        specialityDAO.update(speciality);
    }

    @Override
    public void deleteSpeciality(Long id) {
        specialityDAO.delete(id);
    }

    @Override
    public List<Speciality> getSpecialities() {
        return specialityDAO.findAll();
    }
}
