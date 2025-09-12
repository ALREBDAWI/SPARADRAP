package org.sparadrap.view;

import org.sparadrap.model.Purchase;
import org.sparadrap.model.PurchaseList;

import java.util.Scanner;

public class PurchaseHistoryMenu {

    public static void purchaseHistoryMenu() {
        Scanner sc = new Scanner(System.in);
        boolean on = true;

        while (on) {
            System.out.println("\n===== Purchase History Menu =====");
            System.out.println("1. Show all purchases");
            System.out.println("2. View purchase details by ID");
            System.out.println("3. View purchase details by date");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Exiting Purchase History Menu...");
                    on = false;
                    break;
                case 1:
                    PrintPurchaseTable.printPurchaseTable(PurchaseList.getPurchaseList());
                    break;
                case 2:
                    System.out.print("Enter Purchase ID: ");
                    int purchaseId = sc.nextInt();
                    sc.nextLine();
                    Purchase purchase = PurchaseList.getPurchaseById(purchaseId);
                    if (purchase != null) {
                        System.out.println(purchase);
                    } else {
                        System.out.println("Purchase not found!");
                    }
                    break;
                case 3:
                    PurchaseFilterByDateMenu.menu();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
