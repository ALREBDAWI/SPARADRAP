package org.sparadrap.view;

import org.sparadrap.controller.PurchaseHistoryFilterController;

import java.util.Scanner;

public class PurchaseFilterByDateMenu {
    public static void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Show today's purchases");
        System.out.println("2. Show last week's purchases");
        System.out.println("3. show purchase between two dates");
        System.out.println("0. Exit");

        boolean on = true;
                while (on){
                    System.out.print("Enter your choice: ");
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 0:
                            on = false;
                            break;
                        case 1:
                            PrintPurchaseTable.printPurchaseTable(PurchaseHistoryFilterController.toDayFilter());
                            break;
                        case 2:
                            PrintPurchaseTable.printPurchaseTable(PurchaseHistoryFilterController.lastWeekFilter());
                            break;
                        case 3:
                            PrintPurchaseTable.printPurchaseTable(PurchaseHistoryFilterController.betweenTwoDatesFilter());
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                }
    }
}
