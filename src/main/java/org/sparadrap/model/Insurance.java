package org.sparadrap.model;

public class Insurance extends AbstractEntity {
    private String department;
    private int coveragePercentage;

    // --------- constructor ---------

    public Insurance(String name, String address, String postalCode, String city, String email, String telephone, String department, int coveragePercentage) {
        super(name, address, postalCode, city, email, telephone);
        setDepartment(department);
        setCoveragePercentage(coveragePercentage);
    }

    // -------- get set ------------

    public String getDepartment() {
        return this.department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public int getCoveragePercentage() {
        return this.coveragePercentage;
    }
    public void setCoveragePercentage(int coveragePercentage) {
        this.coveragePercentage = coveragePercentage;
    }

    // -------- display info -----------

    public void displayInfo() {
        System.out.println("---- Insurance Information ----");
        displayCommonInfo();
        System.out.printf("%-25s: %s%n", "Department", department);
        System.out.printf("%-25s: %d%%%n", "Coverage", coveragePercentage);
        System.out.println("--------------------------------");
    }

    @Override
    public String toString() {

            StringBuilder sb = new StringBuilder();
            sb.append("---- Insurance company Info ----\n");
            sb.append(String.format("%-25s: %s%n", "Name", getName()));
            sb.append(String.format("%-25s: %s%n", "Coverage Percentage", getCoveragePercentage()));
            sb.append(String.format("%-25s: %s%n", "Phone Number", getTelephone() ));
            sb.append(String.format("%-25s: %s%n", "departement", getDepartment()));
            sb.append("--------------------------------\n");
            return sb.toString();
        }
    }


