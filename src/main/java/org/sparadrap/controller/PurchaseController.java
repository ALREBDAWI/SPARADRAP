package org.sparadrap.controller;

import org.sparadrap.model.*;
import org.sparadrap.view.MedsListDisplay;

import java.time.LocalDate;
import java.util.*;

public class PurchaseController {

    public static void CreatePurchase(){
        Scanner sc = new Scanner(System.in);
        LocalDate purchaseDate =  LocalDate.now();
        List<Medicine> purchasedMeds = new ArrayList<>();

        // user can choose between twe ways of purchase
        System.out.println("1 with Prescription");
        System.out.println("2 without Prescription");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice){

            case 1: // purchase with prescription
                System.out.println("Enter prescription ID:");
                int prescriptionId = sc.nextInt();
                sc.nextLine();

                // get prescription from the list using ID
                Prescription prescription = PrescriptionsList.getPrescriptions().get(prescriptionId);
                if (prescription == null) {
                    System.out.println("Prescription not found!");
                    return; // stop execution
                }

                purchasedMeds = prescription.getMedicineList();
                Purchase purchaseWithPrescription = new Purchase(prescription, purchaseDate, purchasedMeds);
                PurchaseList.addPurchaseToList(purchaseWithPrescription);
                System.out.println(purchaseWithPrescription);
                break;

            case 2: // without prescription

                // Map shows all medicines in stock with ID
                MedsListDisplay.medsListDisplay();

                System.out.println("How many different medicines do you want?");
                int totalMedicineQuantity = sc.nextInt();
                sc.nextLine();

                for(int i = 0; i < totalMedicineQuantity; i++){

                    // get medicine ID from user
                    System.out.println("Enter medicine ID:");
                    int medId = sc.nextInt();
                    sc.nextLine();

                    // Go to medicines list and find the medicine by its ID
                    Medicine selectedMed = MedicineList.getMedicineStockList().get(medId);

                    // redo
                    if (selectedMed == null) {
                        System.out.println("Medicine ID not found, try again.");
                        i--;
                        continue;
                    }

                    // we do not allow buying certain meds without prescription
                    if (selectedMed.isWithPrescription()) {
                        System.out.println("This medicine requires a prescription. Choose another.");
                        i--; //step back
                        continue;
                    }

                    System.out.println("enter " + selectedMed.getMedicineName() + " quantity:");
                    int selectedMedQuantity = sc.nextInt();
                    if(selectedMedQuantity <= selectedMed.getQuantity()){
                        for (int j = 0; j < selectedMedQuantity; j++) {
                            purchasedMeds.add(selectedMed);
                        }
                        selectedMed.setQuantity(selectedMed.getQuantity() - selectedMedQuantity);
                    } else {
                        System.out.println("Not enough stock available: " + selectedMed.getQuantity());
                        i--;
                    }
                }

                Purchase purchase = new Purchase(purchaseDate, purchasedMeds);
                PurchaseList.addPurchaseToList(purchase);
                System.out.println(purchase);
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }
}
