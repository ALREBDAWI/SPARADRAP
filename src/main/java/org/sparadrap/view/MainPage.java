package org.sparadrap.view;

import org.sparadrap.model.*;

import java.util.InputMismatchException;
import java.util.Scanner;

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
            System.out.println(" 3 - Patients Page");
            System.out.println("-------------------------------------------------");
            System.out.println(" 0 - Exit");
            System.out.println("=================================================");
            System.out.print("--->>> Enter your choice: ");

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
