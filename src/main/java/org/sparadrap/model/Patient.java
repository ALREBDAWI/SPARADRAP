package org.sparadrap.model;

import java.time.LocalDate;

public class Patient extends AbstractEntity {
    private String socialSecurityNumber;
    private String lastName;
    private LocalDate dateOfBirth;
    private Doctor treatingDoctor;
    private Insurance insurance;
    private int percentage;

    // ---------- constructor -----------

    public Patient(String name, String address, String postalCode, String city, String email, String telephone, String socialSecurityNumber, String lastName, LocalDate dateOfBirth, Doctor treatingDoctor,  Insurance insurance, int percentage) {
        super(name, address, postalCode, city, email, telephone);
        setSocialSecurityNumber(socialSecurityNumber);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setTreatingDoctor(treatingDoctor);
        setInsurance(insurance);
        setPercentage(percentage);
    }

    // --------- getter and setter ----------

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

    public void displayInfo() {
            System.out.println("---- Patient Information ----");
            System.out.printf("%-25s: %s%n", "Last Name", lastName);
            displayCommonInfo();
            System.out.printf("%-25s: %s%n", "Social Security Number", socialSecurityNumber);
            System.out.printf("%-25s: %s%n", "Date of Birth", dateOfBirth);
            System.out.printf("%-25s: %s%n", "Treating Doctor", treatingDoctor);
            System.out.println("----------------------------");
    }

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
        sb.append(String.format("%-25s: %s%n", "Coverage percentage", getPercentage()));

        sb.append("----------------------------\n");
        return sb.toString();
    }


}
