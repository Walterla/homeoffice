package org.dlw.service;

import org.jmock.MockObjectTestCase;
import org.jmock.Mock;
import org.dlw.service.impl.VehicleManagerImpl;
import org.dlw.model.vehicle.Vehicle;
import org.dlw.dao.VehicleDao;
import org.dlw.dao.hibernate.VehicleDaoHibernate;

import java.util.ArrayList;
import java.util.List;

public class VehicleManagerTest extends MockObjectTestCase {
    private VehicleManager manager = new VehicleManagerImpl();
    private Mock dao = null;
    private Vehicle vehicle = null;

    protected void setUp() throws Exception {
        dao = new Mock(VehicleDao.class);
        manager.setDao((VehicleDao) dao.proxy());

    }

    protected void tearDown() throws Exception {
        manager = null;
    }

    public void testGetVehicle() {
        System.out.println("Test: GetVehicle");

        Long id = 1L;
        vehicle = new Vehicle();

        dao.expects(once()).method("get").with(eq(id)).will(returnValue(vehicle));
        Vehicle result = manager.getVehicle(id);
        assertSame(vehicle, result);
        dao.verify();

    }

    public void testGetVehicles() {
        System.out.println("Test: GetVehicles");

        List vehicles = new ArrayList();

        dao.expects(once()).method("getAll").will(returnValue(vehicles));

        List result = manager.getVehicles();
        assertSame(vehicles, result);
        dao.verify();

    }

    public void testGetVehicleMaintenances() {
        System.out.println("Test: GetVehicleMaintenances");

        List vehicleMaintenances = new ArrayList();

        dao.expects(once()).method("getAllChildren").will(returnValue(vehicleMaintenances));

        List result = manager.getVehicleMaintenances(new Long("1"));
        assertSame(vehicleMaintenances, result);
        dao.verify();
    }

    public void testSaveVehicle(){
        System.out.println("Test: SaveVehicle");

        vehicle = new Vehicle();

        dao.expects(once()).method("save").with(same(vehicle)).isVoid();

        manager.saveVehicle(vehicle);
        dao.verify();

    }

    public void testRemoveVehicle() throws Exception {
        System.out.println("Test: RemoveVehicle");

        Long id = 11L;
        vehicle = new Vehicle();

        dao.expects(once()).method("remove").with(eq(id)).isVoid();

        manager.removeVehicle(id);
        dao.verify();


    }
}
