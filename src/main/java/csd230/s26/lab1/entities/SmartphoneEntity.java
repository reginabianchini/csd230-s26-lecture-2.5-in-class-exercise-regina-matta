package csd230.s26.lab1.entities;

import csd230.s26.lab1.pojos.Smartphone;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
@DiscriminatorValue("SMARTPHONE")

public class SmartphoneEntity extends ProductEntity {
    private Double screenSize;
    private Integer cameraMegapixels;

    public SmartphoneEntity() {
        super();
    }

    public SmartphoneEntity(double screenSize, int cameraMegapixels) {
        super();
        this.cameraMegapixels = cameraMegapixels;
        this.screenSize = screenSize;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getCameraMegapixels() {
        return cameraMegapixels;
    }

    public void setCameraMegapixels(int cameraMegapixels) {
        this.cameraMegapixels = cameraMegapixels;
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
        SmartphoneEntity that = (SmartphoneEntity) o;
        return Double.compare(screenSize, that.screenSize) == 0 && cameraMegapixels == that.cameraMegapixels;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), screenSize, cameraMegapixels);
    }

    @Override
    public String toString() {
        return "SmartphoneEntity{" +
                "screenSize=" + screenSize +
                ", cameraMegapixels=" + cameraMegapixels +
                '}';
    }
}