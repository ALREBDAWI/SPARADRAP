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


    // display info

    public void displayInfo() {
        System.out.println("---- Prescription Information ----");
        System.out.printf("%-25s: %s%n", "Date", prescriptionDate);
        System.out.printf("%-25s: %s%n", "Treating Doctor", treatingDoctor.getName());
        System.out.printf("%-25s: %s%n", "Patient", patient.getName());
        System.out.printf("%-25s: %s%n", "Medicine List", getMedicineList());
        System.out.println("--------------------------------");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---- Prescription Information ----\n");
        sb.append(String.format("%-25s: %s%n", "Date", prescriptionDate));
        sb.append(String.format("%-25s: %s%n", "Treating Doctor", treatingDoctor.getFullName()));
        sb.append(String.format("%-25s: %s%n", "Patient", patient.getFullName()));
        sb.append(String.format("%-25s: %s%n", "Medicine List", getMedicineList()));
        sb.append("--------------------------------\n");
        return sb.toString();
    }
}
