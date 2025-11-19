package org.sparadrap.model.InsuranceModel;

import org.sparadrap.model.AbstractEntity;

import java.util.ArrayList;

/**
 * Represents an Insurance company in the system.
 * Inherits from {@link AbstractEntity} and contains:
 * - department (French administrative code)
 * - a list of insurance plans
 */
public class Insurance extends AbstractEntity {
    private int id;
    private String department;

    /** List of insurance plans associated with this company */
    private ArrayList<InsurancePlan> plans;

    // -------------------------------
    // --------- constructor ---------
    // -------------------------------

    /**
     * Creates a new Insurance object with all required attributes.
     *
     * @param name       Name of the insurance company
     * @param address    Address
     * @param postalCode Postal code
     * @param city       City
     * @param email      Email address
     * @param telephone  Phone number
     * @param department Department code (e.g., "75", "2A", "2B")
     * @param plans      List of insurance plans
     * @throws IllegalArgumentException if the department code is invalid
     */
    public Insurance(String name, String address, String postalCode, String city, String email, String telephone, String department, ArrayList<InsurancePlan> plans) {
        super(name, address, postalCode, city, email, telephone);
        this.plans = plans;
        setDepartment(department);
    }

    // =========================================
    // ---------- Getters and Setters ----------
    // =========================================

    public int getId() {
        return this.id;
    }

    /**
     * Returns the department code of the insurance company.
     *
     * @return department code
     */
    public String getDepartment() {
        return this.department;
    }

    /**
     * Sets the department code after validating it against French department codes.
     *
     * @param department department code (e.g., "75", "2A", "2B")
     * @throws IllegalArgumentException if the department code is invalid
     */
    public void setDepartment(String department) {
        String regex = "^(0[1-9]|[1-8][0-9]|9[0-5]|2A|2B)$";
        if (department.matches(regex)) {
            this.department = department;
        }else{
            throw  new IllegalArgumentException("Department is not valid");
        }
    }

    /**
     * Returns the list of insurance plans associated with this company.
     *
     * @return ArrayList of InsurancePlan
     */
    public ArrayList<InsurancePlan> getPlans() {
        return this.plans;
    }

    /**
     * Adds a new insurance plan to the company plan list.
     *
     * @param plan InsurancePlan object to add
     */
    public void addPlan(InsurancePlan plan) {
        plans.add(plan);
    }


    // -------- display info -----------

    /**
     * Returns a formatted string containing all insurance company information.
     *
     * @return string with insurance company details
     */
    @Override
    public String toString() {

            StringBuilder sb = new StringBuilder();
        sb.append("---- Insurance company Info ----\n");
        sb.append(String.format("%-25s: %s%n", "Name", getName()));
        sb.append(String.format("%-25s: %s%n", "Address", getAddress()));
        sb.append(String.format("%-25s: %s%n", "Postal Code", getPostalCode()));
        sb.append(String.format("%-25s: %s%n", "City", getCity()));
        sb.append(String.format("%-25s: %s%n", "Email", getEmail()));
        sb.append(String.format("%-25s: %s%n", "Phone Number", getTelephone()));
        sb.append(String.format("%-25s: %s%n", "Department", getDepartment()));
        sb.append("--------------------------------\n");
            return sb.toString();
        }
    }


