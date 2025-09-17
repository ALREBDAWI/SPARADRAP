package org.sparadrap.controller.PatientController;

import org.sparadrap.model.DoctorModel.Doctor;
import org.sparadrap.model.DoctorModel.DoctorsList;
import org.sparadrap.model.InsuranceModel.Insurance;
import org.sparadrap.model.InsuranceModel.InsuranceCompaniesList;
import org.sparadrap.model.InsuranceModel.InsurancePlan;
import org.sparadrap.model.PatientModel.Patient;
import org.sparadrap.model.PatientModel.PatientsList;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PatientController {

    public static Patient patientController(){
            Patient patient = null;

                    try {
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
                            System.out.println("Enter Patient date of birth (yyyy-MM-dd)");
                            LocalDate dateOfBirth = LocalDate.parse(sc.nextLine());

                            DoctorsList.getDoctorsFullNamesList();
                            System.out.println("Enter Patient treating doctor ID");
                            int doctorId = Integer.parseInt(sc.nextLine());
                            Doctor treatingDoctor = DoctorsList.getDoctorById(doctorId);

                            InsuranceCompaniesList.getInsuranceCompaniesFullNamesList();
                            System.out.println("Enter Insurance company ID:");
                            int companyId = Integer.parseInt(sc.nextLine());
                            Insurance insurance = InsuranceCompaniesList.getInsuranceById(companyId);

                            System.out.println("choose insurance plan by typing its number :");
                            ArrayList<InsurancePlan> plans = insurance.getPlans();
                            for (int i = 0; i < plans.size(); i++) {
                                    System.out.println((i+1) + " - " + plans.get(i) + " - " + plans.get(i).getCoverage() + " %");
                            }
                            int choice = Integer.parseInt(sc.nextLine()) - 1;
                            InsurancePlan selectedInsurancePlan = insurance.getPlans().get(choice);
                            int insuranceCoveragePercentage = selectedInsurancePlan.getCoverage();

                            patient = new Patient(firstName,address,postalCode,city,email,phoneNumber,socialSecurityNumber,lastName,dateOfBirth,treatingDoctor,insurance, insuranceCoveragePercentage);
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
                    System.out.println(patient);
                                return patient;
    }
}
