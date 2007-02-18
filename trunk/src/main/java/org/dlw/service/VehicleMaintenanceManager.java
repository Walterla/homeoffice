package org.dlw.service;

import org.dlw.dao.VehicleMaintenanceDao;
import org.dlw.model.vehicle.Vehicle;
import org.dlw.model.vehicle.VehicleMaintenance;

import java.util.List;

public interface VehicleMaintenanceManager {

    public void setDao(VehicleMaintenanceDao dao);

    public VehicleMaintenance getVehicleMaintenance(String id);

    public List getVehicleMaintenances();

    public void saveVehicleMaintenance(VehicleMaintenance vehicleMaintenance);

    public void removeVehicleMaintenance(String id);

    public Vehicle getVehicle(String id);

}
