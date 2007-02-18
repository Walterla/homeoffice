package org.dlw.dao.hibernate;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.dlw.dao.VehicleDao;
import org.dlw.model.vehicle.Vehicle;

import java.util.List;

/**
 * <p> This program is open software. It is licensed using the Apache Software
 * Foundation, version 2.0 January 2004
 * </p>
 * <a
 * href="mailto:dlwhitehurst@gmail.com">dlwhitehurst@gmail.com</a>
 *
 * @author David L Whitehurst
 */
public class VehicleDaoHibernate extends GenericDaoHibernate implements VehicleDao {

    public VehicleDaoHibernate() {
        super(Vehicle.class);
    }

    public List getAllChildren(Long id) {
        Vehicle vehicle = (Vehicle) this.get(id);
        return vehicle.getVehicleMaintenances();
    }
}
