package csd230.s26.lab1.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PUBLICATION")
public abstract class PublicationEntity extends ProductEntity {
    private String title;
    private double price;
    private int copies;

    public PublicationEntity() {
        setTitle("Publication");
        setPrice(0.0);
        setCopies(0);
    }

    public PublicationEntity(String title, double price, int copies) {
        this.title = title;
        this.price = price;
        this.copies = copies;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getCopies() { return copies; }
    public void setCopies(int copies) { this.copies = copies; }
}