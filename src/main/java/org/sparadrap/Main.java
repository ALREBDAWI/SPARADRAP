package org.sparadrap;

import org.sparadrap.model.*;

import java.time.LocalDate;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Doctor
        Doctor doctor = new Doctor(
                "John",
                "123 Main St",
                "75001",
                "Paris",
                "john.smith@hospital.com",
                "0123456789",
                "Smith",
                "DR12345"
        );

        // Insurance (dummy)
        Insurance insurance = new Insurance(
                "AXA Insurance",
                "789 Avenue de la Republique",
                "75011",
                "Paris",
                "contact@axa.com",
                "0145789654",
                "Health",
                80
        );

        // Patient
        Patient patient = new Patient(
                "Alice",
                "456 Rue de Lyon",
                "69000",
                "Lyon",
                "alice.dupont@email.com",
                "0987654321",
                "SSN99887766",
                "Dupont",
                LocalDate.of(1990, 5, 20),
                doctor,
                insurance
        );

        // Medicines
        Medicine med1 = new Medicine(
                "Paracetamol",
                MedicineCategory.PAINKILLER,
                5,
                LocalDate.of(2023, 1, 10),
                2,
                false
        );

        Medicine med2 = new Medicine(
                "Amoxicillin",
                MedicineCategory.ANTIBIOTIC,
                12,
                LocalDate.of(2023, 2, 5),
                1,
                true
        );

        // ----  create prescription ------

        ArrayList<Medicine> medicines = new ArrayList<>();
        medicines.add(med1);
        medicines.add(med2);
        Prescription prescription = new Prescription(LocalDate.now(),doctor,patient,medicines);

        // ------ purchase --------

        Purchase purchase = new Purchase(true,prescription,LocalDate.now());

        med2.displayInfo();
        doctor.displayInfo();
        patient.displayInfo();
        insurance.displayInfo();
        prescription.displayInfo();
        purchase.displayInfo();

    }
}