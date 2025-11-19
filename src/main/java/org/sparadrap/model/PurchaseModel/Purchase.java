package org.sparadrap.model.PurchaseModel;

import org.sparadrap.model.MedicineModel.Medicine;
import org.sparadrap.model.PrescriptionModel.Prescription;
import org.sparadrap.view.ConsoleColors;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a purchase of medicines.
 * Can be associated with a prescription or be a direct purchase without one.
 */
public class Purchase {

    private int id;
    private final boolean isWithPrescription;
    private Prescription prescription;
    private LocalDate purchaseDate;
    private List<Medicine> purchasedMeds;

    // ----------------------------------
    // --------- constructors ----------
    // ----------------------------------

    /**
     * Creates a purchase with a prescription.
     *
     * @param prescription Prescription object (cannot be null)
     * @param purchaseDate Date of purchase (cannot be in the future)
     * @param purchasedMeds List of medicines (cannot be null or empty)
     */
    public Purchase(Prescription prescription, LocalDate purchaseDate, List<Medicine> purchasedMeds) {
        this.isWithPrescription = true ;
        setPrescription(prescription);
        setPurchaseDate(purchaseDate);
        setPurchasedMeds(purchasedMeds);
    }

    /**
     * Creates a purchase without a prescription.
     *
     * @param purchaseDate Date of purchase (cannot be in the future)
     * @param purchasedMeds List of medicines (cannot be null or empty)
     */
    public Purchase(LocalDate purchaseDate, List<Medicine> purchasedMeds) {
        this.isWithPrescription = false;
        this.prescription = null;
        setPurchaseDate(purchaseDate);
        setPurchasedMeds(purchasedMeds);
    }

    // =======================================
    // --------- getters and setters --------
    // =======================================

    public int getId() {
        return this.id;
    }

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

    // ----------------- Price Calculations -----------------

    /**
     * Calculates the total price of all purchased medicines.
     *
     * @return Total price
     */
    public float getTotalPrice() {
            float total = 0;
        for (Medicine medicine : purchasedMeds) {
            total += medicine.getPrice();
        }
        return total;
    }

    /**
     * Calculates the price after applying patient's insurance coverage.
     *
     * @return Price after insurance deduction
     * @throws IllegalStateException if purchase is not linked to a prescription
     */
    public float getPriceAfterInsurance() {
        float totalAfterInsurance = 0;
        int percentage = prescription.getPatient().getPercentage();
        totalAfterInsurance = getTotalPrice() - (getTotalPrice() * percentage / 100f) ;
        return  totalAfterInsurance;
    }

    // ----------------------------------------------
    // ---------------- Display Info ----------------
    // ----------------------------------------------

    /**
     * Returns a formatted string containing all purchase details.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // ==== Purchase Summary ====
        sb.append(ConsoleColors.CYAN_BOLD).append("=== Purchase Summary ===").append(ConsoleColors.RESET).append("\n");
        sb.append(String.format("%-25s: %s%n", "With Prescription", isWithPrescription ? ConsoleColors.GREEN + "Yes" + ConsoleColors.RESET : ConsoleColors.RED + "No" + ConsoleColors.RESET));
        sb.append(String.format("%-25s: %s%n", "Purchase Date", purchaseDate));
        sb.append(String.format("%-25s: %.2f%n", "Total Price", getTotalPrice()));

        // ==== Medicines List ====
        sb.append(ConsoleColors.YELLOW_BOLD).append("---- Medicines ----").append(ConsoleColors.RESET).append("\n");
        if (getPurchasedMeds() != null && !getPurchasedMeds().isEmpty()) {
            for (Medicine med : getPurchasedMeds()) {
                sb.append(String.format("  • %s (%s) | %.2f | Rx: %s%n",
                        ConsoleColors.BLUE_BOLD + med.getMedicineName() + ConsoleColors.RESET,
                        med.getCategory(),
                        med.getPrice(),
                        med.isWithPrescription() ? "Yes" : "No"));
            }
        } else {
            sb.append("  No medicines purchased.\n");
        }

        // ==== Prescription Details (if any) ====
        if (prescription != null) {
            sb.append(ConsoleColors.PURPLE_BOLD).append("---- Prescription ----").append(ConsoleColors.RESET).append("\n");
            sb.append(String.format("  Date       : %s%n", prescription.getPrescriptionDate()));
            sb.append(String.format("  Doctor     : %s %s%n", prescription.getTreatingDoctor().getName(), prescription.getTreatingDoctor().getLastName()));
            sb.append(String.format("  Patient    : %s %s%n", prescription.getPatient().getName(), prescription.getPatient().getLastName()));
            sb.append(String.format("  Price after insurance: %.2f%n", getPriceAfterInsurance()));
        }

        sb.append(ConsoleColors.CYAN_BOLD).append("-----------------------------").append(ConsoleColors.RESET).append("\n");
        return sb.toString();
    }

}
