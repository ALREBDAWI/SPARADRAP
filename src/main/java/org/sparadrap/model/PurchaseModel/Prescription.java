package org.sparadrap.model.PurchaseModel;

import org.sparadrap.model.DoctorModel.Doctor;
import org.sparadrap.model.MedicineModel.Medicine;
import org.sparadrap.model.PatientModel.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prescription {
    private LocalDate prescriptionDate;
    private Doctor treatingDoctor;
    private Patient patient;
    private List<Medicine> medicineList;

    // --------- constructor --------

    public Prescription(LocalDate prescriptionDate, Doctor treatingDoctor, Patient patient, ArrayList<Medicine> MedicineList) {
        setPrescriptionDate(prescriptionDate);
        setTreatingDoctor(treatingDoctor);
        setPatient(patient);
        this.medicineList = new ArrayList<>(MedicineList);
    }

    // --------- getter and setter --------

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
    public List<Medicine> getMedicineList() {
        if(medicineList==null || medicineList.isEmpty()){
            throw  new IllegalArgumentException("Medicine List is Empty!");
        }
        return this.medicineList;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ---- Prescription Information ----\n");
        sb.append(String.format("%-25s: %s%n", "Date", prescriptionDate));
        sb.append(String.format("%-25s: %s%n", "Treating Doctor", treatingDoctor.getFullName()));
        sb.append(String.format("%-25s: %s%n", "Patient", patient.getFullName()));
        sb.append(String.format("%-25s: %s%n", "Medicine List", getMedicineList()));
        sb.append("--------------------------------\n");
        return sb.toString();
    }
}
