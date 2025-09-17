package org.sparadrap.view.PurchaseView;

import org.sparadrap.model.PurchaseModel.Purchase;

import java.util.Map;

public class PrintPurchaseTable {
    public static void printPurchaseTable(Map<Integer, Purchase> purchases){
        System.out.println("----------------------------------------------------------");
        System.out.println("----------------------------------------------------------");
        System.out.printf("%-5s | %-25s | %-15s%n", "ID", "Patient Name", "Purchase Date");
        System.out.println("----------------------------------------------------------");

        for (Map.Entry<Integer, Purchase> entry : purchases.entrySet()) {
            int key = entry.getKey();
            Purchase purchase = entry.getValue();
            String patientName = "Not registered";
            if(purchase.getPrescription() != null && purchase.getPrescription().getPatient() != null){
                patientName = purchase.getPrescription().getPatient().getFullName();
            }
            System.out.printf("%-5d | %-25s | %-15s%n", key, patientName, purchase.getPurchaseDate());

        }

        System.out.println("----------------------------------------------------------");
        System.out.println("----------------------------------------------------------");
    }
}
