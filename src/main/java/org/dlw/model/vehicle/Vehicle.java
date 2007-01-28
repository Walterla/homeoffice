package org.dlw.model.vehicle;

import org.appfuse.model.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

@Entity
 public class Vehicle extends BaseObject implements Serializable {
    Long id;
    String name;    // e.g. David's Truck
    String make;    // e.g. Ford
    String model;   // e.g. F-150
    String year;    // e.g. 1995
    String VIN;     // 1234ABC999-ZXYY (alphanumeric unique identifier)
    List<VehicleMaintenance> vehicleMaintenances = new ArrayList<VehicleMaintenance>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getVIN() {
         return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    @OneToMany(mappedBy="vehicle")
    @OrderBy("alarmDate")
    public List<VehicleMaintenance> getVehicleMaintenances() {
        return vehicleMaintenances;
    }

    public void setVehicleMaintenances(List<VehicleMaintenance> vehicleMaintenances) {
        this.vehicleMaintenances = vehicleMaintenances;
    }

     /**
      * Public toString implementation
      * @return
      */
    public String toString() {
        String tmp = null;
        if (year != null && make != null && model != null) {
            tmp = year + " " + make + " " + model;
        } else {
            tmp = name;
        }
        return tmp;
    }

     /**
      * Public equals implementation based on Vehicle Identification Number
      * @param object
      * @return
      */
    public boolean equals(Object object) {
        boolean result = false;
        if (this == object) return true;
        if (object instanceof Vehicle) {
            Vehicle unknown = (Vehicle) object;
            if (unknown.getVIN().equals(this.getVIN())) {
                result = true;
            }
        }
        return result;
    }

     /**
      * Public hashcode implementation based on String hash() return
      * @return
      */
    public int hashCode() {
        return (name != null ? name.hashCode() : 0);
    }
}
