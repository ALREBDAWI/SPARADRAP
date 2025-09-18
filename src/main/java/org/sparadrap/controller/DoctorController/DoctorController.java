package org.sparadrap.controller.DoctorController;

import org.sparadrap.model.DoctorModel.Doctor;
import org.sparadrap.model.DoctorModel.DoctorsList;

import java.util.Scanner;

/**
 * Controller class to handle Doctor-related operations.
 * Currently, provides functionality to create and add a new doctor via user input.
 */
public class DoctorController {

    /**
     * Prompts the user for doctor details, creates a Doctor object,
     * and adds it to the DoctorsList.
     *
     * <p>Example of user input:
     * <ul>
     *     <li>Approval Number</li>
     *     <li>First Name</li>
     *     <li>Last Name</li>
     *     <li>Postal Code</li>
     *     <li>Phone Number</li>
     *     <li>Email</li>
     *     <li>Address</li>
     *     <li>City</li>
     * </ul>
     */
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

        // create new doctor object with details given by user
        Doctor doctor = new Doctor(firstName,address,postalCode,city,email,phoneNumber,lastName,approvalNumber);

        // add the new doctor to doctors list
        DoctorsList.addDoctor(doctor);
        System.out.println(DoctorsList.getDoctorsMap());
    }
}
