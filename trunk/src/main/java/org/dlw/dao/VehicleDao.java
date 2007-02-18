package org.dlw.dao;

import org.appfuse.dao.GenericDao;
import org.dlw.model.vehicle.VehicleMaintenance;

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
public interface VehicleDao<T, PK extends java.io.Serializable> extends GenericDao {

    public List<VehicleMaintenance> getAllChildren(Long id);
    
}
