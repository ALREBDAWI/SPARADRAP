package org.sparadrap.controller;

import org.sparadrap.model.*;
import java.time.LocalDate;
import java.util.*;

public class PurchaseController {

    public static void CreatePurchase(){
        Scanner sc = new Scanner(System.in);
        LocalDate purchaseDate =  LocalDate.now();
        List<Medicine> purchasedMeds = new ArrayList<>();
        System.out.println("1 with Prescription");
        System.out.println("2 without Prescription");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice){

            case 1:
                System.out.println("Enter prescription ID:");
                int prescriptionId = sc.nextInt();
                sc.nextLine();
                Prescription prescription = PrescriptionsList.getPrescriptions().get(prescriptionId);
                if (prescription == null) {
                    System.out.println("Prescription not found!");
                    return;
                }
                purchasedMeds = prescription.getMedicineList();
                Purchase purchaseWithPrescription = new Purchase(true, prescription, purchaseDate, purchasedMeds);
                PurchaseList.addPurchaseToList(purchaseWithPrescription);
                System.out.println(purchaseWithPrescription);
                break;

            case 2:
                System.out.println("How many different medicines do you want?");
                int medicineQuantity = sc.nextInt();
                sc.nextLine();

                for(int i = 0; i < medicineQuantity; i++){
                    System.out.println("\nAvailable Medicines:");
                    System.out.println("-----------------------------");
                    System.out.printf("%-5s | %-25s | %-10s%n", "ID", "Medicine Name", "Stock Qty");
                    for (Map.Entry<Integer, Medicine> entry : MedicineList.getMedicineStockList().entrySet()) {
                        Medicine m = entry.getValue();
                        System.out.printf("%-5d | %-25s | %-10d%n", entry.getKey(), m.getMedicineName(), m.getQuantity());
                    }
                    System.out.println("-----------------------------");

                    System.out.println("Enter medicine ID:");
                    int medId = sc.nextInt();
                    sc.nextLine();
                    Medicine selectedMed = MedicineList.getMedicineStockList().get(medId);

                    if (selectedMed == null) {
                        System.out.println("Medicine ID not found, try again.");
                        i--; // redo
                        continue;
                    }

                    if (selectedMed.isWithPrescription()) {
                        System.out.println("This medicine requires a prescription. Choose another.");
                        i--;
                        continue;
                    }

                    System.out.println("Enter quantity for " + selectedMed.getMedicineName() + ":");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    if(quantity <= selectedMed.getQuantity()){
                        purchasedMeds.add(selectedMed);
                        selectedMed.setQuantity(selectedMed.getQuantity() - quantity);
                    } else {
                        System.out.println("Not enough stock. Available: " + selectedMed.getQuantity());
                        i--;
                    }
                }

                Purchase purchase = new Purchase(false, purchaseDate, purchasedMeds);
                PurchaseList.addPurchaseToList(purchase);
                System.out.println(purchase);
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }
}
