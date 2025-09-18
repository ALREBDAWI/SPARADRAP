package org.sparadrap.model.PrescriptionModel;

import org.sparadrap.model.DoctorModel.Doctor;
import org.sparadrap.model.MedicineModel.Medicine;
import org.sparadrap.model.PatientModel.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a medical prescription.
 * Contains prescription date, treating doctor, patient, and a list of medicines.
 */
public class Prescription {

    /** Date when the prescription was issued (cannot be in the future) */
    private LocalDate prescriptionDate;

    /** Doctor who issued the prescription */
    private Doctor treatingDoctor;

    /** Patient receiving the prescription */
    private Patient patient;

    /** List of medicines included in the prescription */
    private List<Medicine> medicineList;

    // ------------ constructor ------------

    /**
     * Creates a new Prescription object with the specified attributes.
     *
     * @param prescriptionDate Date of the prescription (cannot be in the future)
     * @param treatingDoctor Doctor who issued the prescription (cannot be null)
     * @param patient Patient receiving the prescription (cannot be null)
     * @param medicineList List of medicines included (cannot be empty)
     * @throws IllegalArgumentException if any validation fails
     */
    public Prescription(LocalDate prescriptionDate, Doctor treatingDoctor, Patient patient, ArrayList<Medicine> medicineList) {
        setPrescriptionDate(prescriptionDate);
        setTreatingDoctor(treatingDoctor);
        setPatient(patient);
        this.medicineList = new ArrayList<>(medicineList);
    }

    // --------- Getters and Setters --------

    public LocalDate getPrescriptionDate() {
        return this.prescriptionDate;
    }
    public void setPrescriptionDate(LocalDate prescriptionDate) {
        if (prescriptionDate == null || prescriptionDate.isAfter(LocalDate.now())) {
            throw  new IllegalArgumentException("Prescription Date Is Null Or Invalid!");
        }
        this.prescriptionDate = prescriptionDate;
    }
    public Doctor getTreatingDoctor() {
        return this.treatingDoctor;
    }
    public void setTreatingDoctor(Doctor treatingDoctor) {
        if (treatingDoctor == null) {
            throw  new IllegalArgumentException("Treating Doctor Null!");
        }
        this.treatingDoctor = treatingDoctor;
    }
    public Patient getPatient() {
        return this.patient;
    }
    public void setPatient(Patient patient) {
        if (patient == null) {
            throw  new IllegalArgumentException("Patient Invalid!");
        }
        this.patient = patient;
    }

    /**
     * Returns the list of medicines in the prescription.
     *
     * @return List of Medicine objects
     * @throws IllegalArgumentException if the list is empty
     */
    public List<Medicine> getMedicineList() {
        if(medicineList==null || medicineList.isEmpty()){
            throw  new IllegalArgumentException("Medicine List is Empty!");
        }
        return this.medicineList;
    }

    /**
     * Returns a formatted string containing all prescription information.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ---- Prescription Information ----\n");
        sb.append(String.format("%-25s: %s%n", "Date", prescriptionDate));
        sb.append(String.format("%-25s: %s%n", "Treating Doctor", treatingDoctor.getFullName()));
        sb.append(String.format("%-25s: %s%n", "Patient", patient.getFullName()));
        sb.append(String.format("%-25s: %s%n", "Coverage percentage", patient.getPercentage()));
        sb.append(String.format("%-25s: %s%n", "Medicine List", getMedicineList()));
        sb.append("--------------------------------\n");
        return sb.toString();
    }
}
