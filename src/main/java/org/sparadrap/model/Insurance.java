package org.sparadrap.model;

public class Insurance extends AbstractEntity {
    private String department;
    private int coveragePercentage;

    // --------- constructor ---------

    public Insurance(String name, String address, int postalCode, String city, String email, long telephone, String department, int coveragePercentage) {
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

}
