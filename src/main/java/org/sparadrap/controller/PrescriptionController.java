package org.sparadrap.controller;

import org.sparadrap.model.*;
import org.sparadrap.model.DummyData.DummyData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PrescriptionController {
    public static Prescription enterNewPrescription(){

        DummyData.dummyData();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter doctor full name:");
        String doctorName = sc.nextLine();
        System.out.println("Enter  patient full name:");
        String patientName = sc.nextLine();
        System.out.println("Enter prescription date (yyyy-MM-dd):");
        LocalDate prescriptionDate = LocalDate.parse(sc.nextLine());

        Patient patient =  null;
        for(Patient p : PatientsList.getPatientsList()){
            if(p != null && patientName.equalsIgnoreCase(p.getFullName())){
                patient = p;
            }
        }

        Doctor doctor = null;
        for(Doctor d : DoctorsList.getDoctorsList()){
            if(d != null && doctorName.equalsIgnoreCase(d.getFullName())){
                doctor = d;
            }
        }

        System.out.println("how many medicines in this prescription?");
        int medicinesInPrescription = sc.nextInt();
        sc.nextLine();
        ArrayList<Medicine> medicines = new ArrayList<>();

        for(int i=0;i < medicinesInPrescription;i++){
            System.out.println("enter medicine number " + (i+1) + " :");
            String medicineName = sc.nextLine();
            boolean found = false;
            for (Medicine m : MedicineList.getMedicineList()){
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
