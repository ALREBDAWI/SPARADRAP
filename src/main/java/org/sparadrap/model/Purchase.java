package org.sparadrap.model;

import java.time.LocalDate;

public class Purchase {

    private boolean isWithPrescription;
    private Prescription prescription;
    private LocalDate purchaseDate;


    // --------- constructor -----------

    public Purchase(boolean isWithPrescription, Prescription prescription, LocalDate purchaseDate) {
        setIsWithPrescription(isWithPrescription);
        setPrescription(prescription);
        setPurchaseDate(purchaseDate);
    }


    // --------- getters and setters ----------

    public boolean getIsWithPrescription() {
        return this.isWithPrescription;
    }
    public void setIsWithPrescription(boolean isWithPrescription) {
        this.isWithPrescription = isWithPrescription;
    }

    public Prescription getPrescription() {
        return this.prescription;
    }
    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public LocalDate getPurchaseDate() {
        return this.purchaseDate;
    }
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void displayInfo(){
        System.out.println("---- Purchase Information ----");
        System.out.printf("%-25s: %s%n", "With Prescription", isWithPrescription ? "Yes" : "No");
        System.out.printf("%-25s: %s%n", "Purchase Date", purchaseDate);

        if (prescription != null) {
            System.out.println("---- Prescription Details ----");
            System.out.printf("%-25s: %s%n", "Prescription Date", prescription.getPrescriptionDate());
            System.out.printf("%-25s: %s %s%n", "Doctor", prescription.getTreatingDoctor().getName(), prescription.getTreatingDoctor().getLastName());
            System.out.printf("%-25s: %s %s%n", "Patient", prescription.getPatient().getName(), prescription.getPatient().getLastName());

            System.out.println("---- Medicines ----");
            for (Medicine med : prescription.getMedicineList()) {
                System.out.printf("%-25s: %s (%s)%n", "Medicine Name", med.getMedicineName(), med.getCategory());
                System.out.printf("%-25s: %d%n", "Price", med.getPrice());
    }

}}}
