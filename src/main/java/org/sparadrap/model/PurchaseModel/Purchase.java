package org.sparadrap.model.PurchaseModel;

import org.sparadrap.model.MedicineModel.Medicine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Purchase {

    private final boolean isWithPrescription;
    private Prescription prescription;
    private LocalDate purchaseDate;
    private List<Medicine> purchasedMeds;

    // ----------------------------------
    // --------- constructors ----------
    // ----------------------------------

    // constructor for purchases with prescription
    public Purchase(Prescription prescription, LocalDate purchaseDate, List<Medicine> PurchasedMeds) {
        this.isWithPrescription = true ;
        setPrescription(prescription);
        setPurchaseDate(purchaseDate);
        setPurchasedMeds(PurchasedMeds);
    }

    // constructor without prescription
    public Purchase(LocalDate purchaseDate, List<Medicine> PurchasedMeds) {
        this.isWithPrescription = false;
        this.prescription = null;
        setPurchaseDate(purchaseDate);
        setPurchasedMeds(PurchasedMeds);
    }

    // =======================================
    // --------- getters and setters --------
    // =======================================

    public boolean getIsWithPrescription() {
        return this.isWithPrescription;
    }

    public Prescription getPrescription() {
        return this.prescription;
    }
    public void setPrescription(Prescription prescription) {
        if (prescription == null || !isWithPrescription) {
            throw  new IllegalArgumentException("Prescription must not be null");
        }
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
        return this.purchasedMeds;
    }

    public void setPurchasedMeds(List<Medicine> purchasedMeds) {
        if (purchasedMeds == null || purchasedMeds.isEmpty()) {
            throw  new IllegalArgumentException("Purchase medicine must not be null or empty");
        }
        this.purchasedMeds = new ArrayList<>(purchasedMeds);
    }


    public float getTotalPrice() {
            float total = 0;
        for (Medicine medicine : purchasedMeds) {
            total += medicine.getPrice();
        }
        return total;
    }

    public float getPriceAfterInsurance() {
        float totalAfterInsurance = 0;
        int percentage = prescription.getPatient().getPercentage();
        totalAfterInsurance = getTotalPrice() - (getTotalPrice() * percentage / 100f) ;
        return  totalAfterInsurance;
    }

    // ----------------------------------------------
    // -------- override and print all details -----
    // ----------------------------------------------

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---- Purchase Information ----\n");
        sb.append(String.format("%-25s: %s%n", "With Prescription", isWithPrescription ? "Yes" : "No"));
        sb.append(String.format("%-25s: %s%n", "Purchase Date", purchaseDate));
        sb.append(String.format("%-25s: %s%n", "total price", getTotalPrice()));

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
            sb.append(String.format("%-25s: %s%n", "total price after insurance", getPriceAfterInsurance() ));
        }

        sb.append("--------------------------------\n");
        return sb.toString();
    }
}
