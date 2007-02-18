package org.dlw.service;

import org.dlw.dao.VehicleDao;
import org.dlw.model.vehicle.Vehicle;

import java.util.List;

public interface VehicleManager {

    public void setDao(VehicleDao dao);

    public List getVehicleMaintenances(String id);

    public Vehicle getVehicle(String id);

    public List getVehicles();

    public void saveVehicle(Vehicle vehicle);

    public void removeVehicle(String id);
}
