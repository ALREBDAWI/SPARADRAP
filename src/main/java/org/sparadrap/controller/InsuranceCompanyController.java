package org.sparadrap.controller;

import org.sparadrap.model.DummyData.DummyData;
import org.sparadrap.model.Insurance;
import org.sparadrap.model.InsuranceCompaniesList;

import java.util.Scanner;

public class InsuranceCompanyController {
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

        Insurance insurance = new Insurance(name,address,postalCode,city,email,phoneNumber,department);
        InsuranceCompaniesList.addInsurance(insurance);

    }

    public static void main(String[] args) {
        insuranceCompanyController();
        System.out.println(InsuranceCompaniesList.getInsuranceCompaniesList());

    }
}
