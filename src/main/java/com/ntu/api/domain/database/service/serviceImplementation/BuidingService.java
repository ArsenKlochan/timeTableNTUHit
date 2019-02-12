package com.ntu.api.domain.database.service.serviceImplementation;

import com.ntu.api.domain.database.dao.DAOinterface.BuildingDAOInt;
import com.ntu.api.domain.database.entity.Building;
import com.ntu.api.domain.database.service.serviceInterface.BuildingServiceInt;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BuidingService implements BuildingServiceInt {
    @Autowired
    private BuildingDAOInt buildingDAO;

    @Override
    public Long addBuilding(Building building) {
        return buildingDAO.create(building);
    }

    @Override
    public Building getBuilding(Long id) {
        return buildingDAO.get(id);
    }

    @Override
    public void updateBuilding(Building building) {
        buildingDAO.update(building);
    }

    @Override
    public void deleteBuilding(Long id) {
        buildingDAO.delete(id);
    }

    @Override
    public List<Building> getBuildingList() {
        return buildingDAO.findAll();
    }
}
