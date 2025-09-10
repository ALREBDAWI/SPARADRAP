package org.sparadrap.controller;

import org.sparadrap.model.*;
import org.sparadrap.model.DummyData.DummyData;

import java.time.LocalDate;
import java.util.*;

public class PurchaseController {

    public static void CreatePurchase(){
        DummyData.dummyData();
        Scanner sc = new Scanner(System.in);
        LocalDate purchaseDate =  LocalDate.now();
        List<Medicine> purchasedMeds = new ArrayList<>();
        System.out.println("1 with Prescription");
        System.out.println("2 without Prescription");
        int choice = sc.nextInt();
        switch (choice){
            case 1:

                int prescriptionId;
                System.out.println("Enter prescription ID");
                prescriptionId = sc.nextInt();
                Prescription prescription = PrescriptionsList.getPrescriptions().get(prescriptionId);
                purchasedMeds = prescription.getMedicineList();
                Purchase purchaseWithPrescription = new Purchase(true, prescription, purchaseDate, purchasedMeds);
                //--------------------------------------add it to list
                PurchaseList.addPurchaseToList(purchaseWithPrescription);
                System.out.println(purchaseWithPrescription);
                break;

            case 2:

                int medicineQuantity;
                System.out.println("how many units of medicine do you want?");
                medicineQuantity = sc.nextInt();
                String medicineName;
                sc.nextLine();
                for(int i = 0; i < medicineQuantity; i++){
                    System.out.println("Enter medicine name");
                    medicineName = sc.nextLine();
                    for (Medicine m : MedicineList.getMedicineList()) {
                        if(m.getMedicineName().equalsIgnoreCase(medicineName) && !m.isWithPrescription()){

                            System.out.println("Enter " + medicineName + " quantity");
                            int quantity = sc.nextInt();
                            if(quantity < m.getQuantity()){
                                purchasedMeds.add(m);
                                m.setQuantity(m.getQuantity() - quantity);
                            }else {
                                System.out.println("not enough medicine in stock, try again with smaller quantity" + m.getMedicineName());
                            }
                            break;
                        }
                    }
                }
                System.out.println("purchased meds : " + purchasedMeds);
                Purchase purchase = new Purchase(false, purchaseDate,purchasedMeds);
                //----------------- add to list
                PurchaseList.addPurchaseToList(purchase);
                System.out.println(purchase);
                System.out.println(PurchaseList.getPurchaseList());

        }

    }
}

