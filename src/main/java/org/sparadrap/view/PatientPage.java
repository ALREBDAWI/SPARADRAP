package org.sparadrap.view;

import org.sparadrap.controller.PatientController;
import org.sparadrap.controller.PatientDetailsController;
import org.sparadrap.controller.PatientModifyController;
import org.sparadrap.model.PatientsList;

import java.util.Scanner;

public class PatientPage {

    public static void patientDetails() {
        Scanner sc = new Scanner(System.in);
        boolean on = true;

        while (on) {

            System.out.println("\n===========================================");
            System.out.println("               ️ PATIENT MENU              ");
            System.out.println("===========================================");
            System.out.println(" 0. Exit");
            System.out.println(" 1. See All Patients");
            System.out.println(" 2. View Patient Details");
            System.out.println(" 3. Add New Patient");
            System.out.println(" 4. Update Patient");
            System.out.println(" 5. Delete Patient");
            System.out.println("===========================================");
            System.out.print(">>> Enter your choice: ");

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
