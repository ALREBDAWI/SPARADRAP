package org.sparadrap.view.PurchaseView;

import org.sparadrap.controller.PrescriptionController;
import org.sparadrap.controller.PurchaseController.PurchaseController;
import org.sparadrap.model.PurchaseModel.PurchaseList;
import org.sparadrap.view.ConsoleColors;

import java.util.Scanner;

public class PurchaseMenu {
    public static void PurchaseMenu() {
        Scanner sc = new Scanner(System.in);
        boolean on = true;

        while (on) {

                System.out.println("\n" + ConsoleColors.CYAN_BOLD + "╔═════════════════════════════╗" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "║        " + ConsoleColors.YELLOW_BOLD + "Purchase Menu" + ConsoleColors.CYAN_BOLD + "        ║" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "╠═════════════════════════════╣" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.GREEN + "1. Create Purchase        " + ConsoleColors.CYAN_BOLD + "  ║" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.GREEN + "2. Enter New Prescription " + ConsoleColors.CYAN_BOLD + "  ║" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.RED + "0. Go Back To Main Menu   " + ConsoleColors.CYAN_BOLD + "  ║" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "╚═════════════════════════════╝" + ConsoleColors.RESET);
                System.out.print(ConsoleColors.YELLOW_BOLD + "👉 Enter choice: " + ConsoleColors.RESET);

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
                default:
                    System.out.println("Invalid choice, try a number between 0 and 2 !");
            }
        }
    }
}
