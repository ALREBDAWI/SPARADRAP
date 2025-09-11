package org.sparadrap.view;

import org.sparadrap.controller.DoctorDetailsController;
import org.sparadrap.controller.PatientDetailsController;
import org.sparadrap.controller.PurchaseController;
import org.sparadrap.model.*;
import org.sparadrap.model.DummyData.DummyData;

import java.util.Scanner;

import static org.sparadrap.controller.PatientModifyController.patientModifyController;

public class MainPage {
    public static void menu(){
        Scanner sc = new Scanner(System.in);
        boolean on = true;
        while (on) {
            System.out.println("\n=================================================");
            System.out.println("                   MAIN MENU                  ");
            System.out.println("=================================================");
            System.out.println(" 1 - New Purchase");
            System.out.println(" 2 - Purchase History");
            System.out.println(" 3 - Doctors Page");
            System.out.println(" 4 - Patients Page");
            System.out.println("-------------------------------------------------");
            System.out.println(" 0 - Exit");
            System.out.println("=================================================");
            System.out.print("--->>> Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice){
                case 0:
                    on = false;
                    break;
                case 1:
                    PurchaseMenu.PurchaseMenu();
                    break;
                case 2:
                    System.out.println(PurchaseList.getPurchaseList());
                    break;
                case 3:
                    System.out.println(PatientsList.getPatientsMap());
                    break;
                case 4:
                    PatientPage.patientDetails();
                    break;
                default:
                    System.out.println("Invalid choice, please try again!");
            }
        }
    }
}
