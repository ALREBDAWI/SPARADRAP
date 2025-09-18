package org.sparadrap.model.DoctorModel;

import org.sparadrap.model.AbstractEntity;

/**
 * The Doctor entity.
 * Inherits from {@link AbstractEntity} and adds specific fields:
 * - Last name
 * - Approval number
 */
public class Doctor extends AbstractEntity {

    private  String lastName;
    private  String approvalNumber ;

    // --------------------------------
    // ---------- constructor ---------
    // --------------------------------

    /**
     * Constructor of new Doctor object with all required attributes.
     *
     * @param name          First name
     * @param address       Doctor office address
     * @param postalCode    Postal code
     * @param city          City
     * @param email         Email address
     * @param telephone     Phone number
     * @param lastName      Last name; only letters, spaces, apostrophes, or hyphens allowed
     * @param approvalNumber Approval/registration number; alphanumeric, 5-15 characters
     * @throws IllegalArgumentException if lastName or approvalNumber are invalid
     */
    public Doctor(String name, String address, String postalCode, String city, String email, String telephone, String lastName, String approvalNumber) {
        super(name, address, postalCode, city, email, telephone);
        setLastName(lastName);
        setApprovalNumber(approvalNumber);
    }

    // -------------------------------------------
    // ---------- getters and setters ------------
    // -------------------------------------------

    /**
     * Returns doctor last name.
     *
     * @return last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the doctor's last name after validating it.
     *
     * @param lastName the last name to set
     * @throws IllegalArgumentException if the last name is invalid
     */
    public void setLastName(String lastName) {
        // Only letters, spaces, apostrophes, and hyphens are allowed
        String regex = "^\\p{L}+(?:[ '\\-]\\p{L}+)*$";
        if (lastName.matches(regex)) {
            this.lastName = lastName;
        }else{
            throw new IllegalArgumentException("Invalid last name");
        }
    }

    /**
     * Returns full name (first name + last name).
     *
     * @return full name
     */
    public String getFullName(){
        return this.getName() + " " + this.getLastName();
    }

    /**
     * Returns approval number.
     *
     * @return approval number
     */
    public String getApprovalNumber() {
        return this.approvalNumber;
    }

    /**
     * Sets approval number after validating it.
     *
     * @param approvalNumber the approval number to set
     * @throws IllegalArgumentException if the approval number is invalid
     */
    public void setApprovalNumber(String approvalNumber) {
        // Regex allows alphanumeric characters, underscores, and hyphens (length 5–15)
        String regex = "^[A-Za-z0-9_-]{5,15}$";
        if (approvalNumber.matches(regex)) {
            this.approvalNumber = approvalNumber;
        }else{
            throw new IllegalArgumentException("Invalid approval number");
        }
    }

    // ---------- info ---------------

    /**
     * Returns a formatted string containing all doctor information.
     *
     * @return string with doctor details
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---- Doctor Information ----\n");
        sb.append(String.format("%-25s: %s%n", "Name", getFullName()));
        sb.append(String.format("%-25s: %s%n", "Address", getAddress()));
        sb.append(String.format("%-25s: %s%n", "Postal Code", getPostalCode()));
        sb.append(String.format("%-25s: %s%n", "City", getCity()));
        sb.append(String.format("%-25s: %s%n", "Email", getEmail()));
        sb.append(String.format("%-25s: %s%n", "Phone Number", getTelephone()));
        sb.append(String.format("%-25s: %s%n", "Approval Number", getApprovalNumber()));
        sb.append("--------------------------------\n");
        return sb.toString();
    }


}



