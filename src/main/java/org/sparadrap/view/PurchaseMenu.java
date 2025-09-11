package org.sparadrap.view;

import org.sparadrap.controller.PrescriptionController;
import org.sparadrap.controller.PurchaseController;

import java.util.Scanner;

public class PurchaseMenu {
    public static void PurchaseMenu() {
        Scanner sc = new Scanner(System.in);
        boolean on = true;
        System.out.println("Enter choice : 0 to exit, 1 to purchase, 2 to enter new prescription");
        int choice = sc.nextInt();
        while (on) {
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
            }
        }

    }
}
