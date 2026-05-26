package csd230.s26.lab1.pojos;

import java.util.Objects;
import java.util.Scanner;

/**
 * DTO for {@link csd230.s26.lab1.entities.SmartphoneEntity}
 */
public class Smartphone extends SmartDevice{
    private double screenSize;
    private int cameraMegapixels;

    public Smartphone(String operatingSystem, double screenSize, int cameraMegapixels) {
        super(operatingSystem);
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Double.compare(screenSize, that.screenSize) == 0 && cameraMegapixels == that.cameraMegapixels;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), screenSize, cameraMegapixels);
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
        return "Smartphone{" +
                "screenSize=" + screenSize +
                ", cameraMegapixels=" + cameraMegapixels +
                '}';
    }

    @Override
    public void edit(Scanner input) {

    }

    @Override
    public void initialize(Scanner input) {

    }
}
