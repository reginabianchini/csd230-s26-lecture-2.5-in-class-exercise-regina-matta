package csd230.s26.lab1.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.Objects;

@Entity
@DiscriminatorValue("SMARTDEVICE")
public abstract class SmartDeviceEntity extends ProductEntity {
    private String operatingSystem;
    private Boolean wifiEnabled;

    public SmartDeviceEntity(){
        setOperatingSystem("Apple");
        setWifiEnabled(true);
    }

    public SmartDeviceEntity(String operatingSystem, Boolean wifiEnabled) {
            this.operatingSystem = operatingSystem;
            this.wifiEnabled = wifiEnabled;
        }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Boolean getWifiEnabled() {
        return wifiEnabled;
    }

    public void setWifiEnabled(Boolean wifiEnabled) {
        this.wifiEnabled = wifiEnabled;
    }


    @Override
    public void sellItem() {

    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SmartDeviceEntity that = (SmartDeviceEntity) o;
        return Objects.equals(operatingSystem, that.operatingSystem) && Objects.equals(wifiEnabled, that.wifiEnabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), operatingSystem, wifiEnabled);
    }

    @Override
    public String toString() {
        return "SmartDeviceEntity{" +
                "operatingSystem='" + operatingSystem + '\'' +
                ", wifiEnabled=" + wifiEnabled +
                '}';
    }
}

