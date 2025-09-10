package org.sparadrap.view;

import org.sparadrap.controller.PurchaseController;
import org.sparadrap.model.*;
import org.sparadrap.model.DummyData.DummyData;

import java.util.Scanner;

public class Menu {
    public static void menu(){
        DummyData.dummyData();
        Scanner sc = new Scanner(System.in);
        boolean on = true;
        while (on) {
            System.out.println("1. Create Purchase"
            + "\n2. Doctors List"
            + "\n3. Patients List"
            + "\n4. Medicine List"
            + "\n5. Insurance List"
            + "\n6. Purchase list");
            int choice = sc.nextInt();
            switch (choice){
                case 0:
                    on = false;
                    break;
                case 1:
                    PurchaseController.CreatePurchase();
                    break;
                case 2:
                    System.out.println(DoctorsList.getDoctorsList());
                    break;
                case 3:
                    System.out.println(PatientsList.getPatientsList());
                    break;
                case 4:
                    System.out.println(MedicineList.getMedicineList());
                    break;
                case 5:
                    System.out.println(InsuranceCompaniesList.getInsuranceCompaniesList());
                    break;
                case 6:
                    System.out.println(PurchaseList.getPurchaseList());
                default:
                    System.out.println("Wrong choice");
            }
        }
    }
}
