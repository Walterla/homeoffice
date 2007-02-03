package org.dlw.service.impl;

import org.dlw.service.VehicleManager;
import org.dlw.dao.VehicleDao;
import org.dlw.model.vehicle.Vehicle;

import java.util.List;

public class VehicleManagerImpl implements VehicleManager {
    private VehicleDao dao = null;

    public void setDao(final VehicleDao vehicleDao) {
        this.dao = vehicleDao;
    }

    public List getVehicleMaintenances(final Long id) {
        return dao.getAllChildren(id);
    }

    public Vehicle getVehicle(final Long id) {
        return (Vehicle) dao.get(id);
    }

    public List getVehicles() {
        return dao.getAll();
    }

    public void saveVehicle(Vehicle vehicle) {
        dao.save(vehicle);
    }

    public void removeVehicle(Long id) {
        dao.remove(id);
    }
}
