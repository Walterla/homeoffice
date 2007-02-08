package org.dlw.action.vehicle;

import org.appfuse.webapp.action.BaseAction;
import org.appfuse.service.GenericManager;
import org.dlw.model.vehicle.VehicleMaintenance;
import org.dlw.service.VehicleMaintenanceManager;

import java.util.List;
import java.text.MessageFormat;

import com.opensymphony.xwork2.Preparable;

/**
 * <p> This program is open software. It is licensed using the Apache Software
 * Foundation, version 2.0 January 2004
 * </p>
 * <a
 * href="mailto:dlwhitehurst@gmail.com">dlwhitehurst@gmail.com</a>
 *
 * @author David L Whitehurst
 */
public class VehicleMaintenanceAction extends BaseAction implements Preparable {
    //GenericManager<VehicleMaintenance, Long> manager;
    VehicleMaintenanceManager vehicleMaintenanceManager;
    VehicleMaintenance vehicleMaintenance;
    String id;

    public void setId(String id) {
        this.id = id;
    }

    public void setVehicleMaintenanceManager(VehicleMaintenanceManager vehicleMaintenanceManager) {
        this.vehicleMaintenanceManager = vehicleMaintenanceManager;
    }

    public VehicleMaintenance getVehicleMaintenance() {
        return vehicleMaintenance;
    }

    public void setVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
        this.vehicleMaintenance = vehicleMaintenance;
    }

    public String execute() {
        if (id != null) {
            vehicleMaintenance = vehicleMaintenanceManager.getVehicleMaintenance(id);
        }
        return "success";
    }

    public String save() {
        vehicleMaintenanceManager.saveVehicleMaintenance(vehicleMaintenance);
        super.saveMessage("VehicleMaintenance updated successfully!");
        return "form";
    }

    private List vehicleMaintenances;

    public List getVehicleMaintenances() {
        return this.vehicleMaintenances;
    }

    public String list() {
        vehicleMaintenances = vehicleMaintenanceManager.getVehicleMaintenances();
        return SUCCESS;
    }

    public String delete() {
        vehicleMaintenanceManager.removeVehicleMaintenance(vehicleMaintenance.getId());
        saveMessage(MessageFormat.format("{0} removed successfully.",
                vehicleMaintenance.getName()));
        return "form";
    }


    public void prepare() throws Exception {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            if (!"".equals(getRequest().getParameter("vehicleMaintenance.id"))) {
                // prevent failures on new
                vehicleMaintenance = vehicleMaintenanceManager.getVehicleMaintenance(getRequest().getParameter("vehicleMaintenance.id"));
            }
        }
    }
}
