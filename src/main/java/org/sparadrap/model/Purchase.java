package org.sparadrap.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Purchase {

    private boolean isWithPrescription;
    private Prescription prescription;
    private LocalDate purchaseDate;
    private List<Medicine> PurchasedMeds;


    // --------- constructor -----------

    public Purchase(boolean isWithPrescription, Prescription prescription, LocalDate purchaseDate, List<Medicine> PurchasedMeds) {
        setIsWithPrescription(isWithPrescription);
        setPrescription(prescription);
        setPurchaseDate(purchaseDate);
        setPurchasedMeds(PurchasedMeds);
    }

    public Purchase(boolean isWithPrescription, LocalDate purchaseDate, List<Medicine> PurchasedMeds) {
        setIsWithPrescription(isWithPrescription);
        setPurchaseDate(purchaseDate);
        setPurchasedMeds(PurchasedMeds);
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
        if (purchaseDate == null || purchaseDate.isAfter(LocalDate.now())) {
            throw  new IllegalArgumentException("Purchase date is null or after now");
        }
        this.purchaseDate = purchaseDate;
    }
    public List<Medicine> getPurchasedMeds() {
        return this.PurchasedMeds;
    }
    public void setPurchasedMeds(List<Medicine> PurchasedMeds) {
        this.PurchasedMeds = PurchasedMeds;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---- Purchase Information ----\n");
        sb.append(String.format("%-25s: %s%n", "With Prescription", isWithPrescription ? "Yes" : "No"));
        sb.append(String.format("%-25s: %s%n", "Purchase Date", purchaseDate));

        List<Medicine> meds = getPurchasedMeds();
        sb.append("---- Medicines ----\n");
        if (meds != null && !meds.isEmpty()) {
            for (Medicine med : meds) {
                sb.append(String.format("%-25s: %s (%s)%n", "Medicine Name", med.getMedicineName(), med.getCategory()));
                sb.append(String.format("%-25s: %s%n", "Price", med.getPrice()));
            }
        } else {
            sb.append("No medicines purchased.\n");
        }

        if (prescription != null) {
            sb.append("---- Prescription Details ----\n");
            sb.append(String.format("%-25s: %s%n", "Prescription Date", prescription.getPrescriptionDate()));
            sb.append(String.format("%-25s: %s %s%n", "Doctor", prescription.getTreatingDoctor().getName(), prescription.getTreatingDoctor().getLastName()));
            sb.append(String.format("%-25s: %s %s%n", "Patient", prescription.getPatient().getName(), prescription.getPatient().getLastName()));
        }

        sb.append("--------------------------------\n");
        return sb.toString();
    }
}
