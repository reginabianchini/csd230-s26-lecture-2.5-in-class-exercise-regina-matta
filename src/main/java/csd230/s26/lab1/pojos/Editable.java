package csd230.s26.lab1.pojos;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public abstract class Editable implements Serializable, SaleableItem {

    // REMOVED: public Scanner input = new Scanner(System.in);
    // REMOVED: setSystemInput() - No longer needed, we inject manually.

    // 1. Update Abstract Methods to accept the dependency
    public abstract void edit(Scanner input);
    public abstract void initialize(Scanner input);

    // 2. Update Helper methods to use the passed Scanner
    public String getInput(Scanner input, String defaultValue) {
        // Handle empty buffer issues by reading raw
        String ss = input.nextLine();
        if (ss.trim().isEmpty()) {
            return defaultValue;
        }
        // Return the raw string (no need for second scanner here usually)
        return ss.trim();
    }

    public int getInput(Scanner input, int defaultValue) {
        String s = input.nextLine();
        if (s.trim().isEmpty()) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public double getInput(Scanner input, double defaultValue) {
        String s = input.nextLine();
        if (s.trim().isEmpty()) {
            return defaultValue;
        }
        try {
            return Double.parseDouble(s.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public boolean getInput(Scanner input, boolean defaultValue) {
        String s = input.nextLine();
        if (s.trim().isEmpty()) {
            return defaultValue;
        }
        return Boolean.parseBoolean(s.trim());
    }

    public Date getInput(Scanner input, Date defaultValue) {
        String s = input.nextLine();
        if (s.trim().isEmpty()) {
            return defaultValue;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        try {
            return formatter.parse(s.trim());
        } catch (ParseException e) {
            System.out.println("Invalid Date. Keeping default.");
            return defaultValue;
        }
    }
}