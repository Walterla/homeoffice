package org.dlw.dao.hibernate;

import org.dlw.dao.VehicleMaintenanceDao;
import org.dlw.model.vehicle.Vehicle;
import org.dlw.model.vehicle.VehicleMaintenance;
import org.appfuse.dao.hibernate.GenericDaoHibernate;

/**
 * <p> This program is open software. It is licensed using the Apache Software
 * Foundation, version 2.0 January 2004
 * </p>
 * <a
 * href="mailto:dlwhitehurst@gmail.com">dlwhitehurst@gmail.com</a>
 *
 * @author David L Whitehurst
 */
public class VehicleMaintenanceDaoHibernate extends GenericDaoHibernate implements VehicleMaintenanceDao {

    public VehicleMaintenanceDaoHibernate() {
        super(VehicleMaintenance.class);
    }


    public Vehicle getVehicle(Long id) {
        VehicleMaintenance vehicleMaintenance = (VehicleMaintenance) this.get(id);
        return vehicleMaintenance.getVehicle();
    }
}
