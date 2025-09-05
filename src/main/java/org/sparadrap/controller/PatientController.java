package org.sparadrap.controller;

import org.sparadrap.model.*;
import org.sparadrap.model.DummyData.DummyData;

import java.time.LocalDate;
import java.util.Scanner;

public class PatientController {
    public static Patient patientController(){

        DummyData.dummyData();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Patient Social Security Number");
        String socialSecurityNumber = sc.nextLine();
        System.out.println("Enter Patient First Name");
        String firstName = sc.nextLine();
        System.out.println("Enter Patient Last Name");
        String lastName = sc.nextLine();
        System.out.println("Enter Patient Postal Code");
        String postalCode = sc.nextLine();
        System.out.println("Enter Patient Phone Number");
        String phoneNumber = sc.nextLine();
        System.out.println("Enter Patient Email");
        String email = sc.nextLine();
        System.out.println("Enter Patient Address");
        String address = sc.nextLine();
        System.out.println("Enter Patient City");
        String city = sc.nextLine();
        System.out.println("Enter Patient date of birth");
        LocalDate dateOfBirth = LocalDate.parse(sc.nextLine());
        System.out.println("Enter Patient treating doctor full name");
        String treatingDoctorFullName = sc.nextLine();
        System.out.println("Enter Insurance company name:");
        String insuranceCompanyName = sc.nextLine();
        System.out.println("Enter Insurance Coverage Percentage:");
        int insuranceCoveragePercentage = sc.nextInt();

        Doctor treatingDoctor = null;
        for(Doctor d : DoctorsList.getDoctorsList()){
            if(d.getFullName().equalsIgnoreCase(treatingDoctorFullName)){
                treatingDoctor = d;
            }
        }

        Insurance insurance = null;
        for (Insurance i : InsuranceCompaniesList.getInsuranceCompaniesList()){
            if(i.getName().equalsIgnoreCase(insuranceCompanyName)){
                insurance = i;
            }
        }

        Patient patient = new Patient(firstName,address,postalCode,city,email,phoneNumber,socialSecurityNumber,lastName,dateOfBirth,treatingDoctor,insurance, insuranceCoveragePercentage);
        PatientsList.addPatient(patient);
        System.out.println(PatientsList.getPatientsList());
        return patient;
    }

    public static void main(String[] args) {
        PatientController.patientController();
    }
}
