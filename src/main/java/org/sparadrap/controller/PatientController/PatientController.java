package org.sparadrap.controller.PatientController;

import org.sparadrap.model.DoctorModel.Doctor;
import org.sparadrap.model.DoctorModel.DoctorsList;
import org.sparadrap.model.InsuranceModel.Insurance;
import org.sparadrap.model.InsuranceModel.InsuranceCompaniesList;
import org.sparadrap.model.InsuranceModel.InsurancePlan;
import org.sparadrap.model.PatientModel.Patient;
import org.sparadrap.model.PatientModel.PatientsList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Controller class for managing patient-related operations.
 * Currently, provides functionality to create and add a new patient via user input.
 */
public class PatientController {

     /**
     * Prompts the user to input all necessary patient details, including:
     * <ul>
     *     <li>Social Security Number</li>
     *     <li>First and Last Name</li>
     *     <li>Address, Postal Code, City</li>
     *     <li>Email and Phone Number</li>
     *     <li>Date of Birth</li>
     *     <li>Treating Doctor</li>
     *     <li>Insurance Company and Plan</li>
     * </ul>
     *  Then creates a new {@link Patient} object and adds it to the {@link PatientsList}.
     *
     * <p>Handles input validation and displays errors if the data is invalid.
     *
     * @return the created {@link Patient} object, or {@code null} if creation failed
     */
    public static Patient patientController(){
            Patient patient = null;

                    try {
                            Scanner sc = new Scanner(System.in);

                            // ------------------------------
                            // we get patient data from user
                            // ------------------------------

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

                            System.out.println("Enter Patient date of birth (yyyy-MM-dd)");
                            LocalDate dateOfBirth = LocalDate.parse(sc.nextLine());

                            // show all doctors with their id
                            DoctorsList.getDoctorsFullNamesList();
                            System.out.println("Enter Patient treating doctor ID");
                            int doctorId = Integer.parseInt(sc.nextLine());
                            Doctor treatingDoctor = DoctorsList.getDoctorById(doctorId);

                            // show list of insurance companies with id for each
                            InsuranceCompaniesList.getInsuranceCompaniesFullNamesList();
                            System.out.println("Enter Insurance company ID:");
                            int companyId = Integer.parseInt(sc.nextLine());
                            Insurance insurance = InsuranceCompaniesList.getInsuranceById(companyId);

                            // display insurance plans
                            System.out.println("choose insurance plan by typing its number :");
                            ArrayList<InsurancePlan> plans = insurance.getPlans();
                            for (int i = 0; i < plans.size(); i++) {
                                    System.out.println((i+1) + " - " + plans.get(i) + " - " + plans.get(i).getCoverage() + " %");
                            }

                            // get user choice and coverage percentage
                            int choice = Integer.parseInt(sc.nextLine()) - 1;
                            InsurancePlan selectedInsurancePlan = insurance.getPlans().get(choice);
                            int insuranceCoveragePercentage = selectedInsurancePlan.getCoverage();

                            // -------------------------------------------------------------
                            // create new patient object with all the data provided by user
                            // -------------------------------------------------------------

                            patient = new Patient(
                                    firstName,
                                    address,
                                    postalCode,
                                    city,
                                    email,
                                    phoneNumber,
                                    socialSecurityNumber,
                                    lastName,dateOfBirth,
                                    treatingDoctor,
                                    insurance,
                                    insuranceCoveragePercentage
                            );

                            // add to patients list
                            PatientsList.addPatient(patient);

                            System.out.println("Patient has been added seccessfully!");

                            }catch(InputMismatchException e){
                                    System.out.println("Please enter correct data - " + e.getMessage());
                            }catch (IllegalArgumentException e){
                                    System.out.println("Please enter correct data - " + e.getMessage());
                            }
                            catch (Exception e){
                                    System.out.println("Something went wrong - " + e.getMessage());
                            }

                            // show added patient details
                            System.out.println(patient);
                            return patient;
    }
}
