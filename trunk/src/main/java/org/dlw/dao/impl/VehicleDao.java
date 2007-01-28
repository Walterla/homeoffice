package org.dlw.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.dlw.model.vehicle.Vehicle;
import org.dlw.model.vehicle.VehicleMaintenance;
import org.dlw.dao.ParentChildDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
public class VehicleDao extends HibernateDaoSupport implements ParentChildDao<Vehicle, Long> {
    protected final Log log = LogFactory.getLog(getClass());

    /**
     * Returns list of all Vehicles in database.  Uses loadAll method from
     * HibernateDaoSupport (super).
     * @return a List of Vehicle objects
     */
    public List<Vehicle> getAll() {
       return super.getHibernateTemplate().loadAll(this.getClass());
    }

    /**
     * Returns list of all child VehicleMaintenance objects related to this Vehicle.
     * @param id
     * @return a List of VehicleMaintenance objects for this Vehicle
     */
    public List<VehicleMaintenance> getAllChildren(Long id) {
        Vehicle vehicle = this.get(id);
        return vehicle.getVehicleMaintenances();  
    }

    /**
     * Returns the Vehicle object based on it's primary key or Long id
     * @param id
     * @return the Vehicle by id
     */
    public Vehicle get(Long id) {
        Vehicle vehicle = (Vehicle) super.getHibernateTemplate().get(this.getClass(), id);

        if (vehicle == null) {
            log.warn("Uh oh, '" + this.getClass() + "' object with id '" + id + "' not found...");
            throw new ObjectRetrievalFailureException(this.getClass(), id);
        }

        return vehicle;

    }

    /**
     * Saves specified Vehicle
     * @param object
     */
    public void save(Vehicle object) {
        super.getHibernateTemplate().saveOrUpdate(object);
    }

    /**
     * Removes Vehicle based on primary key specified
     * @param id
     */
    public void remove(Long id) {
        super.getHibernateTemplate().delete(this.get(id));
    }

}
