package org.sparadrap.view;

import org.sparadrap.controller.PrescriptionController;
import org.sparadrap.controller.PurchaseController;
import org.sparadrap.model.PurchaseList;

import java.util.Scanner;

public class PurchaseMenu {
    public static void PurchaseMenu() {
        Scanner sc = new Scanner(System.in);
        boolean on = true;

        while (on) {
            System.out.println("\n===== Purchase Menu =====");
            System.out.println("1. Create Purchase");
            System.out.println("2. Enter New Prescription");
            System.out.println("3. Show Purchase History");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice){
                case 0:
                    on = false;
                    break;
                case 1:
                    PurchaseController.CreatePurchase();
                    break;
                case 2:
                    PrescriptionController.enterNewPrescription();
                    break;
                case 3:  PurchaseList.getPurchaseList();
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}
