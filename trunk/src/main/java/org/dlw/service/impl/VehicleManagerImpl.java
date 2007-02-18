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

    public List getVehicleMaintenances(String id) {
        return dao.getAllChildren(new Long(id));
    }

    public Vehicle getVehicle(String id) {
        return (Vehicle) dao.get(new Long(id));
    }

    public List getVehicles() {
        return dao.getAll();
    }

    public void saveVehicle(Vehicle vehicle) {
        dao.save(vehicle);
    }

    public void removeVehicle(String id) {
        dao.remove(new Long(id));
    }
}
