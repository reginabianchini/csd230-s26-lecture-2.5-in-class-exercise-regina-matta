package csd230.s26.lab1.pojos;

import java.util.Objects;
import java.util.Scanner;

/**
 * DTO for {@link csd230.s26.lab1.entities.SmartwatchEntity}
 */
public class Smartwatch extends SmartDevice{
    private Boolean heartRateMonitor;
    private Integer batteryLifeHours;

    public Smartwatch(String operatingSystem, boolean heartRateMonitor, int batteryLifeHours) {
        super(operatingSystem);
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
        Smartwatch that = (Smartwatch) o;
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
        return "Smartwatch{" +
                "heartRateMonitor=" + heartRateMonitor +
                ", batteryLifeHours=" + batteryLifeHours +
                '}';
    }

    @Override
    public void edit(Scanner input) {

    }

    @Override
    public void initialize(Scanner input) {

    }
}
