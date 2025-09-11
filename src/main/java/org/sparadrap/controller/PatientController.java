package org.sparadrap.controller;

import org.sparadrap.model.*;
import org.sparadrap.model.DummyData.DummyData;

import java.time.LocalDate;
import java.util.Scanner;

public class PatientController {
    public static Patient patientController(){

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
        System.out.println("Enter Patient treating doctor ID");
        int doctorId = sc.nextInt();
        System.out.println("Enter Insurance company ID:");
        int companyId = sc.nextInt();
        System.out.println("Enter Insurance Coverage Percentage:");
        int insuranceCoveragePercentage = sc.nextInt();

        Doctor treatingDoctor = DoctorsList.getDoctorById(doctorId);

        Insurance insurance = InsuranceCompaniesList.getInsuranceById(companyId);

        Patient patient = new Patient(firstName,address,postalCode,city,email,phoneNumber,socialSecurityNumber,lastName,dateOfBirth,treatingDoctor,insurance, insuranceCoveragePercentage);
        PatientsList.addPatient(patient);
        System.out.println(PatientsList.getPatientsMap());
        return patient;
    }

}
