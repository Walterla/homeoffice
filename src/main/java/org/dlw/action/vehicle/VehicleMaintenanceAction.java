package org.dlw.action.vehicle;

import org.appfuse.webapp.action.BaseAction;
import org.appfuse.service.GenericManager;
import org.dlw.model.vehicle.VehicleMaintenance;

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
public class VehicleMaintenanceAction extends BaseAction {
    GenericManager<VehicleMaintenance, Long> manager;
    VehicleMaintenance vehicleMaintenance;
    Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public void setVehicleMaintenanceManager(GenericManager<VehicleMaintenance, Long> genericManager) {
        this.manager = genericManager;
    }

    public VehicleMaintenance getVehicleMaintenance() {
        return vehicleMaintenance;
    }

    public void setVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
        this.vehicleMaintenance = vehicleMaintenance;
    }

    public String execute() {
        if (id != null) {
            vehicleMaintenance = manager.get(id);
        }
        return "success";
    }

    public String save() {
        manager.save(vehicleMaintenance);
        super.saveMessage("VehicleMaintenance updated successfully!");
        return "form";
    }

    private List vehicleMaintenances;

    public List getVehicleMaintenances() {
        return this.vehicleMaintenances;
    }

    public String list() {
        vehicleMaintenances = manager.getAll();
        return SUCCESS;
    }

    public String delete() {
        manager.remove(vehicleMaintenance.getId());
        saveMessage(MessageFormat.format("{0} removed successfully.",
                vehicleMaintenance.getName()));
        return "form";
    }


}
