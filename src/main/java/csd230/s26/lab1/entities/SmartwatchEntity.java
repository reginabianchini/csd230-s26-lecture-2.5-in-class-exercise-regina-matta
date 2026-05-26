package csd230.s26.lab1.entities;

import csd230.s26.lab1.pojos.Smartwatch;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
@DiscriminatorValue("SMARTWATCH")
public class SmartwatchEntity extends ProductEntity {
    private Boolean heartRateMonitor;
    private int batteryLifeHours;

    public SmartwatchEntity() {}

    public SmartwatchEntity( boolean heartRateMonitor, int batteryLifeHours) {
        this.heartRateMonitor = heartRateMonitor;
        this.batteryLifeHours = batteryLifeHours;
    }

    public boolean isHeartRateMonitor() {
        return heartRateMonitor;
    }

    public void setHeartRateMonitor(boolean heartRateMonitor) {
        this.heartRateMonitor = heartRateMonitor;
    }

    public int getBatteryLifeHours() {
        return batteryLifeHours;
    }

    public void setBatteryLifeHours(int batteryLifeHours) {
        this.batteryLifeHours = batteryLifeHours;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SmartwatchEntity that = (SmartwatchEntity) o;
        return heartRateMonitor == that.heartRateMonitor && batteryLifeHours == that.batteryLifeHours;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), heartRateMonitor, batteryLifeHours);
    }

    @Override
    public void sellItem() {

    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String toString() {
        return "SmartwatchEntity{" +
                "heartRateMonitor=" + heartRateMonitor +
                ", batteryLifeHours=" + batteryLifeHours +
                '}';
    }
}