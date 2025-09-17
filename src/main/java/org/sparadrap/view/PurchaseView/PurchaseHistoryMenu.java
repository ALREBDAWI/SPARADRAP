package org.sparadrap.view.PurchaseView;

import org.sparadrap.model.PurchaseModel.Purchase;
import org.sparadrap.model.PurchaseModel.PurchaseList;
import org.sparadrap.view.ConsoleColors;

import java.util.Scanner;

public class PurchaseHistoryMenu {

    public static void purchaseHistoryMenu() {
        Scanner sc = new Scanner(System.in);
        boolean on = true;

        while (on) {

                System.out.println("\n" + ConsoleColors.CYAN_BOLD + "╔══════════════════════════════════╗" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.YELLOW_BOLD + "     Purchase History Menu" + ConsoleColors.CYAN_BOLD + "       ║" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "╠══════════════════════════════════╣" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.GREEN + "1. Show All Purchases          " + ConsoleColors.CYAN_BOLD + "  ║" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.GREEN + "2. View Purchase Details By ID " + ConsoleColors.CYAN_BOLD + "  ║" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.GREEN + "3. View Purchase Details By Date" + ConsoleColors.CYAN_BOLD + " ║" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.RED + "0. Exit                        " + ConsoleColors.CYAN_BOLD + "  ║" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "╚══════════════════════════════════╝" + ConsoleColors.RESET);
                System.out.print(ConsoleColors.YELLOW_BOLD + "👉 Enter your choice: " + ConsoleColors.RESET);

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
