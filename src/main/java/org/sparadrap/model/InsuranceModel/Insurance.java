package org.sparadrap.model.InsuranceModel;

import org.sparadrap.model.AbstractEntity;

import java.util.ArrayList;
import java.util.HashMap;

public class Insurance extends AbstractEntity {
    private String department;
    private ArrayList<InsurancePlan> plans;

    // --------- constructor ---------

    public Insurance(String name, String address, String postalCode, String city, String email, String telephone, String department, ArrayList<InsurancePlan> plans) {
        super(name, address, postalCode, city, email, telephone);
        this.plans = plans;
        setDepartment(department);

    }

    // -------- get set ------------

    public String getDepartment() {
        return this.department;
    }
    public void setDepartment(String department) {
        String regex = "^(0[1-9]|[1-8][0-9]|9[0-5]|2A|2B)$";
        if (department.matches(regex)) {
            this.department = department;
        }else{
            throw  new IllegalArgumentException("Department is not valid");
        }
    }

    public ArrayList<InsurancePlan> getPlans() {
        return this.plans;
    }

    public void addPlan(InsurancePlan plan) {
        plans.add(plan);
    }


    // -------- display info -----------

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


