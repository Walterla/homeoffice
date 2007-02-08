package org.dlw.dao.hibernate;

import org.dlw.dao.VehicleMaintenanceDao;
import org.dlw.model.vehicle.Vehicle;
import org.dlw.model.vehicle.VehicleMaintenance;
import org.appfuse.dao.hibernate.GenericDaoHibernate;

public class VehicleMaintenanceDaoHibernate extends GenericDaoHibernate implements VehicleMaintenanceDao {

    public VehicleMaintenanceDaoHibernate() {
        super(VehicleMaintenance.class);
    }


    public Vehicle getVehicle(Long id) {
        VehicleMaintenance vehicleMaintenance = (VehicleMaintenance) this.get(id);
        return vehicleMaintenance.getVehicle();
    }
}
