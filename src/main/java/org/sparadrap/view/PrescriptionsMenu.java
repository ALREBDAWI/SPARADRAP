package org.sparadrap.view;

import org.sparadrap.controller.PrescriptionController;
import org.sparadrap.model.PrescriptionModel.Prescription;
import org.sparadrap.model.PrescriptionModel.PrescriptionsList;

import java.util.Scanner;

public class PrescriptionsMenu {

    public static void prescriptionsMenu() {
        Scanner sc = new Scanner(System.in);
        boolean on = true;
        while (on){
            System.out.println("\n" + ConsoleColors.CYAN_BOLD + "╔═══════════════════════════════════╗" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN_BOLD + "║        " + ConsoleColors.YELLOW_BOLD + "Prescriptions Menu" + ConsoleColors.CYAN_BOLD + "         ║" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN_BOLD + "╠═══════════════════════════════════╣" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.GREEN + "1. Add Prescription           " + ConsoleColors.CYAN_BOLD + "    ║" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.GREEN + "2. Delete Prescription        " + ConsoleColors.CYAN_BOLD + "    ║" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.GREEN + "3. View Prescription Details  " + ConsoleColors.CYAN_BOLD + "    ║" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.GREEN + "4. View Prescription List     " + ConsoleColors.CYAN_BOLD + "    ║" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.RED + "0. Back to Main Menu          " + ConsoleColors.CYAN_BOLD + "    ║" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN_BOLD + "╚═══════════════════════════════════╝" + ConsoleColors.RESET);
            System.out.print(ConsoleColors.YELLOW_BOLD + "👉 Enter choice: " + ConsoleColors.RESET);

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0:
                    on = false;
                    System.out.println("leaving prescriptions menu ...");
                    break;
                case 1:
                    PrescriptionController.enterNewPrescription();
                    break;
                case 2:
                    PrescriptionsView.displayPrescriptionsCompact(PrescriptionsList.getPrescriptions());
                    System.out.print("Enter prescription ID to delete: ");
                    int idToDelete = sc.nextInt();
                    Prescription prescriptionToDelete = PrescriptionsList.getPrescriptions().get(idToDelete);
                    if (prescriptionToDelete != null) {
                        PrescriptionsList.removePrescription(idToDelete);
                        System.out.println(ConsoleColors.GREEN + "Prescription deleted successfully." + ConsoleColors.RESET);
                    } else {
                        System.out.println(ConsoleColors.RED + "Prescription not found!" + ConsoleColors.RESET);
                    }
                    break;
                case 3:
                    PrescriptionsView.displayPrescriptionsCompact(PrescriptionsList.getPrescriptions());
                    System.out.print("Enter prescription ID to view details: ");
                    int idToView = sc.nextInt();
                    Prescription prescriptionDetails = PrescriptionsList.getPrescriptions().get(idToView);
                    if (prescriptionDetails != null) {
                        System.out.println(prescriptionDetails);
                    } else {
                        System.out.println(ConsoleColors.RED + "Prescription not found!" + ConsoleColors.RESET);
                    }
                    break;
                case 4:
                    PrescriptionsView.displayPrescriptionsCompact(PrescriptionsList.getPrescriptions());
                    break;
                default:
                    System.out.println(ConsoleColors.RED + "Invalid choice!" + ConsoleColors.RESET);
            }
        }

    }
}
