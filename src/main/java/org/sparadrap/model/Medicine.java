package org.sparadrap.model;

import java.time.LocalDate;

public class Medicine {
    private String medicineName;
    private MedicineCategory category;
    private double price;
    private LocalDate startDate;
    private int quantity;
    private boolean isWithPrescription;

    // ----------------- constructor -----------------

    public Medicine(String medicineName, MedicineCategory category, double price, LocalDate startDate, int quantity, boolean isWithPrescription) {
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
        String regex = "^[\\p{L}0-9]+(?:[ '\\-_][\\p{L}0-9]+)*$";
        if(medicineName.matches(regex)){
            this.medicineName = medicineName;
        }else{
            throw new IllegalArgumentException("Invalid medicine name");
        }
    }

    public MedicineCategory getCategory() {
        return this.category;
    }
    public void setCategory(MedicineCategory category) {
        this.category = category;
    }

    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        if(price < 0){
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }
    public void setStartDate(LocalDate startDate) {
        if(startDate == null || startDate.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Start date cannot be after now");
        }
        this.startDate = startDate;
    }

    public int getQuantity() {
        return this.quantity;
    }
    public void setQuantity(int quantity) {
        if(quantity < 0){
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    public boolean isWithPrescription() {
        return this.isWithPrescription;
    }
    public void setWithPrescription(boolean withPrescription) {
        this.isWithPrescription = withPrescription;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---- Medicine Information ----\n");
        sb.append(String.format("%-25s: %s%n", "Medicine Name", medicineName));
        sb.append(String.format("%-25s: %s%n", "Category", category));
        sb.append(String.format("%-25s: %.2f%n", "Price", price));
        sb.append(String.format("%-25s: %s%n", "Start Date", startDate));
        sb.append(String.format("%-25s: %d%n", "Quantity", quantity));
        sb.append(String.format("%-25s: %s%n", "Requires Prescription", isWithPrescription ? "Yes" : "No"));
        sb.append("--------------------------------\n");
        return sb.toString();
    }
}
