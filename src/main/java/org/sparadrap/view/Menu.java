package org.sparadrap.view;

import org.sparadrap.controller.PurchaseController;
import org.sparadrap.model.*;
import org.sparadrap.model.DummyData.DummyData;

import java.util.Scanner;

import static org.sparadrap.controller.PatientModifyController.patientModifyController;

public class Menu {
    public static void menu(){
        Scanner sc = new Scanner(System.in);
        boolean on = true;
        while (on) {
            System.out.println(
              "1. Create Purchase"
            + "\n2. Doctors List"
            + "\n3. Patients List"
            + "\n4. Medicine List"
            + "\n5. Insurance List"
            + "\n6. Purchase list"
            + "\n7. Modify patient");
            int choice = sc.nextInt();
            switch (choice){
                case 0:
                    on = false;
                    break;
                case 1:
                    PurchaseController.CreatePurchase();
                    break;
                case 2:
                    System.out.println(DoctorsList.getDoctorsMap());
                    break;
                case 3:
                    System.out.println(PatientsList.getPatientsMap());
                    break;
                case 4:
                    System.out.println(MedicineList.getMedicineStockList());
                    break;
                case 5:
                    System.out.println(InsuranceCompaniesList.getInsuranceCompaniesList());
                    break;
                case 6:
                    System.out.println(PurchaseList.getPurchaseList());
                    break;
                case 7:
                    patientModifyController();
                    break;
                case 8:
                    System.out.println(PatientsList.getPatientsFullNamesList());
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }
}
