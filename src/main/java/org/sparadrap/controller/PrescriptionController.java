package org.sparadrap.controller;

import org.sparadrap.model.*;
import org.sparadrap.model.DummyData.DummyData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PrescriptionController {
    public static Prescription enterNewPrescription(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter doctor ID:");
        int doctorId = sc.nextInt();
        System.out.println("Enter  patient ID:");
        int patientId = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter prescription date (yyyy-MM-dd):");
        LocalDate prescriptionDate = LocalDate.parse(sc.nextLine());

        Doctor doctor = DoctorsList.getDoctorById(doctorId);

        Patient patient = PatientsList.getPatientById(patientId);

        if(doctor == null){
            System.out.println("Doctor not found or Invalid ID, try again");
            return  null;
        }
        if(patient == null){
            System.out.println("Patient not found or Invalid ID, try again");
            return  null;
        }

        System.out.println("how many medicines are in this prescription?");
        int medicinesInPrescription = sc.nextInt();
        sc.nextLine();
        ArrayList<Medicine> medicines = new ArrayList<>();

        for(int i=0;i < medicinesInPrescription;i++){
            System.out.println("enter medicine number " + (i+1) + " :");
            String medicineName = sc.nextLine();
            boolean found = false;
            for (Medicine m : MedicineList.getMedicineStockList()){
                if(m.getMedicineName().equalsIgnoreCase(medicineName)){
                    medicines.add(m);
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("medicine not found");
            }
        }


        Prescription prescription = new Prescription(prescriptionDate,doctor,patient,medicines);
        System.out.println(prescription);
        return prescription;
    }

    public static void main(String[] args) {
        PrescriptionController.enterNewPrescription();
    }
}
