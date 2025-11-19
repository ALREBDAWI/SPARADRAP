package org.sparadrap.model.MedicineModel;

import java.time.LocalDate;

/**
 * Represents a Medicine entity in the system.
 * Contains details such as name, category, price, start date, quantity, and prescription requirement.
 */
public class Medicine {
    private int id;
    private String medicineName;
    private MedicineCategory category;
    private double price;
    private LocalDate startDate;
    private int quantity;

    /** Indicates if the medicine requires a prescription */
    private boolean isWithPrescription;

    // ----------------- constructor -----------------

    /**
     * Creates a new Medicine object with all required attributes.
     *
     * @param medicineName Name of the medicine
     * @param category Category of the medicine
     * @param price Price of the medicine (must be non-negative)
     * @param startDate Start date of availability (cannot be in the future)
     * @param quantity Quantity available (must be non-negative)
     * @param isWithPrescription True if the medicine requires a prescription
     * @throws IllegalArgumentException if any validation fails
     */
    public Medicine(String medicineName, MedicineCategory category, double price, LocalDate startDate, int quantity, boolean isWithPrescription) {
        setMedicineName(medicineName);
        setCategory(category);
        setPrice(price);
        setStartDate(startDate);
        setQuantity(quantity);
        setWithPrescription(isWithPrescription);
    }

    // =================================================
    // -------------- getters and setters --------------
    // =================================================

    public int getId() {
        return this.id;
    }

    public String getMedicineName() {
        return this.medicineName;
    }

    /**
     * Sets the medicine name after validating it.
     *
     * @param medicineName name to set
     * @throws IllegalArgumentException if the name contains invalid characters
     */
    public void setMedicineName(String medicineName) {
        // Name validation: letters, numbers, spaces, hyphens, underscores
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

    /**
     * Returns the start date of availability.
     *
     * @return start date
     */
    public LocalDate getStartDate() {
        return this.startDate;
    }

    /**
     * Sets the start date of availability.
     *
     * @param startDate start date to set (cannot be null or in the future)
     * @throws IllegalArgumentException if startDate is null or after today
     */
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

    /**
     * Returns whether the medicine requires a prescription.
     *
     * @return true if prescription required, false otherwise
     */
    public boolean isWithPrescription() {
        return this.isWithPrescription;
    }

    /**
     * Sets whether the medicine requires a prescription.
     *
     * @param withPrescription true if prescription required, false otherwise
     */
    public void setWithPrescription(boolean withPrescription) {
        this.isWithPrescription = withPrescription;
    }

    // ----------------- Display Info -----------------

    /**
     * Returns a formatted string containing all medicine information.
     *
     * @return string with medicine details
     */
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
