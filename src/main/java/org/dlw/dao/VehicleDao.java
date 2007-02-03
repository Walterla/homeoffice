package org.dlw.dao;

import org.appfuse.dao.GenericDao;
import org.dlw.model.vehicle.VehicleMaintenance;

import java.util.List;

public interface VehicleDao<T, PK extends java.io.Serializable> extends GenericDao {

    public List<VehicleMaintenance> getAllChildren(Long id);
    
}
