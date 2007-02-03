package org.dlw.dao;

import org.appfuse.dao.BaseDaoTestCase;
import org.dlw.model.vehicle.Vehicle;
import org.dlw.model.vehicle.VehicleMaintenance;

import java.util.List;
import java.util.Iterator;

/**
 * <p> This program is open software. It is licensed using the Apache Software
 * Foundation, version 2.0 January 2004
 * </p>
 * <a
 * href="mailto:dlwhitehurst@gmail.com">dlwhitehurst@gmail.com</a>
 *
 * @author David L Whitehurst
 */
public class VehicleDaoTest extends BaseDaoTestCase {

    private Long vehicleId = new Long("1");
    private VehicleDao<Vehicle, Long> vehicleDao = null;

    public void setVehicleDao(VehicleDao<Vehicle, Long> vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    public void testAddVehicle() throws Exception {
        System.out.println("Test: AddVehicle");
        Vehicle vehicle = new Vehicle();

        // set required fields
        vehicle.setName("David's Truck");
        vehicle.setMake("Ford");
        vehicle.setModel("F-150");
        vehicle.setYear("1995");
        vehicle.setVIN("12345ABCDEF");


        vehicleDao.save(vehicle);

        // verify a primary key was assigned
        assertNotNull(vehicle.getId());

        // verify set fields are same after save
    }
    public void testGetChildren() throws Exception {
        System.out.println("Test: GetChildren");
        List list = vehicleDao.getAllChildren(vehicleId);
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            VehicleMaintenance vehicleMaintenance = (VehicleMaintenance) iter.next();
            System.out.println("Dao GetChildrenTest: " + vehicleMaintenance.getName());
        }
    }
/*

    public void testGetVehicle() throws Exception {
        Vehicle vehicle = vehicleDao.get(vehicleId);
        assertNotNull(vehicle);
    }

    public void testGetVehicles() throws Exception {
        Vehicle vehicle = new Vehicle();

        List results = vehicleDao.getAll();
        assertTrue(results.size() > 0);
    }

    public void testAddVehicleMaintenance() throws Exception {
        Vehicle vehicle = vehicleDao.get(vehicleId);
        VehicleMaintenance vehicleMaintenance = new VehicleMaintenance();
        vehicleMaintenance.setName("Oil Change");

        vehicle.getVehicleMaintenances().add(vehicleMaintenance);
        vehicleDao.save(vehicle);

        vehicle = null; // reset
        vehicle = vehicleDao.get(vehicleId);
        List list = vehicle.getVehicleMaintenances();
        assertTrue(list.size() > 0);

    }

    public void testGetVehicleMaintenances() throws Exception {
        List results = vehicleDao.getAllChildren(vehicleId);
        assertTrue(results.size() > 0);
    }

    public void testSaveVehicle() throws Exception {
        Vehicle vehicle = vehicleDao.get(vehicleId);

        // update required fields

        vehicleDao.save(vehicle);

    }
    public void testRemoveVehicle() throws Exception {
        Long removeId = new Long("1");
        vehicleDao.remove(removeId);
        try {
            Vehicle vehicle = vehicleDao.get(removeId);
            fail("vehicle found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
*/
}
