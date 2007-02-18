package org.dlw.service.impl;

import org.dlw.service.VehicleMaintenanceManager;
import org.dlw.dao.VehicleMaintenanceDao;
import org.dlw.model.vehicle.VehicleMaintenance;
import org.dlw.model.vehicle.Vehicle;

import java.util.List;

public class VehicleMaintenanceManagerImpl implements VehicleMaintenanceManager {
    private VehicleMaintenanceDao dao = null;


    public void setDao(VehicleMaintenanceDao vehicleMaintenanceDao) {
        this.dao = vehicleMaintenanceDao;
    }

    public VehicleMaintenance getVehicleMaintenance(String id) {
        return (VehicleMaintenance) dao.get(new Long(id));
    }

    public List getVehicleMaintenances() {
        return dao.getAll();
    }

    public void saveVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
        dao.save(vehicleMaintenance);
    }

    public void removeVehicleMaintenance(String id) {
        dao.remove(new Long(id));
    }

    public Vehicle getVehicle(String id) {
        return dao.getVehicle(new Long(id));
    }
}
