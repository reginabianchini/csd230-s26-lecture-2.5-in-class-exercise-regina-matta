package csd230.s26.lab1.pojos;

import csd230.s26.lab1.entities.ProductEntity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * DTO for {@link csd230.s26.lab1.entities.SmartDeviceEntity}
 */
public abstract class SmartDevice extends Product {
    private String operatingSystem = "";
    private Boolean wifiEnabled =true;

    public SmartDevice(){}

    public SmartDevice(String operatingSystem, Boolean wifiEnabled){
        this.operatingSystem= operatingSystem;
        this.wifiEnabled= wifiEnabled;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public SmartDevice(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
    public boolean isWifiEnabled() {
        return wifiEnabled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), operatingSystem, wifiEnabled);
    }

    public void setWifiEnabled(boolean wifiEnabled) {
        this.wifiEnabled = wifiEnabled;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SmartDevice that = (SmartDevice) o;
        return wifiEnabled == that.wifiEnabled && Objects.equals(operatingSystem, that.operatingSystem);
    }
    @Override
    public String toString() {
        return "SmartDevice{" +
                "operatingSystem='" + operatingSystem + '\'' +
                ", wifiEnabled=" + wifiEnabled +
                '}';
    }
}


