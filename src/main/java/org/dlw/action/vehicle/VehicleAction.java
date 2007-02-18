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
import org.dlw.model.vehicle.Vehicle;
import org.dlw.dao.VehicleDao;
import org.dlw.service.VehicleManager;

import java.util.List;
import java.text.MessageFormat;

/**
 * This class implements the Struts2 action for the Vehicle object
 *
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version $Id$
 * @description Struts2 Action Class for Vehicle
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
        vehicleMaintenances = vehicleManager.getVehicleMaintenances(vehicle.getId().toString());
        return SUCCESS;
    }

    public String execute() {
        if (id != null) {
            vehicle = (Vehicle) vehicleManager.getVehicle(id.toString());
        }
        return "success";
    }

    public String save() {
        vehicleManager.saveVehicle(vehicle);
        super.saveMessage("Vehicle updated successfully!");
        return "form";
    }

    public String delete() {
        vehicleManager.removeVehicle(vehicle.getId().toString());
        saveMessage(MessageFormat.format("{0} removed successfully.",
                vehicle.getYear() + ' ' + vehicle.getMake() + ' ' + vehicle.getModel()));
        return "form";
    }

}
