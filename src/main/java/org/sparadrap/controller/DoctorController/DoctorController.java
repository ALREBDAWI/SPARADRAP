package org.sparadrap.controller.DoctorController;

import org.sparadrap.model.DoctorModel.Doctor;
import org.sparadrap.model.DoctorModel.DoctorsList;

import java.util.Scanner;

public class DoctorController {
    public static void doctorController(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Doctor Approval Number");
        String approvalNumber = sc.nextLine();
        System.out.println("Enter Doctor First Name");
        String firstName = sc.nextLine();
        System.out.println("Enter Doctor Last Name");
        String lastName = sc.nextLine();
        System.out.println("Enter Doctor Postal Code");
        String postalCode = sc.nextLine();
        System.out.println("Enter Doctor Phone Number");
        String phoneNumber = sc.nextLine();
        System.out.println("Enter Doctor Email");
        String email = sc.nextLine();
        System.out.println("Enter Doctor Address");
        String address = sc.nextLine();
        System.out.println("Enter Doctor City");
        String city = sc.nextLine();

        Doctor doctor = new Doctor(firstName,address,postalCode,city,email,phoneNumber,lastName,approvalNumber);
        DoctorsList.addDoctor(doctor);
        System.out.println(DoctorsList.getDoctorsMap());
    }
}
