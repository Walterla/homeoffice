package org.dlw.action.vehicle;

import org.appfuse.webapp.action.BaseAction;
import org.appfuse.service.GenericManager;
import org.dlw.model.vehicle.Vehicle;

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
    GenericManager<Vehicle, Long> manager;
    Vehicle vehicle;
    Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public void setVehicleManager(GenericManager<Vehicle, Long> genericManager) {
        this.manager = genericManager;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String execute() {
        if (id != null) {
            vehicle = manager.get(id);
        }
        return "success";
    }

    public String save() {
        manager.save(vehicle);
        super.saveMessage("Vehicle updated successfully!");
        return "form";
    }

    private List vehicles;

    public List getVehicles() {
        return this.vehicles;
    }

    public String list() {
        vehicles = manager.getAll();
        return SUCCESS;
    }

    public String delete() {
        manager.remove(vehicle.getId());
        saveMessage(MessageFormat.format("{0} removed successfully.",
                vehicle.getYear() + ' ' + vehicle.getMake() + ' ' + vehicle.getModel()));
        return "form";
    }

}
