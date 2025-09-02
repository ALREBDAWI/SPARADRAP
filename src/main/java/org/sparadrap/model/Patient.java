package org.sparadrap.model;

import java.time.LocalDate;

public class Patient extends AbstractEntity {
    private long socialSecurityNumber;
    private String lastName;
    private LocalDate dateOfBirth;
    private Doctor treatingDoctor;

    // ---------- constructor -----------

    public Patient(String name, String address, int postalCode, String city, String email, long telephone, long socialSecurityNumber, String lastName, LocalDate dateOfBirth, Doctor treatingDoctor) {
        super(name, address, postalCode, city, email, telephone);
        setSocialSecurityNumber(socialSecurityNumber);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setTreatingDoctor(treatingDoctor);
    }

    // --------- getter and setter ----------

    public long getSocialSecurityNumber() {
        return socialSecurityNumber;
    }
    public void setSocialSecurityNumber(long socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Doctor getTreatingDoctor() {
        return treatingDoctor;
    }
    public void setTreatingDoctor(Doctor treatingDoctor) {
        this.treatingDoctor = treatingDoctor;
    }

    // ------------- print info ----------------

    public void displayInfo() {
            System.out.println("---- Patient Information ----");
            System.out.printf("%-25s: %s%n", "Last Name", lastName);
            displayCommonInfo();
            System.out.printf("%-25s: %d%n", "Social Security Number", socialSecurityNumber);
            System.out.printf("%-25s: %s%n", "Date of Birth", dateOfBirth);
            System.out.printf("%-25s: %s%n", "Treating Doctor", treatingDoctor);
            System.out.println("----------------------------");
    }

}
