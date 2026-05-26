package csd230.s26.lab1.pojos;

import java.util.Objects;
import java.util.Scanner;

public abstract class Publication extends Product {
    private String title = "";
    private double price = 0.0;
    private int copies = 0;

    public Publication() {
    }

    public Publication(String title, double price, int copies) {
        this.title = title;
        this.price = price;
        this.copies = copies;
    }


//    // Helper used by subclasses during initialize
//    protected void initPriceCopies() {
//        System.out.println("Enter copies:");
//        this.copies = getInput(0);
//
//        System.out.println("Enter price:");
//        this.price = getInput(0.0);
//    }

    @Override
    public void initialize(Scanner input) {
        System.out.println("Enter Title:");
        this.title = getInput(input, "Available Title");
    }

    // Pass scanner to helper
    protected void initPriceCopies(Scanner input) {
        System.out.println("Enter copies:");
        this.copies = getInput(input, 0);

        System.out.println("Enter price:");
        this.price = getInput(input, 0.0);
    }

    @Override
    public void edit(Scanner input) {
        System.out.println("Edit Title [" + this.title + "]:");
        this.title = getInput(input, this.title);

        System.out.println("Edit Price [" + this.price + "]:");
        this.price = getInput(input, this.price);

        System.out.println("Edit Copies [" + this.copies + "]:");
        this.copies = getInput(input, this.copies);
    }
    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", copies=" + copies +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publication)) return false;
        Publication that = (Publication) o;
        return Double.compare(that.price, price) == 0 &&
                copies == that.copies &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, copies);
    }
}
