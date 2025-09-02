package org.sparadrap.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prescription {
    private LocalDate prescriptionDate;
    private Doctor treatingDoctor;
    private Patient patient;
    private final List<Medicine> MedicineList;

    // --------- constructor --------

    public Prescription(LocalDate prescriptionDate, Doctor treatingDoctor, Patient patient, ArrayList<Medicine> MedicineList) {
        setPrescriptionDate(prescriptionDate);
        setTreatingDoctor(treatingDoctor);
        setPatient(patient);
        this.MedicineList = List.copyOf(MedicineList);

    }

    // --------- getter and setter --------

    public LocalDate getPrescriptionDate() {
        return this.prescriptionDate;
    }
    public void setPrescriptionDate(LocalDate prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }
    public Doctor getTreatingDoctor() {
        return this.treatingDoctor;
    }
    public void setTreatingDoctor(Doctor treatingDoctor) {
        this.treatingDoctor = treatingDoctor;
    }
    public Patient getPatient() {
        return this.patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Medicine> getMedicineList() {
        return this.MedicineList;
    }



    public void displayInfo() {
        System.out.println("---- Prescription Information ----");
        System.out.printf("%-25s: %d%n", "Date", prescriptionDate);
        System.out.printf("%-25s: %d%n", "Treating Doctor", treatingDoctor);
        System.out.printf("%-25s: %s%n", "Patient", getPatient().getName() + " " + getPatient().getLastName());
        System.out.printf("%-25s: %s%n", "Medicine List", getMedicineList().toString());
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {
    }
}
