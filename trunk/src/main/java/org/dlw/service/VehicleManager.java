package org.dlw.service;

import org.dlw.dao.VehicleDao;
import org.dlw.dao.hibernate.VehicleDaoHibernate;
import org.dlw.model.vehicle.Vehicle;

import java.util.List;

public interface VehicleManager {

    public void setDao(VehicleDao dao);

    public List getVehicleMaintenances(Long id);

    public Vehicle getVehicle(Long id);

    public List getVehicles();

    public void saveVehicle(Vehicle vehicle);

    public void removeVehicle(Long id);
}
