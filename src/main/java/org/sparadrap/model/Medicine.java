package org.sparadrap.model;

import java.time.LocalDate;

public class Medicine {
    private String medicineName;
    private String category;
    private int price;
    private LocalDate startDate;
    private int quantity;
    private boolean isWithPrescription;

    // ----------------- constructor -----------------

    public Medicine(String medicineName, String category, int price, LocalDate startDate, int quantity, boolean isWithPrescription) {
        setMedicineName(medicineName);
        setCategory(category);
        setPrice(price);
        setStartDate(startDate);
        setQuantity(quantity);
        setWithPrescription(isWithPrescription);
    }

    // -------------- getters and setters --------------

    public String getMedicineName() {
        return this.medicineName;
    }
    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getCategory() {
        return this.category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getQuantity() {
        return this.quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isWithPrescription() {
        return this.isWithPrescription;
    }
    public void setWithPrescription(boolean withPrescription) {
        this.isWithPrescription = withPrescription;
    }

    public void displayInfo(){
        System.out.println("---- Medicine Information ----");
        System.out.printf("%-25s: %s%n", "Medicine Name", medicineName);
        System.out.printf("%-25s: %s%n", "Category", category);
        System.out.printf("%-25s: %d%n", "Price", price);
        System.out.printf("%-25s: %s%n", "Start Date", startDate);
        System.out.printf("%-25s: %d%n", "Quantity", quantity);
        System.out.printf("%-25s: %s%n", "Requires Prescription", isWithPrescription ? "Yes" : "No");
        System.out.println("--------------------------------");

    }

}
