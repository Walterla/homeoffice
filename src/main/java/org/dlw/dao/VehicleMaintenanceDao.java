package org.dlw.dao;

import org.appfuse.dao.GenericDao;
import org.dlw.model.vehicle.Vehicle;

public interface VehicleMaintenanceDao<T, PK extends java.io.Serializable> extends GenericDao {

    public Vehicle getVehicle(Long id);

}
