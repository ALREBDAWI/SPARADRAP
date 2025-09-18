package org.sparadrap.controller.PatientController;

import org.sparadrap.model.DoctorModel.Doctor;
import org.sparadrap.model.DoctorModel.DoctorsList;
import org.sparadrap.model.InsuranceModel.Insurance;
import org.sparadrap.model.InsuranceModel.InsuranceCompaniesList;
import org.sparadrap.model.PatientModel.Patient;
import org.sparadrap.model.PatientModel.PatientsList;
import org.sparadrap.view.PatientModifyMenu;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Controller class to handle modification of existing patient data.
 * Provides a menu-driven interface for updating patient details.
 */
public class PatientModifyController {
    /**
     * Prompts the user to select a patient by ID, then allows modification
     * of all patient fields including:
     * <ul>
     *     <li>First and Last Name</li>
     *     <li>Address, Postal Code, City</li>
     *     <li>Email and Phone Number</li>
     *     <li>Date of Birth</li>
     *     <li>Social Security Number</li>
     *     <li>Treating Doctor</li>
     *     <li>Insurance Company and Coverage Percentage</li>
     * </ul>
     *
     * <p>The function updates the {@link Patient} object in {@link PatientsList} directly.
     * Displays the updated patient information upon request.
     */
    public static void patientModifyController() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Patient ID:");
        int patientId = sc.nextInt();
        sc.nextLine();

        Patient patient = PatientsList.getPatientById(patientId);
        if (patient == null) {
            System.out.println("No patient found with ID: " + patientId);
            return;
        }

        boolean on = true;
        while (on) {

            PatientModifyMenu.patientModifyMenu();

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0:
                    on = false;
                    break;

                case 1:
                    System.out.println("Enter New Patient First Name:");
                    String firstName = sc.nextLine();
                    patient.setName(firstName);
                    System.out.println("First name updated successfully!");
                    break;

                case 2:
                    System.out.println("Enter New Patient Last Name:");
                    String lastName = sc.nextLine();
                    patient.setLastName(lastName);
                    System.out.println("Last name updated successfully!");
                    break;

                case 3:
                    System.out.println("Enter New Patient Postal Code:");
                    String postalCode = sc.nextLine();
                    patient.setPostalCode(postalCode);
                    System.out.println("Postal code updated successfully!");
                    break;

                case 4:
                    System.out.println("Enter New Patient Phone Number:");
                    String phoneNumber = sc.nextLine();
                    patient.setTelephone(phoneNumber);
                    System.out.println("Phone number updated successfully!");
                    break;

                case 5:
                    System.out.println("Enter New Patient Email:");
                    String email = sc.nextLine();
                    patient.setEmail(email);
                    System.out.println("Email updated successfully!");
                    break;

                case 6:
                    System.out.println("Enter New Patient Address:");
                    String address = sc.nextLine();
                    patient.setAddress(address);
                    System.out.println("Address updated successfully!");
                    break;

                case 7:
                    System.out.println("Enter New Patient City:");
                    String city = sc.nextLine();
                    patient.setCity(city);
                    System.out.println("City updated successfully!");
                    break;

                case 8:
                    System.out.println("Enter New Patient Date of Birth (yyyy-MM-dd):");
                    LocalDate dateOfBirth = LocalDate.parse(sc.nextLine());
                    patient.setDateOfBirth(dateOfBirth);
                    System.out.println("Date of birth updated successfully!");
                    break;

                case 9:
                    System.out.println("Enter New Patient Social Security Number:");
                    String socialSecurityNumber = sc.nextLine();
                    patient.setSocialSecurityNumber(socialSecurityNumber);
                    System.out.println("Social security number updated successfully!");
                    break;

                case 10:
                    DoctorsList.getDoctorsFullNamesList();
                    System.out.println("Enter Treating Doctor ID:");
                    int doctorId = sc.nextInt();
                    sc.nextLine();
                    Doctor treatingDoctor = DoctorsList.getDoctorById(doctorId);
                    if (treatingDoctor != null) {
                        patient.setTreatingDoctor(treatingDoctor);
                        System.out.println("Treating doctor updated successfully!");
                    } else {
                        System.out.println("No doctor found with ID: " + doctorId);
                    }
                    break;

                case 11:
                    InsuranceCompaniesList.getInsuranceCompaniesFullNamesList();
                    System.out.println("Enter Insurance Company ID:");
                    int insuranceId = sc.nextInt();
                    sc.nextLine();
                    Insurance insurance = InsuranceCompaniesList.getInsuranceById(insuranceId);
                    if (insurance != null) {
                        patient.setInsurance(insurance);
                        System.out.println("Insurance company updated successfully!");
                    } else {
                        System.out.println("No insurance company found with ID: " + insuranceId);
                    }
                    break;

                case 12:
                    System.out.println("Enter New Insurance Coverage Percentage:");
                    int insuranceCoveragePercentage = sc.nextInt();
                    sc.nextLine();
                    patient.setPercentage(insuranceCoveragePercentage);
                    System.out.println("Insurance coverage percentage updated successfully!");
                    break;
                case 13:
                    System.out.println("Modified patient: ");
                    System.out.println(patient);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
