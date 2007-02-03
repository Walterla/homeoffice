package org.dlw.dao.hibernate;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.dlw.dao.VehicleDao;
import org.dlw.model.vehicle.Vehicle;

import java.util.List;

public class VehicleDaoHibernate extends GenericDaoHibernate implements VehicleDao {

    public VehicleDaoHibernate() {
        super(Vehicle.class);
    }

    public List getAllChildren(Long id) {
        Vehicle vehicle = (Vehicle) this.get(id);
        return vehicle.getVehicleMaintenances();
    }
}
