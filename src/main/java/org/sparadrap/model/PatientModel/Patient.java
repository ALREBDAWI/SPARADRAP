package org.sparadrap.model.PatientModel;

import org.sparadrap.model.AbstractEntity;
import org.sparadrap.model.DoctorModel.Doctor;
import org.sparadrap.model.InsuranceModel.Insurance;

import java.time.LocalDate;

/**
 * Represents a Patient in the system.
 * Contains details such as social security number, last name, date of birth,
 * treating doctor, insurance, and coverage percentage.
 */
public class Patient extends AbstractEntity {

    private int id;
    /** Social Security Number (13 or 15 digits) */
    private String socialSecurityNumber;
    private String lastName;
    private LocalDate dateOfBirth;

    /** Doctor responsible for treating the patient */
    private Doctor treatingDoctor;

    /** Insurance associated with the patient */
    private Insurance insurance;

    /** Coverage percentage (0–100) */
    private int percentage;

    // ---------- constructor -----------

    /**
     * Creates a new Patient object with all required attributes.
     *
     * @param name First name
     * @param address Address
     * @param postalCode Postal code
     * @param city City
     * @param email Email address
     * @param telephone Phone number
     * @param socialSecurityNumber (13 or 15 digits)
     * @param lastName Last name
     * @param dateOfBirth (cannot be null or in the future)
     * @param treatingDoctor Doctor (cannot be null)
     * @param insurance Insurance associated with the patient (cannot be null)
     * @param percentage Coverage percentage (0–100)
     * @throws IllegalArgumentException if any validation fails
     */
    public Patient(String name, String address, String postalCode, String city, String email, String telephone, String socialSecurityNumber, String lastName, LocalDate dateOfBirth, Doctor treatingDoctor,  Insurance insurance, int percentage) {
        super(name, address, postalCode, city, email, telephone);
        setSocialSecurityNumber(socialSecurityNumber);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setTreatingDoctor(treatingDoctor);
        setInsurance(insurance);
        setPercentage(percentage);
    }

    // ======================================
    // --------- getter and setter ----------
    // ======================================

    public int getId() {
        return this.id;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        String regex = "^\\d{13}(\\d{2})?$";
        if (socialSecurityNumber.matches(regex)) {
            this.socialSecurityNumber = socialSecurityNumber;
        }else{
            throw new IllegalArgumentException("Invalid Social Security Number");
        }
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        String regex = "^\\p{L}+(?:[ '\\-]\\p{L}+)*$";
        if (lastName.matches(regex)) {
            this.lastName = lastName;
        }else{
            throw new IllegalArgumentException("Invalid Last Name");
        }
    }

    /**
     * Returns the full name of the patient (first name + last name).
     */
    public String getFullName(){
        return this.getName()+" "+this.getLastName();
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        if(dateOfBirth == null || dateOfBirth.isAfter(LocalDate.now()))
        {
            throw new IllegalArgumentException("Invalid Date of Birth");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public Doctor getTreatingDoctor() {
        return treatingDoctor;
    }
    public void setTreatingDoctor(Doctor treatingDoctor) {
        if(treatingDoctor == null){
            throw new IllegalArgumentException("Invalid Treating Doctor");
        }
        this.treatingDoctor = treatingDoctor;
    }

    public Insurance getInsurance() {
        return this.insurance;
    }
    public void setInsurance(Insurance insurance) {
        if(insurance == null){
            throw new IllegalArgumentException("Invalid Insurance");
        }
        this.insurance = insurance;
    }
    public int getPercentage() {
        return this.percentage;
    }
    public void setPercentage(int percentage) {
        if(percentage < 0 || percentage > 100){
            throw new IllegalArgumentException("Invalid Percentage");
        } else {
            this.percentage = percentage;
        }
    }

    // ------------- print info ----------------

    /**
     * Returns a formatted string with all patient information.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---- Patient Information ----\n");
        sb.append(String.format("%-25s: %s%n", "Full Name", getFullName()));

        sb.append(String.format("%-25s: %s%n", "Address", getAddress()));
        sb.append(String.format("%-25s: %s%n", "Postal Code", getPostalCode()));
        sb.append(String.format("%-25s: %s%n", "City", getCity()));
        sb.append(String.format("%-25s: %s%n", "Email", getEmail()));
        sb.append(String.format("%-25s: %s%n", "Telephone", getTelephone()));

        sb.append(String.format("%-25s: %s%n", "Social Security Number", socialSecurityNumber));
        sb.append(String.format("%-25s: %s%n", "Date of Birth", dateOfBirth));

        sb.append(String.format("%-25s: %s%n", "Treating Doctor", treatingDoctor.getFullName()));
        sb.append(String.format("%-25s: %s%n", "Insurance company", insurance.getName()));
        sb.append(String.format("%-25s: %s%n", "Coverage percentage", getPercentage()));

        sb.append("----------------------------\n");
        return sb.toString();
    }

}
