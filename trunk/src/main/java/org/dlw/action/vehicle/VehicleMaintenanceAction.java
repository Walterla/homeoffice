package org.dlw.action.vehicle;

/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import org.appfuse.webapp.action.BaseAction;
import org.appfuse.service.GenericManager;
import org.dlw.model.vehicle.VehicleMaintenance;
import org.dlw.service.VehicleMaintenanceManager;

import java.util.List;
import java.text.MessageFormat;

import com.opensymphony.xwork2.Preparable;

/**
 * This class implements the Struts2 action for the VehicleMaintenance object
 *
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version $Id$
 * @description Struts2 Action Class for VehicleMaintenance
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
        vehicleMaintenanceManager.removeVehicleMaintenance(vehicleMaintenance.getId().toString());
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
