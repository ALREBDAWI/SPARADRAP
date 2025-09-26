package org.sparadrap.view;

import org.sparadrap.view.PurchaseView.PurchaseHistoryMenu;
import org.sparadrap.view.PurchaseView.PurchaseMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainPage {
    public static void menu(){
        Scanner sc = new Scanner(System.in);
        boolean on = true;
        while (on) {

                System.out.println("\n" + ConsoleColors.BLUE_BOLD + "╔════════════════════════════════════╗" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.BLUE_BOLD + "║         " + ConsoleColors.YELLOW_BOLD + "✦ MAIN MENU ✦" + ConsoleColors.BLUE_BOLD + "             ║" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.BLUE_BOLD + "╠════════════════════════════════════╣" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.BLUE_BOLD + "║ " + ConsoleColors.CYAN_BOLD + "1. New Purchase              " + ConsoleColors.BLUE_BOLD + "      ║" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.BLUE_BOLD + "║ " + ConsoleColors.CYAN_BOLD + "2. Purchase History          " + ConsoleColors.BLUE_BOLD + "      ║" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.BLUE_BOLD + "║ " + ConsoleColors.CYAN_BOLD + "3. Patients Menu             " + ConsoleColors.BLUE_BOLD + "      ║" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.BLUE_BOLD + "║ " + ConsoleColors.CYAN_BOLD + "4. Prescriptions Menu             " + ConsoleColors.BLUE_BOLD + " ║" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE_BOLD + "╠════════════════════════════════════╣" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.BLUE_BOLD + "║ " + ConsoleColors.RED_BOLD + "0. Exit Program              " + ConsoleColors.BLUE_BOLD + "      ║" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.BLUE_BOLD + "╚════════════════════════════════════╝" + ConsoleColors.RESET);
                System.out.print(ConsoleColors.YELLOW_BOLD + "👉 Enter choice: " + ConsoleColors.RESET);

            try {
                int choice = sc.nextInt();
                switch (choice){
                    case 0:
                        on = false;
                        break;
                    case 1:
                        PurchaseMenu.PurchaseMenu();
                        break;
                    case 2:
                        PurchaseHistoryMenu.purchaseHistoryMenu();
                        break;
                    case 3:
                        PatientPage.patientDetails();
                        break;
                    case 4:
                        PrescriptionsMenu.prescriptionsMenu();
                        break;
                    default:
                        System.out.println("Invalid choice, please inter a number between 0 and 3 !");
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid choice, please inter a number!");
                sc.nextLine();
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }
    }
}
