package org.sparadrap.controller;

import org.sparadrap.model.InsuranceModel.Insurance;
import org.sparadrap.model.InsuranceModel.InsuranceCompaniesList;
import org.sparadrap.model.InsuranceModel.InsurancePlan;
import org.sparadrap.model.MedicineModel.Medicine;
import org.sparadrap.model.MedicineModel.MedicineList;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Controller for adding new insurance companies.
 * Prompts the user for company details and plans, then creates and stores a new {@link Insurance}.
 */
public class InsuranceCompanyController {

    /**
     * Prompts the user to enter details of an insurance company:
     * <ul>
     *     <li>Name, Postal Code, Phone Number, Email, Address, City, Department</li>
     *     <li>Select insurance plans (STANDARD, PREMIUM, ULTRA)</li>
     * </ul>
     * Creates a new {@link Insurance} object and adds it to {@link InsuranceCompaniesList}.
     */
    public static void insuranceCompanyController(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Company Name");
        String name = sc.nextLine();
        System.out.println("Enter Postal Code");
        String postalCode = sc.nextLine();
        System.out.println("Enter Phone Number");
        String phoneNumber = sc.nextLine();
        System.out.println("Enter Email");
        String email = sc.nextLine();
        System.out.println("Enter Address");
        String address = sc.nextLine();
        System.out.println("Enter City");
        String city = sc.nextLine();
        System.out.println("Enter Department");
        String department = sc.nextLine();

        System.out.println("how many insurance plans you want to add");
        int plansNumber = sc.nextInt();
        sc.nextLine();
        ArrayList<InsurancePlan> plans = new ArrayList<>();

        for(int i=0;i < plansNumber;i++){
            while (true){
                System.out.println((i+1) + " " + "choose between : STANDARD, PREMIUM, ULTRA ");
                String selectedPlan = sc.nextLine();
                try{
                    InsurancePlan plan = InsurancePlan.valueOf(selectedPlan);
                    if(!plans.contains(plan)){
                        plans.add(plan);
                        break;
                    }else {
                        System.out.println("this plan is already added !");
                    }
                } catch(IllegalArgumentException e){
                    System.out.println("Invalid plan type! Please enter STANDARD, PREMIUM, or ULTRA.");
                }
            }
        }

        Insurance insurance = new Insurance(name,address,postalCode,city,email,phoneNumber,department, plans);
        InsuranceCompaniesList.addInsurance(insurance);

    }
}
