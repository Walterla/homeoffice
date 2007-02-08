package org.dlw.model.vehicle;

import org.appfuse.model.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
 public class VehicleMaintenance extends BaseObject implements Serializable {
    Long id;
    String name;
    Date alarmDate;
    Date startDate;
    Date endDate;

    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    public Vehicle getVehicle() {
        return vehicle;
    }


    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    Vehicle vehicle;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAlarmDate() {
        return alarmDate;
    }

    public void setAlarmDate(Date alarmDate) {
        this.alarmDate = alarmDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Public toString implementation
     * @return
     */
   public String toString() {
       return name;
   }

    /**
     * Public equals implementation (very weak) based on name
     * @param object
     * @return
     */
    public boolean equals(Object object) {
        boolean result = false;
        if (this == object) return true;
        if (object instanceof VehicleMaintenance) {
            VehicleMaintenance unknown = (VehicleMaintenance) object;
            if (unknown.getName().equals(this.getName())) {
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

