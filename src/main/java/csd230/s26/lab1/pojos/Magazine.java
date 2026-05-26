package csd230.s26.lab1.pojos;

import java.util.Date;
import java.util.Scanner;

public class Magazine extends Publication {
    private int orderQty = 0;
    private Date currentIssue = new Date();

    public Magazine() {
    }

    public Magazine(int orderQty, Date currentIssue, String title, double price, int copies) {
        super(title, price, copies);
        this.orderQty = orderQty;
        this.currentIssue = currentIssue;
    }

    @Override
    public void initialize(Scanner input) {
        super.initialize(input); // Title

        System.out.println("Enter Order Qty:");
        this.orderQty = getInput(input, 0);

        System.out.println("Enter Current Issue Date (dd-MMM-yyyy):");
        this.currentIssue = getInput(input, new Date());

        super.initPriceCopies(input); // Copies, Price
    }

    @Override
    public void edit(Scanner input) {
        super.edit(input); // Title, Price, Copies

        System.out.println("Edit Order Qty [" + this.orderQty + "]:");
        this.orderQty = getInput(input, this.orderQty);

        System.out.println("Edit Issue Date [" + this.currentIssue + "]:");
        this.currentIssue = getInput(input, this.currentIssue);
    }

    @Override
    public void sellItem() {
        System.out.println("Selling Magazine: " + getTitle());
        setCopies(getCopies() - 1);
    }

    public int getOrderQty() { return orderQty; }
    public void setOrderQty(int o) { this.orderQty = o; }
    public Date getCurrentIssue() { return currentIssue; }
    public void setCurrentIssue(Date d) { this.currentIssue = d; }

    @Override
    public String toString() {
        return "Magazine{orderQty=" + orderQty + ", issue=" + currentIssue + ", " + super.toString() + "}";
    }
}
