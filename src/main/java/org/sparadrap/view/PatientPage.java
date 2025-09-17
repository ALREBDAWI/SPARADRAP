package org.sparadrap.view;

import org.sparadrap.controller.PatientController.PatientController;
import org.sparadrap.controller.PatientController.PatientModifyController;
import org.sparadrap.model.PatientModel.PatientsList;

import java.util.Scanner;

public class PatientPage {

    public static void patientDetails() {
        Scanner sc = new Scanner(System.in);
        boolean on = true;

        while (on) {

                System.out.println("\n" + ConsoleColors.CYAN_BOLD + "╔═══════════════════════════════════╗" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.YELLOW_BOLD + "          PATIENT MENU" + ConsoleColors.CYAN_BOLD + "            ║" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "╠═══════════════════════════════════╣" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.GREEN + "1. See All Patients               " + ConsoleColors.CYAN_BOLD + "║" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.GREEN + "2. View Patient Details           " + ConsoleColors.CYAN_BOLD + "║" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.GREEN + "3. Add New Patient                " + ConsoleColors.CYAN_BOLD + "║" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.GREEN + "4. Update Patient                 " + ConsoleColors.CYAN_BOLD + "║" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.GREEN + "5. Delete Patient                 " + ConsoleColors.CYAN_BOLD + "║" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "║ " + ConsoleColors.RED_BOLD + "0. Exit                           " + ConsoleColors.CYAN_BOLD + "║" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN_BOLD + "╚═══════════════════════════════════╝" + ConsoleColors.RESET);
                System.out.print(ConsoleColors.YELLOW_BOLD + ">>> Enter your choice: " + ConsoleColors.RESET);

            int choice = sc.nextInt();
            int id;
            switch (choice) {
                case 0:
                    on = false;
                    System.out.println("Exiting Patient Menu...");
                    break;
                case 1:
                    PatientsList.getPatientsFullNamesList();
                    break;
                case 2:
                    PatientsList.getPatientsFullNamesList();
                    System.out.println(">>> Enter Patient ID to view details: ");
                    id = sc.nextInt();
                    System.out.println(PatientsList.getPatientById(id));
                    break;
                case 3:
                    PatientController.patientController();
                    break;
                case 4:
                    PatientModifyController.patientModifyController();
                    break;
                case 5:
                    PatientsList.getPatientsFullNamesList();
                    System.out.println(">>> Enter Patient ID to delete: ");
                    id = sc.nextInt();
                    System.out.println(PatientsList.getPatientById(id));
                    PatientsList.removePatient(id);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
