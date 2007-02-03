package org.dlw.action.vehicle;

import org.appfuse.webapp.action.BaseAction;
import org.dlw.model.vehicle.Vehicle;
import org.dlw.dao.VehicleDao;
import org.dlw.service.VehicleManager;

import java.util.List;
import java.text.MessageFormat;

/**
 * <p> This program is open software. It is licensed using the Apache Software
 * Foundation, version 2.0 January 2004
 * </p>
 * <a
 * href="mailto:dlwhitehurst@gmail.com">dlwhitehurst@gmail.com</a>
 *
 * @author David L Whitehurst
 */
public class VehicleAction extends BaseAction {
    private List vehicles;
    private List vehicleMaintenances;

    VehicleManager vehicleManager;
    Vehicle vehicle;
    Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public void setVehicleManager(VehicleManager vehicleManager) {
        this.vehicleManager = vehicleManager;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String execute() {
        if (id != null) {
            vehicle = (Vehicle) vehicleManager.getVehicle(id);
        }
        return "success";
    }

    public String save() {
        vehicleManager.saveVehicle(vehicle);
        super.saveMessage("Vehicle updated successfully!");
        return "form";
    }


    public List getVehicles() {
        return this.vehicles;
    }

    public List getVehicleMaintenances() {
        return this.vehicleMaintenances;
    }

    public String list() {
        vehicles = vehicleManager.getVehicles();
        return SUCCESS;
    }

    public String listChildren() {
        vehicleMaintenances = vehicleManager.getVehicleMaintenances(vehicle.getId());
        return SUCCESS;
    }

    public String delete() {
        vehicleManager.removeVehicle(vehicle.getId());
        saveMessage(MessageFormat.format("{0} removed successfully.",
                vehicle.getYear() + ' ' + vehicle.getMake() + ' ' + vehicle.getModel()));
        return "form";
    }

}
