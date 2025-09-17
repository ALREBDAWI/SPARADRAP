package org.sparadrap.controller;

import org.sparadrap.model.DoctorModel.Doctor;
import org.sparadrap.model.DoctorModel.DoctorsList;
import org.sparadrap.model.MedicineModel.Medicine;
import org.sparadrap.model.MedicineModel.MedicineList;
import org.sparadrap.model.PatientModel.Patient;
import org.sparadrap.model.PatientModel.PatientsList;
import org.sparadrap.model.PurchaseModel.Prescription;
import org.sparadrap.model.PurchaseModel.PrescriptionsList;
import org.sparadrap.view.MedsListDisplay;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PrescriptionController {
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
        ArrayList<Medicine> medicines = new ArrayList<>();

        for(int i=0;i < medicinesInPrescription;i++){
            System.out.println("enter the id of medicine number " + (i+1) + " :");
            int medicineId = sc.nextInt();
            Medicine selectedMed = MedicineList.getMedicineById(medicineId);
            medicines.add(selectedMed);
        }

        Prescription prescription = new Prescription(prescriptionDate, doctor, patient, medicines);
        System.out.println(prescription);

        PrescriptionsList.addPrescription(prescription);

        return prescription;
    }
}
