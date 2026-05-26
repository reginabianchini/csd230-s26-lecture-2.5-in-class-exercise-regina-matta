package csd230.s26.lab1.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BOOK")
public class BookEntity extends PublicationEntity {
    private String author;

    public BookEntity() {}

    public BookEntity(String author, String title, double price, int copies) {
        this.author = author;
        this.setTitle(title);
        this.setPrice(price);
        this.setCopies(copies);
    }

    // Getters and Setters
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    @Override
    public void sellItem() {
        System.out.println("Selling Book");
    }
}