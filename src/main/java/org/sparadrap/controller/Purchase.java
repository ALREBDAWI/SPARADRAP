package org.sparadrap.controller;

import org.sparadrap.model.DummyData.DummyData;
import org.sparadrap.model.Patient;
import org.sparadrap.model.Prescription;
import org.sparadrap.model.PrescriptionsList;

import java.util.Scanner;

public class Purchase {
    public void CreatePurchase(){
        DummyData.dummyData();
        Scanner sc = new Scanner(System.in);
        boolean withPrescription;
        int PrescriptionID;
        System.out.println("purchase with or without prescription? true / false");
        withPrescription = sc.nextBoolean();
        sc.nextLine();
        Patient myPatient = null;
        Prescription myPrescription = null;
        for(Prescription prescription : PrescriptionsList.getPrescriptions()){
            if (prescription != null){

            }
        }



    }
}
