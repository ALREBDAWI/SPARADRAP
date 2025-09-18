package org.sparadrap.controller;

import org.sparadrap.model.DoctorModel.Doctor;
import org.sparadrap.model.DoctorModel.DoctorsList;
import org.sparadrap.model.MedicineModel.Medicine;
import org.sparadrap.model.MedicineModel.MedicineList;
import org.sparadrap.model.PatientModel.Patient;
import org.sparadrap.model.PatientModel.PatientsList;
import org.sparadrap.model.PrescriptionModel.Prescription;
import org.sparadrap.model.PrescriptionModel.PrescriptionsList;
import org.sparadrap.view.MedsListDisplay;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Controller class for handling prescription creation.
 */
public class PrescriptionController {

    /**
     * Prompts the user to enter details for a new prescription:
     * <ul>
     *     <li>Select a doctor from the list</li>
     *     <li>Select a patient from the list</li>
     *     <li>Enter the prescription date</li>
     *     <li>Select medicines from the stock</li>
     * </ul>
     * Creates a {@link Prescription} object and adds it to {@link PrescriptionsList}.
     *
     * @return the created {@link Prescription}, or {@code null} if doctor or patient ID is invalid
     */
    public static Prescription enterNewPrescription(){

        Scanner sc = new Scanner(System.in);
        DoctorsList.getDoctorsFullNamesList();
        System.out.println("Enter doctor ID:");
        int doctorId = sc.nextInt();

        PatientsList.getPatientsFullNamesList();
        System.out.println("Enter  patient ID:");
        int patientId = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter prescription date (yyyy-MM-dd):");
        LocalDate prescriptionDate = LocalDate.parse(sc.nextLine());

        Doctor doctor = DoctorsList.getDoctorById(doctorId);
        if(doctor == null){
            System.out.println("Doctor not found or Invalid ID, try again");
            return  null;
        }

        Patient patient = PatientsList.getPatientById(patientId);
        if(patient == null){
            System.out.println("Patient not found or Invalid ID, try again");
            return  null;
        }

        // show all meds in stock with id
        MedsListDisplay.medsListDisplay();

        System.out.println("how many medicines are in this prescription?");
        int medicinesInPrescription = sc.nextInt();
        sc.nextLine();

        // prescription meds list
        ArrayList<Medicine> medicines = new ArrayList<>();

        for(int i=0;i < medicinesInPrescription;i++){
            System.out.println("enter the id of medicine number " + (i+1) + " :");
            int medicineId = sc.nextInt();
            Medicine selectedMed = MedicineList.getMedicineById(medicineId);
            medicines.add(selectedMed);
        }

        // create new prescription with input taken from user
        Prescription prescription = new Prescription(prescriptionDate, doctor, patient, medicines);
        System.out.println(prescription);

        // add to list
        PrescriptionsList.addPrescription(prescription);

        return prescription;
    }
}
